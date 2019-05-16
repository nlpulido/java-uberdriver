package vehicles;

public class Vehicle{
	private String make;
	private Integer year;
	private Boolean runState;
	private String currentLocation;
	public Integer milesDriven;


	public Vehicle(String make, Integer year){
		this.make = make;
		this.year = year;
	}

	public void driveForward(String location, int miles) { // This is a method
		runState = true;
		currentLocation = location;
		milesDriven += miles;
		System.out.println("I am now driving to " + currentLocation + ". It is " + miles + " miles away.");
	}

	public String getMake(){
		return make;
	}

	public Integer getYear(){
		return year;
	}

	@Override 
	public String toString(){
		return make + " " + year;
	}
}