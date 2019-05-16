/**
 *@author Neil Pulido
 *@version 9.0.4
*/

package vehicles;

public class Car extends Vehicle {
	// Fields
	private boolean runState; // whether or not the car is running
	private String carMake; // Make of car
	private int carYear; // Year of car
	private String currentLocation; // car's current location
	private int milesDriven; // car's mileage	

	// Constructor
	public Car(String make, int year) { // This is the constructor
		super(make, year);
		runState = false;
		carMake = make;
		carYear = year;
		currentLocation = "San Francisco";
		milesDriven = 0;
	}

	// Methods
	public String toString(){
		return carMake + " " + carYear + " " + currentLocation + " " + runState + " " + milesDriven;
	}
	public void driveForward(String location) { // This is a method
		runState = true;
		currentLocation = location;
	}
	public void parkCar() {
		runState = false; 
	}
	public void carStatus(){
		System.out.println("Car's location: " + currentLocation);
		System.out.println("Car's mileage: " + milesDriven);
		System.out.println("Car's Status: " + runState); 
	}

	public String getCurrentLocation(){
		return currentLocation;
	}
}