/**
 * 
 */
package ca.sait.jpa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.ejb.AfterBegin;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDataSource;
import org.hibernate.Interceptor;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.junit.jupiter.api.BeforeEach;

import ca.sait.mystore.HasLogger;

/**
 * @author Chris Elias
 *
 */
public abstract class AbstractJPATest implements HasLogger {

    private EntityManagerFactory emf;
    
    @BeforeEach
    public void init() {
        logger().trace("ENTER init()");
        
        emf = newEntityManagerFactory();
        
        logger().trace("EXIT init()");
    }
    
    protected void afterInit() {

    }
    
    @AfterBegin
    public void destroy() {
        emf.close();
    }

    /**
     * 
     * @return
     */
    protected abstract Class<?>[] entities();
    
    /**
     * 
     * @return
     */
    protected List<String> entityClassNames() {
        return Arrays.asList(entities()).stream().map(Class::getName).collect(Collectors.toList());
    }
    
    /**
     * 
     * @return
     */
    protected String[] packages() {
        return null;
    }

    /**
     * 
     * @return
     */
    protected String[] resources() {
        return null;
    }

    /**
     * 
     * @return
     */
    protected Interceptor interceptor() {
        return null;
    }
    
    /**
     * 
     * @return
     */
    protected EntityManagerFactory newEntityManagerFactory() {
        logger().trace("ENTER newEntityManagerFactory()");
        
        try {
            final PersistenceUnitInfo persistenceUnitInfo = persistenceUnitInfo(getClass().getSimpleName());
            final Map<String, Object> configuration = new HashMap<>();
            
            final EntityManagerFactoryBuilderImpl entityManagerFactoryBuilder = new EntityManagerFactoryBuilderImpl(
                new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration
            );
            
            return entityManagerFactoryBuilder.build();
        } finally {
            logger().trace("EXIT newEntityManagerFactory()");
        }
    }
    
    /**
     * 
     * @param name
     * @return
     */
    protected PersistenceUnitInfoImpl persistenceUnitInfo(String name) {
        PersistenceUnitInfoImpl persistenceUnitInfo = new PersistenceUnitInfoImpl(
            name, entityClassNames(), properties()
        );
        String[] resources = resources();
        if (resources != null) {
            persistenceUnitInfo.getMappingFileNames().addAll(Arrays.asList(resources));
        }
        return persistenceUnitInfo;
    }

    /**
     * 
     * @return
     */
    protected Properties properties() {
        Properties properties = new Properties();
        
        properties.put("hibernate.dialect", "org.hibernate.dialect.DerbyTenSevenDialect");
        //log settings
        properties.put("hibernate.hbm2ddl.auto", "update");
        //data source settings
        DataSource dataSource = newDataSource();
        if (dataSource != null) {
            properties.put("hibernate.connection.datasource", dataSource);
        }
        
        properties.put("hibernate.generate_statistics", Boolean.TRUE.toString());
        //properties.put("hibernate.ejb.metamodel.population", "disabled");
        
        additionalProperties(properties);
        return properties;
    }

    /**
     * 
     * @param properties
     */
    protected void additionalProperties(Properties properties) {

    }    
    
    /**
     * 
     * @return
     */
    protected DataSource newDataSource() {
        final ClientDataSource dataSource = new ClientDataSource();
        dataSource.setDatabaseName("mystore");
        dataSource.setUser("app");
        dataSource.setPassword("app");
        
        return dataSource;
    }
    
    /**
     * 
     * @param function
     * @return
     */
    protected <T> T jpa(JPATransactionFunction<T> function) {
        T result = null;
        EntityManager entityManager = null;
        EntityTransaction txn = null;
        try {
            entityManager = emf.createEntityManager();
            function.beforeTransactionCompletion();
            txn = entityManager.getTransaction();
            txn.begin();
            result = function.apply(entityManager);
            if ( !txn.getRollbackOnly() ) {
                txn.commit();
            }
            else {
                try {
                    txn.rollback();
                }
                catch (Exception e) {
                    logger().error( "Rollback failure", e );
                }
            }
        } catch (Throwable t) {
            if ( txn != null && txn.isActive() ) {
                try {
                    txn.rollback();
                }
                catch (Exception e) {
                    logger().error( "Rollback failure", e );
                }
            }
            throw t;
        } finally {
            function.afterTransactionCompletion();
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return result;
    }

    protected void jpa(JPATransactionVoidFunction function) {
        logger().debug("ENTER jpa(function) ");
        
        EntityManager entityManager = null;
        EntityTransaction txn = null;
        
        try {
            entityManager = emf.createEntityManager();
            function.beforeTransactionCompletion();
            txn = entityManager.getTransaction();
            txn.begin();
            function.accept(entityManager);
            if ( !txn.getRollbackOnly() ) {
                txn.commit();
            }
            else {
                try {
                    txn.rollback();
                }
                catch (Exception e) {
                    logger().error( "Rollback failure", e );
                }
            }
        } catch (Throwable t) {
            if ( txn != null && txn.isActive() ) {
                try {
                    txn.rollback();
                }
                catch (Exception e) {
                    logger().error( "Rollback failure", e );
                }
            }
            throw t;
        } finally {
            function.afterTransactionCompletion();
            if (entityManager != null) {
                entityManager.close();
            }
            
            logger().debug("EXIT jpa(function) ");
        }
    }    
}
