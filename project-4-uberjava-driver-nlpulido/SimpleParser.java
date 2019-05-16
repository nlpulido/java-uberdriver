import java.util.Map;

public class SimpleParser {

    public static void main(String[] args) {
        String reply = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Doug here is your next fare:</h3>\n<p>\n"
            + "Ride #1544510358<br/>\n<b>Rider: Al Madrigal</b><br/>\n3 people<br/>\nGoing FROM Fresno to Sacramento<br/>\n"
            + "Fare is $67.49<br/>\n</p>\n<p>\n"
            + "Note distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=1544510358\">"
            + "https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=1544510358</a>\n</p>\n<p>\n"
            + "Let us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=1544510358\"/>"
            + "https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=1544510358</a><br/>\n"
            + "Then we'll let you know how Al Madrigal rated you.\n</p>\n";
        int inx = reply.indexOf("Ride #");
        String rideNumber = reply.substring(inx + 6, inx + 16);
        boolean isUberJavaXPremium = reply.startsWith("[UberJavaX Premium]", inx + 11);
        inx = reply.indexOf("Rider: ", inx + 16);
        int inx2 = reply.indexOf("</b>", inx);
        String rider = reply.substring(inx + 7, inx2);
        inx = reply.indexOf("<br/>\n", inx2);
        inx2 = reply.indexOf(" people", inx);
        if (inx2 == -1) {
            inx2 = reply.indexOf(" person", inx);
        }
        int people = Integer.parseInt(reply.substring(inx + 6, inx2));
        inx = reply.indexOf("Going FROM ", inx2);
        inx2 = reply.indexOf(" to ", inx);
        String from = reply.substring(inx + 11, inx2);
        inx = inx2 + 4;
        inx2 = reply.indexOf("<br/>", inx);
        String to = reply.substring(inx, inx2);
        boolean isDoubleSurgePricing = reply.indexOf("DOUBLE SURGE PRICING IN EFFECT", inx2) != -1;
        boolean isSurgePricing = !isDoubleSurgePricing && reply.indexOf("SURGE PRICING IN EFFECT", inx2) != -1;
        inx = reply.indexOf("Fare is $", inx2);
        inx2 = reply.indexOf("<br/>", inx);
        double fare = Double.parseDouble(reply.substring(inx + 9, inx2));


        System.out.println("RideNumber:\"" + rideNumber + "\"\n"
                + "IsUberJavaXPremium:" + isUberJavaXPremium + "\n"
                + "Rider:\"" + rider + "\"\n"
                + "People:" + people + "\n"
                + "From:\"" + from + "\"\n"
                + "To:\"" + to + "\"\n"
                + "isDoubleSurgePricing: " + isDoubleSurgePricing + "\n"
                + "isSurgePricing: " + isSurgePricing + "\n"
                + "fare= " + fare
        );


    }
}

