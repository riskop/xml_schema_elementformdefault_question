package pack;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;

public class ValidationTest {

    @Test
    public void testQualified() throws Exception {
        Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                new Source[] {
                    new StreamSource(getClass().getResourceAsStream("/shiporder_qualified.xsd"))
            });
        schema.newValidator().validate(new StreamSource(new File("src/main/resources/order_qualified.xml")));
    }
    
    @Test
    public void testQualifiedWithDefaultNs() throws Exception {
        Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                new Source[] {
                    new StreamSource(getClass().getResourceAsStream("/shiporder_qualified.xsd"))
            });
        schema.newValidator().validate(new StreamSource(new File("src/main/resources/order_qualified_with_default_ns.xml")));
    }
    
    @Test
    public void testUnqualified() throws Exception {
        Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                new Source[] {
                    new StreamSource(getClass().getResourceAsStream("/shiporder_unqualified.xsd"))
            });
        schema.newValidator().validate(new StreamSource(new File("src/main/resources/order_unqualified.xml")));
    }
    
    @Test
    public void testUnqualifiedWithDefaultNs() throws Exception {
        Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                new Source[] {
                    new StreamSource(getClass().getResourceAsStream("/shiporder_unqualified.xsd"))
            });
        schema.newValidator().validate(new StreamSource(new File("src/main/resources/order_unqualified_with_default_ns.xml")));
    }
    
    
}
