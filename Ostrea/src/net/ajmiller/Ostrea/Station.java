package net.ajmiller.Ostrea;

import org.json.JSONObject;

public class Station {

    private String name;
    private Location location;
    private String stationId;
    private String harcon;
    private Boolean isHarmonic = Boolean.FALSE;
    
    public Station(JSONObject station)
    {
        name = station.getString("name");
        location = new Location(station.getString("lat"),
                                station.getString("lng"));
        stationId = station.getString("stnid");
        harcon = station.getString("harcon");
        if (harcon.equals("1"))
        {
        	isHarmonic = Boolean.TRUE;
        }
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
    public Boolean getIsHarmonic()
    {
    	return isHarmonic;
    }
}
