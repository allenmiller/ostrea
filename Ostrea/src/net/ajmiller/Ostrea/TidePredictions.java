package net.ajmiller.Ostrea;

import java.util.Date;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class TidePredictions {
	
	private String urlStr;
	private Date dateObtained=null;
	private JSONObject tidePredictions=null;
	private JSONArray dataPoints=null;
	
	public TidePredictions(String startDate, String range, String station)
	{
		getTidePredictions(startDate, range, station);
	}

	private void getTidePredictions(String startDate, String range, String station)
	{
		urlStr="http://tidesandcurrents.noaa.gov/api/datagetter?"
				+ "begin_date=" + startDate
				+ "&range=" + range
				+ "&station=" + station
				+ "&product=predictions"
				+ "&datum=MLLW"
				+ "&units=english"
				+ "&time_zone=gmt"
				+ "&application=net.ajmiller.test"
				+ "&format=json";
		

		tidePredictions = UrlJsonUtils.getJSON(urlStr);
		dateObtained = new Date();
	}

	private void getTideDatapoints()
	{
		dataPoints = (JSONArray) tidePredictions.get("predictions");
//	Iterator<Object> ii = dataPoints.iterator();
		System.out.println(dataPoints);
		Iterator<Object>ji = dataPoints.iterator();
		while (ji.hasNext()){
			System.out.println((JSONObject)ji.next());
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
