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

    public boolean checkSpace() {
        int planeCapacity = getPlaneCapacity();
        int numberOfPassengers = countPassengers();

        if (numberOfPassengers < planeCapacity) {
            return true;
        }
            return false;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public int checkEmptySeats() {
        int planeCapacity = getPlaneCapacity();
        int seatsTaken = countPassengers();
        return planeCapacity - seatsTaken;
    }

    public ArrayList getPassengers() {
        return this.passengers;
    }

    public void replaceListOfPassengers(ArrayList newListOfPassengers) {
        this.passengers = newListOfPassengers;
    }
}
