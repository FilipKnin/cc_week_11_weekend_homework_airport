import java.util.ArrayList;

public class Plane {
    private int id;
    private PlaneType planeType;
    private AirlineName airlineName;
    private ArrayList<Passenger> passengers;

    public Plane(int id, PlaneType planeType, AirlineName airlineName) {
        this.id = id;
        this.planeType = planeType;
        this.airlineName = airlineName;
        this.passengers = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public AirlineName getAirlineName() {
        return this.airlineName;
    }

    public int getPlaneCapacity() {
        return this.planeType.getCapacity();
    }
}
