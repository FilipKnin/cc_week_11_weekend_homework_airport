import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane1;
    Plane plane2;
    Flight flight1;
    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Filip Kuszenin");
        plane1 = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        plane2 = new Plane(2, PlaneType.BOEING747, AirlineName.RYANAIR);
        flight1 = new Flight("MUN001", "Munich");
        airport = new Airport("EDI");
    }

    @Test
    public void hasCode() {
        assertEquals("EDI", airport.getAirportCode());
    }

    @Test
    public void countPlanesInHanger() {
        assertEquals(0, airport.countPlanesInHanger());
    }

    @Test
    public void addPlaneToHanger() {
        airport.addPlaneToHanger(plane1);
        assertEquals(1, airport.countPlanesInHanger());
    }

    @Test
    public void removePlaneFromHanger() {
        airport.addPlaneToHanger(plane1);
        airport.removePlaneFromHanger(plane1);
        assertEquals(0, airport.countPlanesInHanger());
    }
    @Test
    public void removePlaneFromHangerTwoPlanesInHanger() {
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane1);
        airport.removePlaneFromHanger(plane1);
        assertEquals(1, airport.countPlanesInHanger());
        assertEquals(plane1, airport.removePlaneFromHanger(plane1));
    }

    @Test
    public void countFlights() {
        airport.addPlaneToHanger(plane1);
        assertEquals(0, airport.countFlights());
    }

    @Test
    public void addFlightToFlightsList() {
        airport.addFlightToFlightList(flight1);
        assertEquals(1, airport.countFlights());
    }

    @Test
    public void createFlightPlaneInHanger() {
        airport.addPlaneToHanger(plane1);
        String returningMessage = airport.createFlight("LON002", "London", plane1);
        assertEquals(1, airport.countFlights());
        assertEquals(0, airport.countPlanesInHanger());
        assertEquals("Flight number LON002 to London has been created.",returningMessage);
    }

    @Test
    public void createFlightNoPlaneInHanger() {
        String returningMessage = airport.createFlight("LON002", "London", plane1);
        assertEquals(0, airport.countFlights());
        assertEquals("There's no plane you are looking for!", returningMessage);
    }

//    @Test
//    public void countBookings() {
//        airport.createBooking();
//        assertEquals(1, airport.countBookings());
//    }



}
