package ca.sait.mvc.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.sait.mvc.model.PersonDetailsFrom;

/**
 * Servlet implementation class PersonControllerServlet
 */
@WebServlet(name="PersonController", urlPatterns= {"/person"})
public class PersonControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logger logger = LoggerFactory.getLogger(getClass());
    // @Inject will create person instance for us and destroy when done. controll
    // person life cycle
    @Inject
    private PersonDetailsFrom person;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    // http://localhost:8280/introServlet/person?firstName=Hong&lastName=Lu&action=add
    // http://localhost:8280/introServlet/person?firstName=Hong&lastName=Lu
    // http://localhost:8280/introServlet/person?action=add
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.trace("ENTER doGet(HttpServletRequest request, HttpServletResponse response)");

        final String action = request.getParameter("action");
        final RequestDispatcher requestDispatcher;
        // model information
        // lefthand never null, the action null is ok, won't have null pointer exception
        if ("add".equalsIgnoreCase(action)) {
            // final Person person = new Person();
//            person.setFirstName(request.getParameter("firstname"));
//            person.setLastName(request.getParameter("lastname"));
            person.handle(request, response);

            // Since the Person is inject, don't need setAttribute into request
            // request.setAttribute("person", person);

            if (person.isValid()) {
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personDetails.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personForm.jsp");
            }

        } else {
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personForm.jsp");
        }

        requestDispatcher.forward(request, response);

        logger.trace("EXIT doGet(HttpServletRequest request, HttpServletResponse response)");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.trace("ENTER doPost(HttpServletRequest request, HttpServletResponse response)");
        doGet(request, response);
        logger.trace("EXIT doPost(HttpServletRequest request, HttpServletResponse response)");
    }

}
