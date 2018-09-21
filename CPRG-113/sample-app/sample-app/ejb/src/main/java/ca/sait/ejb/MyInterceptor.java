/**
 * 
 */
package ca.sait.ejb;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author honglu
 *
 */
public class MyInterceptor implements HasLogger {
    @AroundInvoke
    public Object ourInterceptorMethod(InvocationContext context) throws Exception {
        logger().trace("ENTER ourInterceptorMethod(InvocationContext context)");
        // can do whatever we want before proceed.
        try { 
            logger().debug("Target: {}", context.getTarget());
            logger().debug("Method Name: {}", context.getMethod().getName());
            logger().debug("Return Type: {}", context.getMethod().getReturnType().getName());
            
            if (context.getParameters() != null) {
                logger().debug("Parameters: "); 
                for (Class<?> paramType : context.getMethod().getParameterTypes()) {
                    logger().debug("Parameter Type: {}", paramType.toString());
                }
                for (Object parameter : context.getParameters()) {
                    logger().debug("Parameter Value: {}", parameter.toString());
                }
            }else {
                
                logger().debug("Method has no parameters");
            }
            final Object returnObj = context.proceed();
            // mutiplies dependencies, like one app sit on 20 database, context proceed easy to swap the dependency.
            // do some more work
            return returnObj;
            
        } finally {
        logger().trace("EXIT ourInterceptorMethod(InvocationContext context)");
        }
    }

}