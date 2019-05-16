import locations.Location;

public class Ride{
	String rideNumber; // 10-character identifier
	String rider; // name of rider
	Double fare; // dollars in fare
	int people; // number of people
	Location from; // where the ride starts
	Location to; // where the ride goes
	boolean isSurgePricing; // whether surge pricing is in effect
	boolean isDoubleSurgePricing; // whether double surge pricing is in effect
	boolean isUberJavaXPremium; // whether this fare is a premium ride
	String driver; 
	int starAmount; // number of gold stars
	int minutes;
	int distance;
	int tolls;

	public Ride(String parsedInfo){
		String[] infoArray = parsedInfo.split("\n");
		for (String line:infoArray){
			if (line.contains("Ride Number: ")){
				String tempRideNo = line.replaceAll("Ride Number: ", "");
				rideNumber = tempRideNo.trim();
			}
			if (line.contains("Rider: ")){
				String temporary = line.replaceAll("Rider: ", "");
				rider = temporary.trim();
			}
			if (line.contains("Fare: ")){
				String tempFare = line.replaceAll("Fare: ", "");
				fare = Double.parseDouble(tempFare);
			}
			if (line.contains("People: ")){
				String tempPeople = line.replaceAll("People: ", "");
				people = Integer.parseInt(tempPeople);
			}
			if (line.contains("From: ")){
				String tempFrom = line.replaceAll("From: ", "");
				from = Location.getByName(tempFrom);
			}
			if (line.contains("To:")){
				String tempTo = line.replaceAll("To:", "");
				to = Location.getByName(tempTo.trim());
			}
			if (line.contains("isSurgePricing")){
				if (line.contains("true")){
					isSurgePricing = true;
				} else {
					isSurgePricing = false;
				}
			}
			if (line.contains("isDoubleSurgePricing")){
				if (line.contains("true")){
					isDoubleSurgePricing = true;
				} else {
					isDoubleSurgePricing = false;
				}
			}
			if (line.contains("isUberJavaXPremium")){
				if (line.contains("true")){
					isUberJavaXPremium = true;
				} else {
					isUberJavaXPremium = false;
				}
			}
			if (line.contains("Driver:")){
				String tempDriver = line.replaceAll("Driver: ", "");
				driver = tempDriver.trim();
			}
		}
	}

	public void addRideInfo(String parsedInfo){
		String[] infoArray = parsedInfo.split("\n");
		for (String line:infoArray){
			if (line.contains("Minutes:")){
				String tempMins = line.replaceAll("Minutes:", "");
				minutes = Integer.parseInt(tempMins.trim());
			}

			if (line.contains("Distance:")){
				String tempDistance = line.replaceAll("Distance:", "");
				distance = Integer.parseInt(tempDistance.trim());
			}

			if (line.contains("Tolls: ")){
				String tempTolls = line.replaceAll("Tolls: ", "");
				tolls = Integer.parseInt(tempTolls.trim());
			}
		}
	}

	public String toString(){
		return "Ride Number:" + rideNumber + "\n" + "Rider:" + rider + "\n" + "Fare:" + fare + "\n" + "People:" + people + "\n" + "From:" + from + "\n" + "To:" + to + "\n" + "isSurgePricing:" + isSurgePricing + "\n" + "isDoubleSurgePricing:" + isDoubleSurgePricing + "\n" + "isUberJavaXPremium:" + isUberJavaXPremium + "\n" + "Driver:" + driver;
	}

	public String getRideNumber(){
		return rideNumber;
	}

	public Location getFrom(){
		return from;
	}

	public Location getTo(){
		return to;
	}

	public int getMinutes(){
		return minutes;
	}

	public int getTolls(){
		return tolls;
	}

	public Double getFare(){
		return fare;
	}

	public int getDistance(){
		return distance;
	}

}