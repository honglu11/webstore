/**
 * 
 */
package ca.sait;

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
		final int minFloor = 4;
		final int topFloor = 15;
		
		final Elevator elevatorEast = Elevator.createInstance(minFloor, topFloor, 'B');
		final Elevator elevator2 = Elevator.createInstance(minFloor, topFloor, 'B');
		final Elevator elevator3 = Elevator.createInstance(minFloor, topFloor, 'B');
		final Elevator elevator4 = Elevator.createInstance(minFloor, topFloor, 'B');
		
		// elevator hold the address point to 5 Elevator
		final Elevator [] elevator = new Elevator[5];
		elevator[0] = Elevator.createInstance(minFloor, topFloor, 'B');
		elevator[1] = Elevator.createInstance(minFloor, topFloor, 'W');
		elevator[2] = Elevator.createInstance(minFloor, topFloor, 'R');
		// will print out the question mark
		elevator[3] = Elevator.createInstance(minFloor, topFloor, '?');
		elevator[4] = Elevator.createInstance(minFloor, topFloor, 'B');

		//Elevator elevatorEast = Elevator.createInstance(11, 20);
		//Elevator elevator = new Elevator(11,20);
		
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

		elevatorEast.openDoor();
		elevatorEast.goDown();
		elevatorEast.goDown();
		elevatorEast.goUp();
		elevatorEast.closeDoor();
		elevatorEast.goUp();
		int i = 16;
		System.out.println(++i + " " + i++ + " " + i);

	}

}
