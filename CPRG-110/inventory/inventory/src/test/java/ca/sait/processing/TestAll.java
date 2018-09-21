package ca.sait.processing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HarvestFruitTest.class, HarvestVegetableTest.class,
                CreateRawMaterialTest.class })
public class TestAll {

}
