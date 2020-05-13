package com.bl.invoicegenerator;
public class InvoiceService
{
    private RideRepository rideRepository;
    public InvoiceService()
    {
        this.rideRepository=new RideRepository();
    }

    public InvoiceSummary multipleRide(Ride[] rides)
    {
        double totalFare=0;
        for(Ride ride : rides) {
            totalFare += ride.cabRide.calcCostOfCabRide(ride);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public  void addRides(String userId,Ride[] rides)
    {
        rideRepository.addRides(userId,rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.multipleRide(rideRepository.getRides(userId));
    }

    public void setRideRepository(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
}


