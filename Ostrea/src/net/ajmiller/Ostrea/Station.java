package net.ajmiller.Ostrea;

import org.json.JSONObject;

public class Station {

    private String name;
    private Location location;
    private String stationId;
    
    public Station(JSONObject station)
    {
        name = station.getString("name");
        location = new Location(station.getString("lat"),
                                station.getString("lng"));
        stationId = station.getString("stnid");
    }
    public Location getLocation()
    {
    	return location;
    }
    public String getStationId()
    {
    	return stationId;
    }
    public String toString()
    {
        return name + " is at " + location.getLat() + " , " + location.getLon();
    }
}
