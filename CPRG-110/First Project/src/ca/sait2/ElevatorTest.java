/**
 * 
 */
package ca.sait2;

import ca.sait.Elevator;

/**
 * @author honglu
 *
 */
public class ElevatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Elevator elevator = new Elevator();
//		Elevator elevatorEast = new Elevator(11, 20);
//		Elevator elevatorWest = new Elevator(11, 20, false, 15);
		// do some test before we start up the createInstance, more controll.
		//Elevator elevatorEast = Elevator.createInstance(11, 20, 0);
		
		// the address is null, then memory is destroy in heat since address in stack is null.
		//elevator = null;
//		elevator.openDoor();
//		elevator.goDown();
//		elevator.goDown();
//		elevator.goUp();
//		elevator.closeDoor();
//		elevator.goUp();
		// have access without create class instance.use class to access.
		System.out.println(Elevator.MAX_TOP_FLOOR);

//		elevatorEast.openDoor();
//		elevatorEast.goDown();
//		elevatorEast.goDown();
//		elevatorEast.goUp();
//		elevatorEast.closeDoor();
//		elevatorEast.goUp();
		int i = 16;
		System.out.println(++i + " " + i++ + " " + i);

	}

}
