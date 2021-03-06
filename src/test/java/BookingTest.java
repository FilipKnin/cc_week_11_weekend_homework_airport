import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Airport airport;
    Plane plane1;
    Plane plane2;
    Flight flight1;
    Passenger passenger;
    Booking booking ;

    @Before
    public void before() {
        passenger = new Passenger("Filip Kuszenin");
        plane1 = new Plane(1, PlaneType.BOEING747, AirlineName.RYANAIR);
        plane2 = new Plane(2, PlaneType.BOEING747, AirlineName.RYANAIR);
        flight1 = new Flight("MUN001", "Munich");
        booking = new Booking(passenger, flight1, 250.00);
        airport = new Airport("EDI");

    }

    @Test
    public void hasPassengerObjectNoObject() {
        assertEquals(false, booking.hasPassenger());
    }

    @Test
    public void hasBookedFlight() {
        assertEquals(false, booking.hasBookedFlight());
    }

    @Test
    public void hasPrice() {
        assertEquals(250.00, booking.getPrice(), 0.01);
    }

    @Test
    public void hasAddPassenger() {
        booking.addPassenger(passenger);
        assertEquals(true, booking.hasPassenger());
    }

    @Test
    public void hasAddFlight() {
        booking.addFlight(flight1);
        assertEquals(true, booking.hasBookedFlight());
    }



}
