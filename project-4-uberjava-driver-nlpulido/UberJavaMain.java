import locations.Location;
import uberjava.SSLVerificationPatch;
import vehicles.Car;
import vehicles.Vehicle;
import java.util.ArrayList;

public class UberJavaMain {
	public static ArrayList<Driver> driverArray;

	public static void main(String args[]){
		// apply the patch
		SSLVerificationPatch.applyPath();

		// instatiate the WebReader & Parser
		WebReader webReader = new WebReader();
		Parser parser = new Parser();

		ArrayList<Driver> driverArray = new ArrayList<Driver>();

		// instatiate the 3 drivers
		Driver neil = new Driver("Neil", false, "BMW M3", 2004);
		Driver prateek = new Driver("Prateek", true, "Lamborghini Aventador", 2018);
		Driver lauren = new Driver("Lauren", true, "Porsche 911 Turbo S Cabriole", 2017);
		driverArray.add(neil);
		driverArray.add(prateek);
		driverArray.add(lauren);

		// Neil While Loop
		while(true){
			if (neil.getMinutesDriven() >= 1440){
				if (neil.getCurrentLocation().equals("San Francisco")){
					break;
				} else {
					neil.drive(neil.getCurrentLocation(), "San Francisco");
					break;
				}
			}

			// gets new ride for drivers
			String neilPageSource = webReader.get("https://cs.usfca.edu/~dhalperin/nextFare.cgi?driver=%3CNeil%3E");

			// parses current ride for drivers
			Ride neilRide = new Ride (parser.parse(neilPageSource));

			// parses current ride's meta info
			neilRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=" + neilRide.getRideNumber())));

			// Drives ride
			neil.drive(neilRide.getFrom().getName(), neilRide.getTo().getName());

			// adds current ride's minutes to Driver's driven minutes
			neil.addMinutes(neilRide.getMinutes());
			neil.addFares(neilRide.getFare());
			neil.addMiles(neilRide.getDistance());

			// get ratings
			neilRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=" + neilRide.getRideNumber())));
		}

		// Prateek While Loop
		while(true){
			if (prateek.getMinutesDriven() >= 1440){
				if (prateek.getCurrentLocation().equals("San Francisco")){
					break;
				} else {
					prateek.drive(prateek.getCurrentLocation(), "San Francisco");
					break;
				}
			}

			// gets new ride for drivers
			String prateekPageSource = webReader.get("https://cs.usfca.edu/~dhalperin/nextFare.cgi?driver=%3CPrateek%3E");

			// parses current ride for drivers
			Ride prateekRide = new Ride (parser.parse(prateekPageSource));

			// parses current ride's meta info
			prateekRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=" + prateekRide.getRideNumber())));

			// Drives ride
			prateek.drive(prateekRide.getFrom().getName(), prateekRide.getTo().getName());

			// adds current ride's minutes to Driver's driven minutes
			prateek.addMinutes(prateekRide.getMinutes());
			prateek.addFares(prateekRide.getFare());
			prateek.addMiles(prateekRide.getDistance());

			// get ratings
			prateekRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=" + prateekRide.getRideNumber())));
		}

		// Lauren While Loop
		while(true){
			if (lauren.getMinutesDriven() >= 1440){
				if (lauren.getCurrentLocation().equals("San Francisco")){
					break;
				} else {
					lauren.drive(lauren.getCurrentLocation(), "San Francisco");
					break;
				}
			}

			// gets new ride for drivers
			String laurenPageSource = webReader.get("https://cs.usfca.edu/~dhalperin/nextFare.cgi?driver=%3CLauren%3E");

			// parses current ride for drivers
			Ride laurenRide = new Ride (parser.parse(laurenPageSource));

			// parses current ride's meta info
			laurenRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=" + laurenRide.getRideNumber())));

			// Drives ride
			lauren.drive(laurenRide.getFrom().getName(), laurenRide.getTo().getName());

			// adds current ride's minutes to Driver's driven minutes
			lauren.addMinutes(laurenRide.getMinutes());
			lauren.addFares(laurenRide.getFare());
			lauren.addMiles(laurenRide.getDistance());

			// get ratings
			laurenRide.addRideInfo(parser.parse(webReader.get("https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=" + laurenRide.getRideNumber())));
		}


		System.out.println("\n");

		for (Driver driver:driverArray){
			System.out.println("Name: " + driver.getName());
			System.out.println("UberJavaX Premium: " + driver.isUberJavaXPremium());
			System.out.println("Total Fares: " + driver.getFare());
			System.out.println("Total Miles Driven: " + driver.getMilesDriven());
			System.out.println("Total Minutes Driven: " + driver.getMinutesDriven());
			System.out.println("\n");
		}

		// webreader and parser test
		//String input = args[0];
		//String urlPageSource = webReader.get(input);
		//System.out.println(urlPageSource);
		//System.out.println(parser.parse(urlPageSource));

	}

}