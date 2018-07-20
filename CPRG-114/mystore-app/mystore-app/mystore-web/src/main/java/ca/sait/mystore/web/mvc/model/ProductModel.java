/**
 * 
 */
package ca.sait.mystore.web.mvc.model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.dto.Product;
import ca.sait.services.NoEntityFoundException;
import ca.sait.services.ProductService;

/**
 *
 */
@Named("Product")
@RequestScoped
public class ProductModel extends AbstractModel {
    
    @Inject private ProductService productService;  
    private Product product;
    
    public ProductModel() {
        logger().trace("ENTER ProductModel()");
        logger().trace("EXIT ProductModel()");
    }
    
    @PostConstruct
    private void postConstruct() {
        logger().trace("ENTER postConstruct()");
        logger().trace("EXIT postConstruct()");
    }

    /* (non-Javadoc)
     * @see ca.sait.mystore.web.mvc.model.AbstractView#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected String process(HttpServletRequest request, HttpServletResponse response) {
        logger().trace("ENTER process(request,resposne)");
        
        try {
            return "/WEB-INF/jsp/product.jsp";
        } finally {
            logger().trace("EXIT process(request,resposne)");
        }
    }

    @Override
    public String getNavigationName() {
        return "PRODUCT";
    }
    
    public Product getProduct() {
        if (getOid() != null && product ==null) {                   
            try {
               product =  productService.findById(getOid());
            } catch (NoEntityFoundException ex) {
               setErrorMessage("Entity not found: " + getOid());
            }
        }
        
        return product;
    }
}
