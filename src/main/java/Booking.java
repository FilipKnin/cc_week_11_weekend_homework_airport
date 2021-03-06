import java.util.ArrayList;

public class Booking {
    private ArrayList<Passenger> passengerObject;
    private ArrayList<Flight> BookedFlight;
    private double price;

    public Booking(Passenger passenger, Flight flight, double price  ){
        this.price = price;
        this.BookedFlight = new ArrayList<>();
        this.passengerObject = new ArrayList<>();
    }

    public boolean hasPassenger() {
        boolean outcome = this.passengerObject.isEmpty();
        return !outcome;
    }

    public boolean hasBookedFlight() {
        boolean outcome = this.BookedFlight.isEmpty();
        return !outcome;
    }

    public double getPrice() {
        return this.price;
    }

    public void addPassenger(Passenger passenger) {
        this.passengerObject.add(passenger);
    }

    public void addFlight(Flight flight) {
        this.BookedFlight.add(flight);
    }
}
