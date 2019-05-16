import java.util.Scanner;
import java.net.HttpURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
import uberjava.SSLVerificationPatch;

public class WebReader{

	public String get(String urlString) {
		String finalString = "";

		if (urlString.contains("https://")){
			try {

				String input = urlString;
				URL u = new URL(input);
				URLConnection connection = u.openConnection();


				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				int code = httpConnection.getResponseCode();
				String message = httpConnection.getResponseMessage();
				System.out.println(code + " " + message);
				if (code != HttpURLConnection.HTTP_OK){
					return null;
				}

				InputStream instream = connection.getInputStream();
				Scanner in = new Scanner(instream);

				while (in.hasNextLine()){
					finalString += in.nextLine();
				}
				return finalString;

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Error! Input is not a URL!");
		}
		return null;
	}
}