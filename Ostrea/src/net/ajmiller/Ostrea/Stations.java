package net.ajmiller.Ostrea;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class Stations {
	
	private String baseURL = "http://tidesandcurrents.noaa.gov/cgi-bin/map2/odinmap.cgi?"
			+ "type=TidePredictions"
			+ "&nelat=47.79"
			+ "&nelng=-122.29"
			+ "&swlat=47.53"
			+ "&swlng=-122.78"
			+ "&mode=json";
	
 	private JSONObject stations = null;
	private JSONArray stationArray = null;

	public Stations()
	{
		stations = UrlJsonUtils.getJSON(baseURL);
		stationArray = getStationArray(stations);
	}
	private JSONArray getStationArray(JSONObject stations)
	{
		int ctr=0;
		JSONArray stationArray = (JSONArray)stations.getJSONArray("locations");
		//		dataPoints = (JSONArray) tidePredictions.get("predictions");
//	Iterator<Object> ii = dataPoints.iterator();
		System.out.println(stationArray);
		Iterator<Object>i = stationArray.iterator();
		while (i.hasNext()){
			ctr++;
			System.out.println((JSONObject)i.next());
		}
		System.out.println("There are "+ctr+" locations");
		return stationArray;
	}
	
	public String toString()
	{
		return stations.toString() + "\n" + stationArray.toString() ;
	}
}