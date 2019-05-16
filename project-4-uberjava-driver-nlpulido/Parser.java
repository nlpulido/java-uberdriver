import java.util.Scanner;
import java.lang.Character;

public class Parser {
	String rideNumber; // 10-character identifier
	String rider; // name of rider
	Double fare; // dollars in fare
	int people; // number of people
	String from; // where the ride starts
	String to; // where the ride goes
	boolean isSurgePricing; // whether surge pricing is in effect
	boolean isDoubleSurgePricing; // whether double surge pricing is in effect
	boolean isUberJavaXPremium; // whether this fare is a premium ride
	int starAmount; // number of gold stars
	String driver; // current driver of ride
	int distance; // distance for ride
	int tolls; // toll amount for ride
	int minutes; // duration of ride;

	public Parser(){
		rideNumber = "";
		rider = "";
		fare = 0.0;
		people = 0;
		from = "";
		to = "";
		isSurgePricing = false;
		isDoubleSurgePricing = false;
		isUberJavaXPremium = false;
		starAmount = 0;
		distance = 0;
		tolls = 0;
		minutes = 0;
	}

	public String getRideNumber(){
		return rideNumber;
	}

	public String getRider(){
		return rider;
	}

	public Double getFare(){
		return fare;
	}

	public int getPeople(){
		return people;
	}
	public String getFrom(){
		return from;
	}
	public String getTo(){
		return to;
	}
	public boolean getIsSurgePricing(){
		return isSurgePricing;
	}
	public boolean getIsDoubleSurgePricing(){
		return isDoubleSurgePricing;
	}
	public boolean getIsUberJavaXPremium(){
		return isUberJavaXPremium;
	}
	public int getStarAmount(){
		return starAmount;
	}
	public int addStar(int amount){
		starAmount += amount;
		return starAmount;
	}

	public String parse(String pageSource){
		String s = pageSource;

		// parses distance calculator info if any
		if (s.contains("Distance Calculator")){
			// parses distance
			int index8 = s.indexOf("Distance: ");
			int endIndex8 = s.indexOf("m", index8);
			String tempDistance = s.substring(index8 + 10, endIndex8);
			distance = Integer.parseInt(tempDistance.trim());

			// parses tolls
			int index9 = s.indexOf("Tolls: ");
			int endindex9 = s.indexOf("<", index9);
			String tempTolls = s.substring(index9 + 8, endindex9);
			tolls = Integer.parseInt(tempTolls);

			// Parses minutes
			int index10 = s.indexOf("Minutes: ");
			int endIndex10 = s.indexOf("<", index10);
			String tempMinutes = s.substring(index10 + 9, endIndex10);
			minutes = Integer.parseInt(tempMinutes);

			// parses Ride Number
			int index11 = s.indexOf("RideNumber: ");
			int endIndex11 = s.indexOf("<", index11);
			String rideNumber = s.substring(index11 + 12, endIndex11);

			// parses From
			int index5 = s.indexOf("From:");
			int endIndex5 = s.indexOf("<", index5);
			String from = s.substring(index5 + 6, endIndex5);

			// parses To
			int index6 = s.indexOf("To: ");
			int endIndex6 = s.indexOf("<", index6);
			String to = s.substring(index6 + 4, endIndex6);

			return "Ride Number: " + rideNumber + "\n" + "From: " + from + "\n" + "To: " + to + "\n" + "Distance: " + distance + "\n" + "Tolls: " + tolls + "\n" + "Minutes: " + minutes;
		}

		// parses stars if any
		if (s.contains("golden-star.jpg")){
			int count = 0;
			String[] starArray = s.split("golden-star.jpg");
			for (String star:starArray){
				count += 1;
			}
			starAmount = count;
			return "Gold Star Amount: " + starAmount;
		} 
		if (s.contains("Driver Dispatcher")){
			// checks if theres surge pricing or double surge
			if (s.contains("SURGEPRICING")){
				if (s.contains("DOUBLESURGEPRICING")){
					isDoubleSurgePricing = true;
				}
				isSurgePricing = true;
			}
			// checks for premium drivers
			if (s.contains("Prateek") || s.contains("Lauren")){
				isUberJavaXPremium = true;
			}

			// labels driver
			if (s.contains("Prateek")){
				driver = "Prateek";
			} else if (s.contains("Lauren")){
				driver = "Lauren";
			} else {
				driver = "Neil";
			}

			// parses Ride Number
			int index = s.indexOf("Ride #");
			String rideNumber = s.substring(index + 6, index + 16);

			// parses Rider name
			int index2 = s.indexOf("Rider:");
			int endIndex2 = s.indexOf("<", index2);
			String rider = s.substring(index2 + 6, endIndex2);

			// parses Fare
			int index3 = s.indexOf("Fare is");
			int endIndex3 = s.indexOf("<", index3);
			String tempFare = s.substring(index3 + 9, endIndex3);
			fare = Double.parseDouble(tempFare);

			// parses People
			if (s.contains("people")){
				int index4 = s.indexOf("people");
				Character tempPeople = s.charAt(index4 - 2);
				people = Character.getNumericValue(tempPeople);
			} 
			if (s.contains("person")){
				int index7 = s.indexOf("person");
				Character tempPerson = s.charAt(index7 - 2);
				people = Character.getNumericValue(tempPerson);
			}

			// parses From
			int index5 = s.indexOf("FROM");
			int endIndex5 = s.indexOf(" to", index5);
			String from = s.substring(index5 + 5, endIndex5);

			// parses To
			int index6 = s.indexOf(" to");
			int endIndex6 = s.indexOf("<", index5);
			String to = s.substring(index6 + 3, endIndex6);	

			return "Ride Number: " + rideNumber + "\n" + "Rider: " + rider + "\n" + "Fare: " + fare + "\n" + "People: " + people + "\n" + "From: " + from + "\n" + "To: " + to + "\n" + "isSurgePricing: " + isSurgePricing + "\n" + "isDoubleSurgePricing: " + isDoubleSurgePricing + "\n" + "isUberJavaXPremium: " + isUberJavaXPremium + "\n" + "Driver: " + driver;
		}
		return null;
	}
}