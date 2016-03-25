package net.ajmiller.Ostrea;

import org.json.JSONObject;

public class Station {

    private JSONObject jstation = null;
    private String name;
    private Double lat;
    private Double lon;
    
    public Station(JSONObject station)
    {
        jstation = station;
        name = station.getString("name");
        lat = new Double(station.getString("lat"));
        lon = new Double(station.getString("lng"));
        System.out.println(jstation);
    }
    
    public String toString()
    {
        return name + " is at " + lat + " , " + lon;
    }
}
