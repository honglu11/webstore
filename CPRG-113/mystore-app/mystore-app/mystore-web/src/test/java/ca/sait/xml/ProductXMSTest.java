/**
 * 
 */
package ca.sait.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.sait.dto.Person;
import ca.sait.dto.Product;
import ca.sait.myStore.HasLogger;

/**
 * @author honglu
 *
 */
public class ProductXMSTest implements HasLogger {
    
    private static JAXBContext context;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;
    
    @BeforeAll
    public static void setup() throws Exception{
        context = JAXBContext.newInstance(Product.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        unmarshaller = context.createUnmarshaller();
    }
    
    @Test
    public void marshallTest() throws Exception {
        final UUID oid = UUID.randomUUID();
        final String name = "computer";
        final String description = "work station";
        final Double price = 1100.00;
        final Product product = new Product(oid, name, description, price);
        
        final StringWriter sw = new StringWriter();
        marshaller.marshal(product, sw);
        
        logger().info("{}", sw.toString());
    }
    
    @Test
    public void unmarshallTest() throws Exception {
        final String xml = 
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n" + 
                "<product oid=\"fe843d7d-7be2-47c8-908a-64ca868db182\">\r\n" + 
                "    <name>computer</name>\r\n" + 
                "    <description>work station</description>\r\n" + 
                "    <price>1100.0</price>\r\n" + 
                "</product>";
        
        final StringReader sr = new StringReader(xml);
        final Product product = (Product)unmarshaller.unmarshal(sr);
        
        logger().info("Product: {}", product.getName());
    }

}
