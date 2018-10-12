import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Filip Kuszenin");
    }

    @Test
    public void hasName() {
        assertEquals("Filip Kuszenin", passenger.getName());
    }

}
