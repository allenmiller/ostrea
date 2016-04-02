package net.ajmiller.Ostrea;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class TidePredictions {

    private String urlStr;
    private Date dateObtained = null;
    private JSONObject tidePredictions = null;
    private JSONArray dataPoints = null;
    private Map tidePoints;

    public TidePredictions(String startDate, String range, String station) {
        getTidePredictions(startDate, range, station);
        dataPoints = (JSONArray) tidePredictions.get("predictions");
        tidePoints = new HashMap<Date, Double>();
    }

    private void getTidePredictions(String startDate, String range, String station) {
        urlStr = "http://tidesandcurrents.noaa.gov/api/datagetter?" + "begin_date=" + startDate + "&range=" + range
                + "&station=" + station + "&product=predictions" + "&datum=MLLW" + "&units=english" + "&time_zone=gmt"
                + "&application=net.ajmiller.test" + "&format=json";

        tidePredictions = UrlJsonUtils.getJSON(urlStr);
        dateObtained = new Date();
    }


	public void getTideDatapoints() {
    	
    	JSONObject dp;
    	String dpDate;
    	Double lastTide = Double.NEGATIVE_INFINITY;
    	Double dpTide;
    	
    	Boolean tideRising = Boolean.FALSE;
    	
    	Iterator<Object> ji = dataPoints.iterator();
    	System.out.println("Current time is "+ new Date());
    	if (ji.hasNext())
    	{
    		dp = (JSONObject)ji.next();
            lastTide = dp.getDouble("v");
    		dp = (JSONObject)ji.next();
    		dpTide = dp.getDouble("v");
    		tideRising = (dpTide > lastTide);
        }
    	while (ji.hasNext()) {
        	dp = (JSONObject)ji.next();
//            System.out.println(dp);
            dpDate = dp.getString("t");
            dpTide = dp.getDouble("v");

            if ( (dpTide > lastTide) && tideRising )
            {
//            	System.out.println("tide still rising");

            } else if ((dpTide <= lastTide) && tideRising) {
            	
            	System.out.println("Found a high tide " + dpTide + " at "+dpDate);
            	tideRising = Boolean.FALSE;
            } else if ((dpTide > lastTide) && !tideRising)
            {
            	System.out.println("Found a low tide " + dpTide + " at "+ dpDate);
            	tideRising = Boolean.TRUE;
            } else if ((dpTide <= lastTide) && !tideRising)
            {
//            	System.out.println("Tide still falling");
            } else {
            	System.out.println("ERROR, impossible situation");
            }
            
        	lastTide = dpTide;
//        	System.out.println("TideRising is "+tideRising);
        }
    }

    public Date getDateObtained() {
        return dateObtained;
    }

    public String getURLString() {
        return urlStr;
    }

    public String toString() {
        return tidePredictions.toString();
    }
}
