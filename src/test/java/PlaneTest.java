import org.junit.Before;

public class PlaneTest {

    Plane plane;
    Passenger passenger;


    @Before
    public void before() {
        plane = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        passenger = new Passenger();
    }
}
