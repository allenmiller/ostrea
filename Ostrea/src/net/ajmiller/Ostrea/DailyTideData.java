package net.ajmiller.Ostrea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyTideData {
    
    private ArrayList<?> tidePredictions;
    private Date sunrise;
    private Date sunset;
    private Date moonrise;
    private Date moonset;
    private Date highTide1;
    private Date highTide2;
    private Date lowTide1;
    private Date lowTide2;
    private String datum;
    private List<Alert> alerts;

    public ArrayList<?> getTidePredictions()
    {
        return tidePredictions;
    }
    public Date getSunrise()
    {
        return sunrise;
    }
    public Date getSunset()
    {
        return sunset;
    }
    public Date getMoonRise()
    {
        return moonrise;
    }
    public Date getMoonSet()
    {
        return moonset;
    }
    
    public Date getHighTide1()
    {
        return highTide1;
    }
    public Date getHighTide2()
    {
        return highTide2;
    }
    public Date getLowTide1()
    {
        return lowTide1;
    }
    public Date getLowTide2()
    {
        return lowTide2;
    }
    public String getDatum()
    {
        return datum;
    }
    
    public List<Alert> getAlerts()
    {
        return alerts;
    }
}
