package net.ajmiller.Ostrea;

public class Location {
	
	private String lat = null;
	private String lon = null;
	private String name = null;
	
	public Location(String lat, String lon, String name)
	{
		this.lat = lat;
		this.lon = lon;
		this.name = name;
	}
	
	public String getLat()
	{
		return lat;
	}
	
	public String getLon()
	{
		return lon;
	}
	
	public String getName()
	{
		return name;
	}

}
