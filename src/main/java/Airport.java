import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Plane> hanger;

    public Airport(String code) {
        this.code = code;
        this.hanger = new ArrayList<>();
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
}
