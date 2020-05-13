package com.bl.cabservice;
import com.bl.invoicegenerator.InvoiceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest {
    InvoiceService invoiceService;

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinimumFare() {
        double distance = 0.3;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    public void givenMultipleRides_whenRide_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0,5), new Ride(0.1,1)};
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }
}
