package com.bl.invoicegenerator;
public class InvoiceService {
    private static final int NORMAL_COST_PER_MINUTE=1;
    private static final double NORMAL_MINIMUM_COST_PER_KILOMETER=10;
    private static final double NORMAL_MINIMUM_FARE=5;

    private static final int PREMIUM_NORMAL_COST_PER_MINUTE=1;
    private static final double PREMIUM_NORMAL_MINIMUM_COST_PER_KILOMETER=10;
    private static final double PREMIUM_NORMAL_MINIMUM_FARE=5;


    private RideRepository rideRepository;
    public InvoiceService()
    {
        this.rideRepository=new RideRepository();
    }

    public double calculateFare(Ride.RideType rideType, double distance, int time) {
        double totalFare=distance*NORMAL_MINIMUM_COST_PER_KILOMETER+time*NORMAL_COST_PER_MINUTE;
        if(totalFare<NORMAL_MINIMUM_FARE)
            return PREMIUM_NORMAL_MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummery multipleRide(Ride[] rides)
    {
        double totalFare=0;
        for(Ride ride : rides) {
            totalFare += this.calculateFare(ride.rideType, ride.distance, ride.time);
        }
        return new InvoiceSummery(rides.length,totalFare);
    }

    public  void addRides(String userId,Ride[] rides)
    {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummery getInvoiceSummary(String userId) {
        return this.multipleRide(rideRepository.getRides(userId));
    }
}


