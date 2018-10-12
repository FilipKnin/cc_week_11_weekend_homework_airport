import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Plane> hanger;
    private ArrayList<Flight> flights;

    public Airport(String code) {
        this.code = code;
        this.hanger = new ArrayList<>();
        this.flights = new ArrayList<>();
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
        return this.flights.size();
    }
}
