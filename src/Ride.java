import java.util.ArrayList;
import java.util.List;

// Class to represent a single ride
class Ride {
    private double distance;
    private int time;
    private boolean isPremium;

    public Ride(double distance, int time, boolean isPremium) {
        this.distance = distance;
        this.time = time;
        this.isPremium = isPremium;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean isPremium() {
        return isPremium;
    }
}

// Class to generate invoices for multiple rides
class InvoiceGenerator {
    private List<Ride> rides;

    public InvoiceGenerator() {
        rides = new ArrayList<Ride>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public int getTotalRides() {
        return rides.size();
    }

    public double getTotalFare() {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.isPremium());
        }
        return totalFare;
    }

    public double getAverageFarePerRide() {
        if (rides.size() == 0) {
            return 0.0;
        }
        return getTotalFare() / rides.size();
    }

    private double calculateFare(double distance, int time, boolean isPremium) {
        double costPerKm = isPremium ? 15 : 10;
        int costPerMin = isPremium ? 2 : 1;
        double fare = (distance * costPerKm) + (time * costPerMin);
        return Math.max(fare, isPremium ? 20 : 5); // minimum fare of Rs. 20 for premium rides and Rs. 5 for normal rides
    }
}

// Class to retrieve rides for a user and generate invoices
class InvoiceService {
    private RideRepository rideRepository;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public InvoiceGenerator generateInvoiceForUser(String userId) {
        List<Ride> rides = rideRepository.getRidesForUser(userId);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        for (Ride ride : rides) {
            invoiceGenerator.addRide(ride);
        }
        return invoiceGenerator;
    }
}

// Class to store and retrieve rides for a user
class RideRepository {
    private List<Ride> rides;

    public RideRepository() {
        rides = new ArrayList<Ride>();
    }

    public void addRideForUser(String userId, Ride ride) {
        // logic to add ride to list of rides for a user
    }

    public List<Ride> getRidesForUser(String userId) {
        // logic to retrieve list of rides for a user
        return rides;
    }
}
