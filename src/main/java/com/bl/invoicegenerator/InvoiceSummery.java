package com.bl.invoicegenerator;
public class InvoiceSummery {
    private final double totalFare;
    private final int numberOfRides;
    private final double averageFare;

    public InvoiceSummery(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numberOfRides;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvoiceSummery that=(InvoiceSummery)obj;
        return numberOfRides == that.numberOfRides
                && Double.compare(that.totalFare, totalFare) == 0
                && Double.compare(that.averageFare, averageFare) == 0;
    }
}