package com.bl.cabservice;
import com.bl.invoicegenerator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest {
    private InvoiceService invoiceService=null;
    InvoiceSummary expectedInvoiceSummary = null;
    private RideRepository rideRepository = null;
    Ride[] rides;

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();

    rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
    rides = new Ride[]{
        new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)
    };
    expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
}

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        InvoiceSummary summery = invoiceService.multipleRide(rides);
        Assert.assertEquals(expectedInvoiceSummary, summery);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "abc.com";
        Ride[] rides = {
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}

