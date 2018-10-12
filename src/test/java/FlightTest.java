import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Plane plane;
    Flight flight;
    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger();
        plane = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        flight = new Flight("MUN001", "Munich");
    }

    @Test
    public void hasID() {
        assertEquals("MUN001", flight.getFlightNumber());
    }


}
