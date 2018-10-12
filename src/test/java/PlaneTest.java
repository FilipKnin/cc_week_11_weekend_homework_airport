import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;
    Passenger passenger;


    @Before
    public void before() {
        plane = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        passenger = new Passenger();
    }

    @Test
    public void hasID() {
        assertEquals(1, plane.getId());
    }

    @Test
    public void hasPassengers() {
        assertEquals(0, plane.countPassengers());
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void hasAirlineName() {
        assertEquals(AirlineName.RYANAIR, plane.getAirlineName());
    }
}

