import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Plane plane1;
    Flight flight;
    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Filip Kuszenin");
        plane1 = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        flight = new Flight("MUN001", "Munich");
    }

    @Test
    public void hasID() {
        assertEquals("MUN001", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("Munich", flight.getDestination());
    }

    @Test
    public void hasPlaneEmptyArray() {
        assertEquals(true, flight.flightHasPlane());
    }

    @Test
    public void hasAddPlaneToFlight() {
        flight.addPlaneToFlight(plane1);
        assertEquals(false, flight.flightHasPlane());
    }




}
