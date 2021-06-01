package hotel.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelCal implements Comparator<HotelCal> {
    private String name;
    private int totalPrice;
    private int rating;

    @Override
    public int compare(HotelCal o1, HotelCal o2) {
        if (o1.getTotalPrice() == o2.getTotalPrice()) {
            return 0;

        } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
            return -1;
        } else {
            return 1;
        }
    }
}
