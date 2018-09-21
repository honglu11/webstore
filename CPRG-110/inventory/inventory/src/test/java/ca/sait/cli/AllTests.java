/**
 * 
 */
package ca.sait.cli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.sait.cli.test.CreateFinishedProductCommandTest;
import ca.sait.cli.test.HarvestFruitCommandTest;
import ca.sait.cli.test.CreateRawMaterialCommandTest;
import ca.sait.cli.test.HarvestVegetableCommandTest;
import ca.sait.cli.test.HelpCommandTest;
import ca.sait.cli.test.ListCommandTest;
import ca.sait.cli.test.RemoveCommandTest;

/**
 * 
 * @author Chris Elias
 * @verison 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ HelpCommandTest.class, HarvestFruitCommandTest.class,  
                HarvestVegetableCommandTest.class, ListCommandTest.class, RemoveCommandTest.class, CreateRawMaterialCommandTest.class, CreateFinishedProductCommandTest.class })
public class AllTests {

}
