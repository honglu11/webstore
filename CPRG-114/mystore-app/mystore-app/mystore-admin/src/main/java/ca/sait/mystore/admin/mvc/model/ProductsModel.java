/**
 * 
 */
package ca.sait.mystore.admin.mvc.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sait.dto.Product;
import ca.sait.services.NoEntityFoundException;
import ca.sait.services.NonUniqueException;
import ca.sait.services.ProductService;
import ca.sait.services.ValidationException;

/**
 *
 */
@Named("Products")
@RequestScoped
public class ProductsModel extends AbstractModel {
    
    @Inject private ProductService productService;  
    private Product product;
   

    public ProductsModel() {
        logger().trace("ENTER ProductsModel()");
        logger().trace("EXIT ProductsModel()");
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
        
//        try {
//            final String [] resources = request.getRequestURI().substring(request.getContextPath().length()).split("/");//request.getRequestURI().split("/");
//            for (String resource : resources) {
//                logger().debug("Resource: {}", resource);
//            }
//            
//            try  {
//            setOid( UUID.fromString(resources[resources.length-1]));
//            } catch(final IllegalArgumentException ex) {
//                // sillence
//            }
//            
//            final String action = request.getParameter("action");
//            if ("persist".equals(action)) {
//                persist(request);
//            }
        try {
            final String action = request.getParameter("action");
            if ("persist".equals(action)) {
              persist(request);
            }
            
            if ("delete".equals(action)) {
                logger().info("will delete");
                delete(request);                
            }
              
            return "/WEB-INF/jsp/products.jsp";
        } finally {
            logger().trace("EXIT process(request,resposne)");
        }
    }
    
    private void delete(HttpServletRequest request) {
        logger().trace("ENTER delete(request)");
        String oid = null;
        logger().info("request.getParameter(\"oid\") " + request.getParameter("oid"));
        if (request.getParameter("oid") != null) {
            oid = request.getParameter("oid");
        } else {
            setErrorMessage("Oid is empty, must select a product oid for delete");
        }

        if (oid != null && !oid.trim().isEmpty()) {
        
        try {
          
            productService.removeProduct(UUID.fromString(oid));
 
        } catch (NoEntityFoundException e) {
            setErrorMessage("Cannot delete none exsit product: " + e);
        }
        setSuccessMessage("Delete this product successfully");
        }

        logger().trace("EXIT delete(request)");

    }
    
    private void persist(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String description = request.getParameter("description");
        final String priceTmp = request.getParameter("price");
        final String inventoryQuantityTmp = request.getParameter("inventoryQuantity");      
        
        try {
            Double price = null;
            
            try {
                price = Double.parseDouble(priceTmp);
            } catch (final NumberFormatException ex) {
                getErrors().put("price", priceTmp + " is not a valid number");
            }
            
            Integer inventoryQuantity = null;
            
            try {
                inventoryQuantity = Integer.parseInt(inventoryQuantityTmp);
            } catch (final NumberFormatException ex) {
                getErrors().put("inventoryQuantity", inventoryQuantityTmp + " is not a valid number");
            }
   
//            Double price = priceTmp == null ? null : Double.parseDouble(priceTmp);
//            final Integer inverntoryQuantity = inventoryQuantityTmp == null ? null : Integer.parseInt(inventoryQuantityTmp);
            product = new Product(getOid(), name, description, price, inventoryQuantity); // hold the information
            
            if (getErrors().isEmpty()) {
            setOid(productService.persist(product));
            setSuccessMessage("Updated");
            } else {
              setErrorMessage("Data Error Issues");
            }
            //request.setAttribute("SUCCESS_MESSAGE", "Updated");
          } catch (final ValidationException ex) {
            ex.getValidationErrors().forEach(getErrors()::put);
            setErrorMessage(ex.getMessage());
            //request.setAttribute("ERROR_MESSAGE", ex.getMessage());
        } catch (final NonUniqueException ex) {
            setErrorMessage(ex.getMessage());
            //request.setAttribute("ERROR_MESSAGE", ex.getMessage());
        }
        
//        if ("good".equals(name)) {
//           request.setAttribute("SUCCESS_MESSAGE", "This will be a success message");
//        } else if ("bad".equals(name)) {
//           request.setAttribute("ERROR_MESSAGE", "This will be a error message");
//        }
    }
    
    @Override
    public String getNavigationName() {
        return "PRODUCTS";
    }
    
    //${Products.product.oid} Products is model name, product is getProduct without get and lower case of Product of getProduct.
    
    // when product != null is when we create product and click submit button
    public Product getProduct() {
        if (getOid() != null && product ==null) {                   
            try {
               product =  productService.findById(getOid());
            } catch (NoEntityFoundException ex) {
               setErrorMessage("Entity not found: " + getOid());
            }
        }
        
        return product;
        
//        if (getOid() == null) {
//            return new Product();
//        } else {
//            try {
//               return productService.findById(getOid());
//            } catch (NoEntityFoundException ex) {
//                logger().error("Entity not found: {}", getOid());
//                return new Product();
//            }
//        }
    }
    
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
    


}