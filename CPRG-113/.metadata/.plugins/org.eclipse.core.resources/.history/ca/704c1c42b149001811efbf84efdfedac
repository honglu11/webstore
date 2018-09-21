/**
 * 
 */
package ca.sait.mystore.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author celias
 *
 */
@Provider
public class ResultNotFoundMapper 
implements ExceptionMapper<ResultNotFoundException> {

    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(ResultNotFoundException exception) {
        final ErrorMessage errorMsg =
                new ErrorMessage(Status.NOT_FOUND.getStatusCode(), 
                        ResultNotFoundException.CODE, exception.getMessage());
        
        return Response.status(Status.NOT_FOUND)
                .entity(errorMsg).build();
    }

}
