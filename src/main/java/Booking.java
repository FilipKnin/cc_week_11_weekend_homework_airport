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
        return this.passengerObject.isEmpty();
    }
}
