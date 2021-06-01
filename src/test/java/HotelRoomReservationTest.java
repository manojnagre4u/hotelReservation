import hotel.HotelRoomReservation;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

public class HotelRoomReservationTest {
    @Test
    public void getChepestHotelTest() {
        HotelRoomReservation hotelRoomReservation = new HotelRoomReservation();
        try {
            String[] arguments = new String[4];
            arguments[0] = "Rewards:";
            arguments[1] = "26Mar2009(thur),";
            arguments[2] = "27Mar2009(fri),";
            arguments[3] = "28Mar2009(sat)";
            String output = hotelRoomReservation.getCheapest(arguments);
            Assert.assertEquals("Ridgewood", output);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
