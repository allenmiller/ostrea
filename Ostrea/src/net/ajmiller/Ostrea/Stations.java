package net.ajmiller.Ostrea;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class Stations {

    private String baseURL = "http://tidesandcurrents.noaa.gov/cgi-bin/map2/odinmap.cgi?" + "type=TidePredictions"
            + "&nelat=47.79" + "&nelng=-122.29" + "&swlat=47.53" + "&swlng=-122.78" + "&mode=json";

    private JSONObject stations = null;
    private JSONArray stationArray = null;

    public Stations() {
        stations = UrlJsonUtils.getJSON(baseURL);
        stationArray = getStationArray(stations);
    }

    private JSONArray getStationArray(JSONObject stations) {
        int ctr = 0;
        JSONArray stationArray = (JSONArray) stations.getJSONArray("locations");
        // dataPoints = (JSONArray) tidePredictions.get("predictions");
        // Iterator<Object> ii = dataPoints.iterator();
        System.out.println(stationArray);
        Iterator<Object> i = stationArray.iterator();
        while (i.hasNext()) {
            ctr++;
            System.out.println((JSONObject) i.next());
        }
        System.out.println("There are " + ctr + " locations");
        return stationArray;
    }

    public Station getNearest(Location loc) {
        Station nearest = null;
        Station nextStation = null;
        Double nearestDistance = Double.MAX_VALUE;
        Double nextDistance;
        
        System.out.println("in getNearest()");
        
        if (stationArray==null)
        {
            return null;
        }
        
        Iterator<Object> i = stationArray.iterator();
        while (i.hasNext()){
            nextStation = new Station((JSONObject) i.next());
            System.out.println(nextStation);
            nextDistance = nextStation.getLocation().getDistance(loc);
            if (nextDistance < nearestDistance)
            {
            	nearestDistance = nextDistance;
            	nearest = nextStation;
            }
        }
        return nearest;
    }

    public String toString() {
        return stations.toString() + "\n" + stationArray.toString();
    }
}