import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

    private String code;
    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flightsList;
    private ArrayList<Booking> bookingsList;
    private HashMap<Flight, Integer> flightCounts;


    public Airport(String code) {
        this.code = code;
        this.hanger = new ArrayList<>();
        this.flightsList = new ArrayList<>();
        this.bookingsList = new ArrayList<>();
        this.flightCounts = new HashMap<>();
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
        Plane plane = flight.getPlaneForFlight();
        if (plane.checkSpace() == true) {
            Booking newBooking = new Booking(passenger, flight, price);
            newBooking.addPassenger(passenger);
            newBooking.addFlight(flight);
            plane.addPassenger(passenger);
            incrementFlightCount(flight);
            addBookingToBookingsList(newBooking);
            return "New Booking has been created!";
        }
            return "This flight is fully-booked!";

    }

    public void addBookingToBookingsList(Booking booking) {
        this.bookingsList.add(booking);
    }

    public HashMap<Flight, Integer> getFlightCounts() {
        return this.flightCounts;
    }

    public void incrementFlightCount(Flight flight) {
        Integer flightCount = flightCounts.get(flight);
        if (flightCount == null) {
            flightCount = 0;
        }
        flightCounts.put(flight, flightCount + 1);
    }


    public Plane findMostSuitablePlane(Flight flight) {
        Plane defaultPlane = flight.getPlaneForFlight();
        ArrayList<Passenger> passengersList = defaultPlane.getPassengers();
        Plane mostSuitablePlane = defaultPlane;

        for (int i = 0; i <this.hanger.size() ; i++) {
            Plane plane = this.hanger.get(i);
            plane.replaceListOfPassengers(passengersList);
            if (plane.checkEmptySeats() < mostSuitablePlane.checkEmptySeats() && mostSuitablePlane.checkEmptySeats() >= 0) {
                mostSuitablePlane = plane;
            }
        }
        mostSuitablePlane.replaceListOfPassengers(passengersList);
        return mostSuitablePlane;
    }

    public Plane findReplacementPlane(Flight flight) {
        Plane defaultPlane = this.hanger.get(1);

        Plane brokenPlane = flight.getPlaneForFlight();
        for (int i = 0; i <this.hanger.size() ; i++) {
            Plane plane = this.hanger.get(i);
            if (plane.getPlaneCapacity() >= brokenPlane.getPlaneCapacity()) {
                defaultPlane = plane;
            }
        }

        ArrayList<Passenger> passengersList = brokenPlane.getPassengers();
        Plane replacementPlane = defaultPlane;

        for (int i = 0; i <this.hanger.size() ; i++) {
            Plane plane = this.hanger.get(i);
            plane.replaceListOfPassengers(passengersList);
            if (plane.checkEmptySeats() < replacementPlane.checkEmptySeats() && replacementPlane.checkEmptySeats() >= 0) {
                replacementPlane = plane;
            }
        }
        replacementPlane.replaceListOfPassengers(passengersList);
        return replacementPlane;
    }
}
