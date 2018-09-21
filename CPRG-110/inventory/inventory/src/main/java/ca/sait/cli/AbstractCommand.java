/**
 * 
 */
package ca.sait.cli;

import java.util.Scanner;

import ca.sait.produce.FinishedProduct;
import ca.sait.produce.Produce;
import ca.sait.produce.RawMaterial;
import ca.sait.produce.db.InventoryDB;
import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * This the base class for all the command classes.  It provides
 * the abstract methods that need to be implement. *
 * <p>
 * The method {@link AbstractCommand#performCommand()} is called which will
 * deal with the workflow for the rest of the classes. This method will not
 * be overridden.
 * </p>
 * 
 * @version 1.0
 */
public abstract class AbstractCommand {

    /**
     * reference to the console input
     */
    private final Scanner consoleScanner;

    /**
     * Constructor that takes the Scanner from the {@link Main}
     * @param consoleScanner
     */
    public AbstractCommand(final Scanner consoleScanner) {
        this.consoleScanner = consoleScanner;
    }

    /**
     * This captures the input that is needed to perform the function 
     * 
     * @param consoleScanner
     *            reference to the console input
     * @throws ValidationException
     *            thrown if the value is not an integer value 
     */
    protected abstract void performInput(Scanner consoleScanner)
    throws ValidationException;

    /**
     * This performs some type of function of the data
     * that was captured in the @see performInput method
     * 
     * @throws OperationException
     *            thrown if the math operation can not be performed
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * @throws ValidationException 
     */
    protected abstract void performFunction()
    throws OperationException, InvalidCommodityException, InvalidVarietyException, ValidationException;
    
    /**
     * 
     * @return
     */
    protected abstract String buildResponse();
    
    /**
     * This method controls the work flow of:
     * 
     * <ul>
     *  <li>Performing the input. This will keep calling the perform input
     *      until the two values are correct. </li>
     *  <li>Perform the math function.  This should only be called once
     *      the input has two values</li>
     * </ul>
     * 
     * <pre>
     * pseudo code:
     * 
     *  while 
     *      try
     *          perform the input
     *          if there is no exception, break out of loop
     *      catch validation exception that was thrown when trying 
     *      to input values and display the error message, not the stack trace 
     *  end while
     *  
     *  try
     *      perform the math function
     *      output the response to the console
     *  catch operation exception and display the error message, not the
     *  stack trace
     * 
     * </pre>
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * @throws ValidationException 
     * 
     */
    public final boolean performCommand() throws InvalidCommodityException, InvalidVarietyException, ValidationException {

        // get the input until all validate data
        // are entered
        while (true) {
            try {
                performInput(consoleScanner);
                
                // break out of the loop if all valid
                // data are entered.
                break;
            } catch(final ValidationException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            performFunction();
            System.out.println(buildResponse());
        } catch(final OperationException ex) {
            System.out.println(ex.getMessage());
        }
   
        return true;
    } 
    
}