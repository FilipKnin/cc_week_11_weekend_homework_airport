import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flightsList;
    private ArrayList<Booking> bookingsList;


    public Airport(String code) {
        this.code = code;
        this.hanger = new ArrayList<>();
        this.flightsList = new ArrayList<>();
        this.bookingsList = new ArrayList<>();
    }

    public String getAirportCode() {
        return this.code;
    }

    public int countPlanesInHanger() {
        return this.hanger.size();
    }


    public void addPlaneToHanger(Plane plane) {
        this.hanger.add(plane);
    }

    public Plane removePlaneFromHanger(Plane plane) {
        int indexOfRemovedPlane = this.hanger.indexOf(plane);
        return this.hanger.remove(indexOfRemovedPlane);
    }

    public int countFlights() {
        return this.flightsList.size();
    }


    public void addFlightToFlightList(Flight flight) {
        this.flightsList.add(flight);
    }

    public String createFlight(String flightNumber, String destination, Plane plane) {
        if (this.hanger.contains(plane)) {
            removePlaneFromHanger(plane);
            Flight newFlight = new Flight(flightNumber, destination);
            newFlight.addPlaneToFlight(plane);
            addFlightToFlightList(newFlight);
            return "Flight number " + flightNumber + " to " + destination + " has been created.";

        } else {
            return "There's no plane you are looking for!";
        }
    }

    public int countBookings() {
        return this.bookingsList.size();
    }

    public String createBooking(Passenger passenger, Flight flight, double price) {
        Booking newBooking = new Booking(passenger, flight, price);
        newBooking.addPassenger(passenger);
        newBooking.addFlight(flight);
        addBookingToBookingsList(newBooking);
        return "New Booking has been created!";

    }

    private void addBookingToBookingsList(Booking booking) {
        this.bookingsList.add(booking);
    }
}
