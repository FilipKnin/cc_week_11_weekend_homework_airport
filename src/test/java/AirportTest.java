import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane1;
    Flight flight;
    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger();
        plane1 = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        flight = new Flight("MUN001", "Munich");
        airport = new Airport("EDI");
    }

    @Test
    public void hasCode() {
        assertEquals("EDI", airport.getAirportCode());
    }

    @Test
    public void countPlanesInHangar() {
        assertEquals(0, airport.countPlanesInHangar());
    }






}
