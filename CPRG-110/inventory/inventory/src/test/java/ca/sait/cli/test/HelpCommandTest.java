/**
 * 
 */
package ca.sait.cli.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import ca.sait.cli.Main;
import ca.sait.cli.ValidationException;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * 
 * @author Chris Elias
 * @version 1.0
 */
public class HelpCommandTest extends AbstractBase {
    
    /**
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * 
     */
    @Test
    public void testHelpAdd() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
    	
        sendCommands("Help\n", "Exit\n");
        new Main().run();
        
        final String output = getOutput().toLowerCase();
        
        assertTrue("Help message does not contain HF command", output.contains("hf"));
        assertTrue("Help message does not contain HV command", output.contains("hv"));
        assertTrue("Help message does not contain CR command", output.contains("cr"));
        assertTrue("Help message does not contain CP command", output.contains("cp"));
        assertTrue("Help message does not contain LIST command", output.contains("list"));
        assertTrue("Help message does not contain REMOVE command", output.contains("remove"));
        assertTrue("Help message does not contain HELP command", output.contains("help"));
        assertTrue("Help message does not contain EXIT command", output.contains("exit"));
    }

    @Override
    protected void testCommandClass() {    	
        try {
            final Class<?> helpClass = Class.forName("ca.sait.cli.HelpCommand");
            helpClass.newInstance();
            fail("HelpCommand has a Default Constructor");
        } catch (final ClassNotFoundException e ) {
            fail("Help class does not Exist");
        } catch (final InstantiationException| IllegalAccessException e) {
            // No default Constructor, this is good
        }
    }
}