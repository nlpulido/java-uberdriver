import vehicles.*;
import locations.Location;

public class Driver{
	boolean uberJavaXPremium;
	String name;
	int minutesDriven;
	int milesDriven;
	Double fare;
	Car userCar;

	public Driver(String name, boolean premiumOrNot, String carMake, int carYear){
		this.name = name;
		uberJavaXPremium = premiumOrNot;
		minutesDriven = 0;
		milesDriven = 0;
		fare = 0.0;
		userCar = new Car(carMake, carYear);
	}
	// take in string, and if it matches current location string, set location object in ride class
	// to the getByName of current destination after driving
	public void drive(String startingPoint, String destination){
		if (userCar.getCurrentLocation().equals(startingPoint)){
			userCar.driveForward(destination);
			System.out.println("Ride finished!");
		} else {
			userCar.driveForward(startingPoint);
			userCar.driveForward(destination);
			System.out.println("Ride finished!");
		}
	}

	public void addMinutes(int minutes){
		minutesDriven += minutes;
	}

	public int getMinutesDriven(){
		return minutesDriven;
	}

	public String getDriver(){
		return name;
	}

	public String getCurrentLocation(){
		String currentLocation = userCar.getCurrentLocation();
		return currentLocation;
	}

	public boolean isUberJavaXPremium(){
		return uberJavaXPremium;
	}
	public String getName(){
		return name;
	}

	public void addFares(Double fares){
		fare += fares;
	}

	public Double getFare(){
		return fare;
	}

	public int getMilesDriven(){
		return milesDriven;
	}

	public void addMiles(int miles){
		milesDriven += miles;
	}
}