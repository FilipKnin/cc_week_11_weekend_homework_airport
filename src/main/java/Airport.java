import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flightsList;

    public Airport(String code) {
        this.code = code;
        this.hanger = new ArrayList<>();
        this.flightsList = new ArrayList<>();
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
}
