/**
 * 
 */
package net.ajmiller.Ostrea;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author ajmiller
 *
 */
public class Ostrea {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Starting main()");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date currentDate = new Date();
        String currentDateStr = formatter.format(currentDate);
        System.out.println(currentDateStr);

        // System.out.println(tdjson.names());
        // System.out.println(tdjson.keys());

        // Iterator<String> i = tdjson.keys();
        // while (i.hasNext()) {
        // System.out.println(i.next());
        // }

        // JSONObject metadataPoints = (JSONObject) tdjson.get("metadata");
        // Iterator<Object> ii = dataPoints.iterator();
        // System.out.println(metadataPoints);
        // Iterator<Object> ji = metadataPoints.iterator();
        // while (ji.hasNext()){
        // System.out.println((JSONObject)ji.next());
        // }

        Stations stations = new Stations();
        System.out.println(stations);
        Location homeLoc = new Location("47.827074", "-122.643950");
        Station nearest = stations.getNearest(homeLoc);
        System.out.print("The nearest tide station is " + nearest);
        System.out.print(" it is "+ nearest.getLocation().getDistance(homeLoc));
        System.out.println(" meters away");

        TidePredictions td = new TidePredictions(currentDateStr, "1", nearest.getStationId());
        System.out.println(td);
    }

}
