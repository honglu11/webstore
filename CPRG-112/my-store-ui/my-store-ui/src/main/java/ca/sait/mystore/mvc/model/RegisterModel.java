/**
 * 
 */
package ca.sait.mystore.mvc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mystore.entity.Person;

/**
 *
 */
@Model
public class RegisterModel extends ViewModel {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private Person person;
    private String title;
    private String registerError;
    private boolean hasRegistered;

    private Map<String, String> inputErrors = new HashMap<>();

    @Inject
    private Validator validator;

    @PersistenceContext
    private EntityManager entityManager;
    @Resource
    private UserTransaction transaction;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.trace("ENTER handle(request, response)");

        title = "Register Person";
        try {
            final String action = request.getParameter("action");
            logger.debug("action: {}", action);
            if (action != null) {
                switch (action.toLowerCase()) {
                case "register":
                    register(request);
                    break;
                default:
                    logger.warn("Unknown action: {}", action);
                }
            }
        } catch (final Exception ex) {
            logger.error(ex.getMessage(), ex);
            registerError = ex.getMessage();
        } finally {
            if (transaction.getStatus() == Status.STATUS_ACTIVE && !inputErrors.isEmpty())
                transaction.setRollbackOnly();
        }

        logger.trace("EXIT handle(request, response)");
    }

    public void register(HttpServletRequest request) throws IllegalStateException, SystemException {
        logger.trace("ENTER register(request)");

        hasRegistered = false;
        String firstName = request.getParameter("firstName");
        logger.debug(request.getParameter("firstName"));

        if (firstName != null && firstName.trim().isEmpty())
            firstName = null;
        String lastName = request.getParameter("lastName");
        if (lastName != null && lastName.trim().isEmpty())
            lastName = null;
        String email = request.getParameter("email");
        if (email != null && email.trim().isEmpty())
            email = null;
        String password = request.getParameter("password");
        if (password != null && password.trim().isEmpty())
            password = null;
        String confirmPassword = request.getParameter("confirmPassword");
        if (confirmPassword != null && confirmPassword.trim().isEmpty())
            confirmPassword = null;
        if (confirmPassword == null) {
            inputErrors.put("confirmPassword", "Confirm Password cannot be empty!");
            registerError = "Confirm Password cannot be empty!";
        }
        if (password != null && confirmPassword != null) {
            if (!confirmPassword.equals(password)) {
                inputErrors.put("confirmPassword", "Confirm Password is not the same as Password!");
                registerError = "Confirm Password is not the same as Password!";
                return;
            }
        }

        person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setEmail(email);
        person.setPassword(password);
        person.setRole("Guest");

        final Set<ConstraintViolation<Person>> issues = validator.validate(person);
        boolean isPersonExist = false;

        if (person.getOid() == null) {
            registerError = "Register New Person With Unique Email";
            final TypedQuery<Person> query = retrieveExistingPersonByEmail();

            try {
                final Person p = query.getSingleResult();
                inputErrors.put("email", "Already Exists");
                registerError = "Unable to register new person";
                isPersonExist = true;
            } catch (final NoResultException ex) {
                isPersonExist = false;
            }
        }

        if (issues.isEmpty() && !isPersonExist) {

            if (person.getOid() == null) {
                entityManager.persist(person);
                logger.debug("entityManager.persist(person)");
                final TypedQuery<Person> query = retrieveExistingPersonByEmail();
                try {
                    final Person p = query.getSingleResult();
                    if (p.equals(person)) {
                        registerError = "Register New Person Successfully";
                        hasRegistered = true;
                    }
                } catch (final NoResultException ex) {
                    registerError = "Register New Person Failed";
                    hasRegistered = false;
                }
            } else {
                logger.debug("Registered OID: {}", person.getOid().toString());
                registerError = "Unable to register new person";
            }
        } else {
            issues.forEach(issue -> {
                final String attributeName = issue.getPropertyPath().toString();
                final String errorMsg = issue.getMessage();

                logger.debug("Attribute Name: {})", attributeName);
                logger.debug("Error Message: {})", errorMsg);

                inputErrors.put(attributeName, errorMsg);

            });
        }

    }
     
    private TypedQuery<Person> retrieveExistingPersonByEmail() {
        logger.trace("ENTER retrieveExistingPersonByEmail()");

        final TypedQuery<Person> query = entityManager.createNamedQuery(Person.FIND_BY_EMAIL, Person.class);
        query.setParameter("email", person.getEmail());
        logger.trace("EXIT retrieveExistingPersonByEmail()");
        return query;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person
     *            the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the registerError
     */
    public String getRegisterError() {
        return registerError;
    }

    /**
     * @param registerError
     *            the registerError to set
     */
    public void setRegisterError(String registerError) {
        this.registerError = registerError;
    }

    /**
     * @return the inputErrors
     */
    public Map<String, String> getInputErrors() {
        return inputErrors;
    }

    /**
     * @param inputErrors
     *            the inputErrors to set
     */
    public void setInputErrors(Map<String, String> inputErrors) {
        this.inputErrors = inputErrors;
    }
    
    /**
     * @return the hasRegistered
     */
    public boolean getHasRegistered() {
        return hasRegistered;
    }
}
