package com.bl.invoicegenerator;
public class InvoiceService {
    private static final int COST_PER_MINUTE=1;
    private static final double MINIMUM_COST_PER_KILOMETER=10;
    private static final double MINIMUM_FARE=5;

    private RideRepository rideRepository;
    public InvoiceService()
    {
        this.rideRepository=new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        double totalFare=distance*MINIMUM_COST_PER_KILOMETER+time*COST_PER_MINUTE;
        if(totalFare<MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public InvoiceSummery multipleRide(Ride[] rides)
    {
        double totalFare=0;
        for(Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
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


