import java.util.ArrayList;

public class Flight {

    private String flightNumber;
    private String destination;
    private ArrayList<Plane> plane;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.plane = new ArrayList<>();
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }
}
