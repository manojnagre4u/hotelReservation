package hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private String name;
    private int rating;
    private int weekDayRegularRate;
    private int weekDayRewardsRate;
    private int weekEndRegularRate;
    private int weekEndRewardsRate;

}
