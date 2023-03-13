public class CabInvoiceGeneratorMain {

    public static void main(String[] args) {
        // create some sample rides
        Ride ride1 = new Ride(10.0, 30, true); // premium ride
        Ride ride2 = new Ride(5.0, 15, false); // normal ride
        Ride ride3 = new Ride(20.0, 45, true); // premium ride

        // create a ride repository and add some rides for a user
        RideRepository rideRepository = new RideRepository();
        rideRepository.addRideForUser("user1", ride1);
        rideRepository.addRideForUser("user1", ride2);
        rideRepository.addRideForUser("user1", ride3);

        // generate invoice for user1 using the invoice service
        InvoiceService invoiceService = new InvoiceService(rideRepository);
        InvoiceGenerator invoiceGenerator = invoiceService.generateInvoiceForUser("user1");

        // print the invoice details
        System.out.println("Total number of rides: " + invoiceGenerator.getTotalRides());
        System.out.println("Total fare: Rs. " + invoiceGenerator.getTotalFare());
        System.out.println("Average fare per ride: Rs. " + invoiceGenerator.getAverageFarePerRide());
    }

}
