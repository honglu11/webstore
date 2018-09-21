/**
 * 
 */
package ca.sait.cli;

import java.util.Scanner;

import ca.sait.produce.exceptions.InvalidCommodityException;
import ca.sait.produce.exceptions.InvalidVarietyException;

/**
 * This is the main class that starts the application
 * and controls the command prompt
 * 
 * @author 
 * @version 1.0
 */
public class Main {

    /**
     * this is the reference to the console input that will be passed
     * around to the different command classes 
     */
    private Scanner consoleScanner;

    /**
     * Default Constructor 
     * calls the initialize method
     */
    public Main() {
        initialize();
    }   

    /**
     * creates a new instance of scanner based on the System.in. This
     * also setups a shutdown hook that calls the cleanup method
     */
    private void initialize() {
        
        consoleScanner = new Scanner(System.in);
        consoleScanner.useDelimiter("\r?\n|\r|\\|");
        
        // This is when the application exits, to close the I/O
        // stream to the console
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                cleanup();
            }
        });
    }
    
    /**
     * The cleanup method closes off the consoleScanner
     */
    private void cleanup() {
        consoleScanner.close();
    }
    
    /**
     * The controlling method that captures input for the command
     * to be executed. Using the switch, based on the command
     * entered, an instance of the command class will be created
     * and stored in the {@link AbstractCommand} instance variable.
     * The method {@link AbstractCommand#performCommand()} will be
     * run.
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     * 
     */
    public void run() throws InvalidCommodityException, InvalidVarietyException, ValidationException {
        
        while (true) {
            System.out.print("Enter Command:");
            final String consoleLine = consoleScanner.next();
            final AbstractCommand command;
            
            switch(consoleLine.toUpperCase()) {
            
            case "HF":   // Harvest Fruit 
                command = new HarvestFruitCommand(consoleScanner);
                break;
            
            case "HV" :  // Harvest Vegetable 
                command = new HarvestVegetableCommand(consoleScanner);
                break;
            
            case "CR" :  // Create Raw Material 
                command = new CreateRawMaterialCommand(consoleScanner);
                break;
            
            case "CP" :  // Create Finished Product 
                command = new CreateFinishedProductCommand(consoleScanner);
                break;
                
            case "LIST" :  // Lists all items in inventory 
                command = new ListCommand(consoleScanner);
                break;

            case "REMOVE" :  // removes item from inventory 
                command = new RemoveCommand(consoleScanner);
                break;

            case "HELP" : 
                command = new HelpCommand(consoleScanner);
                break;
                
            case "EXIT" : 
                return;
            
            default : 
                command = null;
                System.out.println("Invalid Command: " + consoleLine);
                break;
            }
            
            if (command != null)
                command.performCommand();
        }
    }
    
    /**
     * @param args
     * @throws ValidationException 
     * @throws InvalidVarietyException 
     * @throws InvalidCommodityException 
     */
    public static void main(String[] args) throws InvalidCommodityException, InvalidVarietyException, ValidationException {
        new Main().run();
    }
}