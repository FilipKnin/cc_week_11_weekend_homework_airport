import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;
    Plane plane1;
    Plane plane2;
    Plane plane3;
    Plane plane4;
    Plane plane5;
    Flight flight1;
    Passenger passenger1;
    Passenger passenger2;
    Booking booking1;
    Booking booking2;

    @Before
    public void before() {
        passenger1 = new Passenger("Filip Kuszenin");
        passenger2 = new Passenger("Johny Bravo");
        plane1 = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        plane2 = new Plane(2, PlaneType.BOEING747, AirlineName.RYANAIR);
        plane3 = new Plane(3, PlaneType.BOEING787, AirlineName.RYANAIR);
        plane4 = new Plane(4, PlaneType.AIRBUS350, AirlineName.RYANAIR);
        plane5 = new Plane(5, PlaneType.AIRBUS380, AirlineName.RYANAIR);
        flight1 = new Flight("MUN001", "Munich");
        booking1 = new Booking(passenger1, flight1, 250.00);
        booking2 = new Booking(passenger2, flight1, 250.00);
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

    @Test
    public void hasCreateBookings() {
        flight1.addPlaneToFlight(plane1);
        String outcome = airport.createBooking(passenger1, flight1, 250.00);
        airport.createBooking(passenger1, flight1, 250.00);
        assertEquals(2, airport.countBookings());
        assertEquals("New Booking has been created!", outcome);
    }

    @Test
    public void canNotCreateBookingIfPlaneIsFull() {
        flight1.addPlaneToFlight(plane1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger1);
        plane1.addPassenger(passenger1);
        String outcome = airport.createBooking(passenger1, flight1, 250.00);
        assertEquals(0, airport.countBookings());
        assertEquals("This flight is fully-booked!", outcome);
        assertEquals(5, plane1.countPassengers());

    }

    @Test
    public void hasFlightCounter() {
        flight1.addPlaneToFlight(plane1);
        booking1.addFlight(flight1);
        airport.addBookingToBookingsList(booking1);
        airport.addBookingToBookingsList(booking2);
        HashMap<Flight, Integer> result = airport.getFlightCounts();
//        int count = result.get(booking1.getFlightForBooking());
//        assertEquals(2, airport.countBookings());
//        assertEquals(2, count);

    }

    @Test
    public void canFindMostSuitablePlane() {
        plane3.addPassenger(passenger1);
        flight1.addPlaneToFlight(plane3);
        airport.addPlaneToHanger(plane1);
        airport.addPlaneToHanger(plane4);
        airport.addPlaneToHanger(plane5);
        booking1.addFlight(flight1);
        booking2.addFlight(flight1);
        airport.addBookingToBookingsList(booking1);
        airport.addBookingToBookingsList(booking2);
        assertEquals(plane1, airport.findMostSuitablePlane(flight1));
        assertEquals(1, plane1.countPassengers());


    }

//    @Test
//    public void canFindReplacementPlane() {
//        plane3.addPassenger(passenger1);
//        plane3.addPassenger(passenger1);
//        flight1.addPlaneToFlight(plane3);
//        airport.addPlaneToHanger(plane1);
//        airport.addPlaneToHanger(plane4);
//        airport.addPlaneToHanger(plane5);
//        booking1.addFlight(flight1);
//        booking2.addFlight(flight1);
//        airport.addBookingToBookingsList(booking1);
//        airport.addBookingToBookingsList(booking2);
//        assertEquals(plane1, airport.findMostSuitablePlane(flight1));
//
//    }





}
