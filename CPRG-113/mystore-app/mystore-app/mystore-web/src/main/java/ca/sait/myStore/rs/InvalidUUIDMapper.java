/**
 * 
 */
package ca.sait.myStore.rs;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author celias
 *
 */
@Provider
public class InvalidUUIDMapper 
implements ExceptionMapper<InvalidUUIDException> {

    /* (non-Javadoc)
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    @Override
    public Response toResponse(InvalidUUIDException exception) {
        final ErrorMessage errorMsg =
                new ErrorMessage(Status.BAD_REQUEST.getStatusCode(), 
                        InvalidUUIDException.CODE, exception.getMessage());
        
        return Response.status(Status.BAD_REQUEST)
                .entity(errorMsg).build();
    }

}
