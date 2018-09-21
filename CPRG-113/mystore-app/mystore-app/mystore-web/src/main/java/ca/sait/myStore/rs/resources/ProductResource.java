/**
 * 
 */
package ca.sait.myStore.rs.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import ca.sait.dto.Person;
import ca.sait.dto.Product;
import ca.sait.myStore.HasLogger;
import ca.sait.myStore.rs.InvalidUUIDException;
import ca.sait.myStore.rs.ResultNotFoundException;
import ca.sait.services.NoEntityFoundException;
import ca.sait.services.ProductService;

/**
 * @author honglu
 *
 */
@Path("/product")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ProductResource implements HasLogger {
    
    @EJB
    private ProductService productService;
    
    @GET
    public Product[] getAll() {
        final List<Product> products = productService.findAll();
        final Product[] results = new Product[products.size()];
        return products.toArray(results); 
    }

 
    @GET
    @Path("{uuid}")
    public Product getProduct(@PathParam("uuid") String uuid) throws ResultNotFoundException, InvalidUUIDException {
        logger().trace("ENTER getProduct()");
        logger().debug("Submit UUID: {}", uuid);
        try {
            final Product product = productService.findById(UUID.fromString(uuid));
            return product;
        } catch (final IllegalArgumentException ex) {
            throw new InvalidUUIDException("Invalid uuid " + uuid);
        }  catch(final NoEntityFoundException ex) {
            throw new ResultNotFoundException("Cannot find uuid " + uuid);
        }  finally {
            logger().trace("EXIT getProduct()");
        }
    }
    
    @GET
    @Path("name/{name}")
    public Product getProductByName(@PathParam("name") String name) throws ResultNotFoundException {
        logger().trace("ENTER getProduct()");
        logger().debug("Submit name: {}", name);
        try {
            final Product product = productService.findByName(name);
            return product;
        } catch(final NoEntityFoundException ex) {
            throw new ResultNotFoundException("Cannot find the name " + name);
        }
        finally {
            logger().trace("EXIT getProduct()");
        }
    }
    
    @DELETE
    @Path("{uuid}")
    public Response deleteProduct(@PathParam("uuid") String uuid, @Context UriInfo uriInfo) throws ResultNotFoundException, InvalidUUIDException {
        logger().trace("ENTER deleteProduct()");
        logger().debug("Submit UUID: {}", uuid);
        try {
            final UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            final URI uri = builder.build();
            productService.removeProduct(UUID.fromString(uuid));
            return Response.status(HttpServletResponse.SC_NO_CONTENT).location(uri).build();
        } catch (final IllegalArgumentException ex) {
            throw new InvalidUUIDException("Invalid uuid " + uuid);
        }  catch(final NoEntityFoundException ex) { 
            throw new ResultNotFoundException("Cannot find uuid " + uuid);
        } finally {
            logger().trace("EXIT deleteProduct()");
        }
    }
    
    @PUT
    public Response createProduct(Product product, @Context UriInfo uriInfo) {
        
        logger().trace("ENTER createProduct()");
        logger().debug("Submit Product Name: {}", product.getName());
        try {
            final UriBuilder builder = uriInfo.getAbsolutePathBuilder();
            final UUID uuid = productService.create(product);
            final URI uri = builder.path(uuid.toString()).build();
            return Response.created(uri).build();

        } finally {
            logger().trace("EXIT createProduct()");
        }
        
    }

}
