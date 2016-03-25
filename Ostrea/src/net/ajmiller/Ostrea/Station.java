package net.ajmiller.Ostrea;

import org.json.JSONObject;

public class Station {

    private JSONObject jstation = null;
    private String name;
    private Location location;
        
    public Station(JSONObject station)
    {
        jstation = station;
        name = station.getString("name");
        location = new Location(station.getString("lat"),
                                station.getString("lng"));
        System.out.println(jstation);
    }
    
    public String toString()
    {
        return name + " is at " + location.getLat() + " , " + location.getLon();
    }
}
