/**
 * 
 */
package ca.sait.cli.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;

/**
 * 
 * @author Chris Elias
 * @version 1.0
 */
public abstract class AbstractBase {

    /**
     * a holder for the System.out. This is used to restore
     * the System.out after a test is completed
     */
    private PrintStream originalOutput;
    
    /**
     * a holder for the System.in. This used to restore
     * the System.in after a test is completed
     */
    private InputStream originalInput;

    /**
     * This is used to capture all output from the
     * application in a test. This is used to replace the
     * default inputStream in System.in
     */
    private ByteArrayOutputStream outputStream;
    
    /**
     * This is the wrapper around the outputStream
     * for replacing the System.out
     */
    private PrintStream printStream;

    
    /**
     * This method runs before each test. It turns off all console logging and all 
     * other loggers are turned to WARN
     */
    @Before
    public void setupTest() {
        
        // place the default input/output streams into the holders
        originalOutput = System.out;
        originalInput = System.in;

        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        
        // replace the default output stream with the controlled
        // output stream
        System.setOut(printStream);
        testCommandClass();
    }

    /**
     * This runs after ever test and restores the console logger and 
     * all other loggers back to there original log levels
     * 
     */
    @After
    public void cleanupTest() {
        // flush the current output stream.
        System.out.flush();
        
        // close off the current System.in stream
        try {
            System.in.close();
        } catch (final IOException ex) {
            // silent catch 
        }
        
        // replace the control input/out streams with the originals
        System.setOut(originalOutput);
        System.setIn(originalInput);
        
        System.out.println("Test Output:");
        System.out.println(outputStream.toString());
        
        printStream.close();
        
        try {
            outputStream.close();
        } catch(final IOException ex) {
            // silent catch
        }
    }
    
    /**
     * This method is used to send information to the controlled
     * inputStream (System.in) for testing
     *  
     * @param text
     */
    protected void sendCommands(String ... commands) {
        
        final List<InputStream> streams = new ArrayList<InputStream>(commands.length);
        for (String command : commands)
            streams.add(new ByteArrayInputStream(command.getBytes()));
        
        System.setIn(new SequenceInputStream(Collections.enumeration(streams)));
    }
    
    /**
     * returns the output to that was sent to the System.out
     * during a test
     *  
     * @return
     *          out to System.out
     */
    protected String getOutput() {
        return outputStream.toString();
    }
    
 
    /**
     * This method tests to make sure that the class that extends
     * AbstractCommand exists 
     */
    protected abstract void testCommandClass();
    
}