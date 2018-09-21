/**
 * 
 */
package ca.sait;

/**
 * @author honglu
 *
 */
public class Elevator {
	private boolean doorOpen = false;
	private int currentFloor = 1;
	private final char COLOUR;

	public final int TOP_FLOOR;
	public final int MIN_FLOOR;
	// has only one instance, share by all the class
	public static final int MAX_TOP_FLOOR = 100;

	// modifier , identifier, parameterless constructor
	// Final constance need to intialize before constructor finish running
	// technical right, but application wrong, delete this one
	private Elevator() {
		// this must be first line of the code
		this(1, 10);
		System.out.println("Const: No Parameter");
	}

	// question mark can be anything passed to here
	protected Elevator(int minFloor, int topFloor) {
		this(minFloor, topFloor, true, 1, '?');
		System.out.println("Const: 2 Parameter");
	}

	// constructor has signature - parameters, repeat the cons
	private Elevator(int minFloor, int topFloor, boolean openDoor, int currentFloor, char colour) {
		TOP_FLOOR = minFloor;
		MIN_FLOOR = topFloor;
		COLOUR = colour; // the final one should initialized in constructor rather than initializer.
		// use initialize then other method can call it as well to reset value.
		// use initializer to initilized none final field.
		initialize(openDoor, currentFloor);
		System.out.println("Const: 4 Parameter");
	}

	// available without create instance then have access to it. use factory to
	// create
	public static Elevator createInstance(int minFloor, int topFloor, char colour) {
		
		if ( minFloor != 13 ) {
			System.out.println("Good job on not having 13");			
		}
		
		// not flipping the logic
		if ( !(minFloor == topFloor) ) {
			System.out.println("Good job on not equal");			
		}
		
		// single if return better than the if else
		if (topFloor > MAX_TOP_FLOOR || minFloor < 1 ) {
			System.out.println("TopFloor is past MAX TOP Floor: " + topFloor + " > " + MAX_TOP_FLOOR);
			return null;
		}
		
//		if ( minFloor < 1) {
//			System.out.println("MinFloor is below Basement: " + topFloor + " > " + minFloor);
//			return null;
//		}
		
		if ( minFloor > topFloor) {
			System.out.println("MinFloor is past Top Floor: " + minFloor + " > " + topFloor);
			return null;
		}
		
		if ( minFloor == topFloor) {
			System.out.println("MinFloor and TopFloor are the same");
			return null;
		}
		
		// Elevator elevator = null; - could return null if the later code failed
		final Elevator elevator;
		
		// slow performance
		// primitive type, string can put into switch (), not object
//		switch(colour) {
//		case 'B' :
//			System.out.println("You picked Black");
//			break;
//		case 'R' :
//			System.out.println("You picked Red");
//			break;
//		case 'W' :
//			System.out.println("You picked White");
//			break;
//		default :
//			System.out.println("You get some random colour");
//		}
		// switch better than ifelse
		switch(colour) {
		case 'B' :	{
			boolean openDoor = false;
			elevator = new Elevator(minFloor, topFloor, openDoor, minFloor, colour);
			break;}
		case 'R' :			
		case 'W' :
			boolean openDoor = true;
			elevator = new Elevator(minFloor, topFloor, openDoor, minFloor, colour);
			break;
		default :
			elevator = new Elevator(minFloor, topFloor);
		}
			//return new Elevator(minFloor, topFloor);
		return elevator;
	
	}

	private void initialize(boolean openDoor, int currentFloor) {
		doorOpen = openDoor;
		this.currentFloor = currentFloor;
	}

	public void openDoor() {
		System.out.println("Opening door");

		doorOpen = true;
		System.out.println("Door is open");
	}

	public void closeDoor() {
		System.out.println("Closing door");

		doorOpen = false;
		System.out.println("Door is closed");
	}

	public void goUp() {
		currentFloor++;
	}

	public void goDown() {
		currentFloor--;
	}

	// java bean take the attributes name.
	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

}
