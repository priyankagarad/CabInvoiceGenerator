package com.bl.invoicegenerator;
public class Ride {
   public enum RideType{NORMAL,PREMIUM};
    public CabRide cabRide;

    public double distance;
    public int time;

    public Ride(CabRide cabRide,double distance,int time)
    {
        this.cabRide=cabRide;
        this.distance=distance;
        this.time=time;
    }
}
