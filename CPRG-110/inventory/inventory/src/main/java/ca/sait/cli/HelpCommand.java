/**
 * 
 */
package ca.sait.cli;

import java.util.Scanner;

/**
 * This command will display a simple output that will
 * contain all the commands and a description that each 
 * command will do.
 * 
 * 
 * @author 
 * @version 1.0
 */
public class HelpCommand extends AbstractCommand {
    
    /**
     * @param consoleScanner
     */
    public HelpCommand(Scanner consoleScanner) {
        super(consoleScanner);
    }

    /* (non-Javadoc)
     * @see ca.sait.calculator.AbstractCommand#performInput(java.util.Scanner)
     */
    @Override
    protected void performInput(Scanner consoleScanner)
    throws ValidationException {
    }

    /* (non-Javadoc)
     * @see ca.sait.calculator.AbstractCommand#performFunction()
     */
    @Override
    protected void performFunction() 
    throws OperationException {
    }

    /* (non-Javadoc)
     * @see ca.sait.calculator.AbstractCommand#buildResponse()
     */
    @Override
    protected String buildResponse() {
        final StringBuilder text = new StringBuilder();
		for (final HelpCommandType type : HelpCommandType.values()) {			
			text.append(type.name());
			text.append(" - ");
			text.append(type.getDescription());	
			text.append("\r\n");
		}
        return text.toString();
    }
}