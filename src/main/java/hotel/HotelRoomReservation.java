package hotel;

import hotel.dao.HotelCal;
import hotel.model.Hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelRoomReservation {

    public static void main(String[] args) {


        try {
            HotelRoomReservation hotelRoomReservation = new HotelRoomReservation();
            String output = hotelRoomReservation.getCheapest(args);
            System.out.println("Output: " + output);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getCheapest(String[] args) throws ParseException {
        String customerType = args[0].replace(":", "");

        String date1 = args[1].substring(0, args[1].indexOf("("));
        String date2 = args[2].substring(0, args[1].indexOf("("));
        String date3 = args[3].substring(0, args[1].indexOf("("));

        System.out.println("INPUT Customer type: " + customerType + " date1: " + date1
                + " date2: " + date2 + "date3: " + date3);
        Date date1Format = new SimpleDateFormat("ddMMMyyyy").parse(date1);
        Date date2Format = new SimpleDateFormat("ddMMMyyyy").parse(date2);
        Date date3Format = new SimpleDateFormat("ddMMMyyyy").parse(date3);

        int day1 = date1Format.getDay();
        int day2 = date2Format.getDay();
        int day3 = date3Format.getDay();

        List<Hotel> load = load();
        List<HotelCal> hotelCalList = new ArrayList<>();
        load.stream().forEach((hotel) -> {

            int totalPrice = 0;
            if (customerType.equalsIgnoreCase("Regular")) {
                if (day1 == 0 || day1 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRegularRate();
                } else {
                    totalPrice += hotel.getWeekDayRegularRate();
                }
                if (day2 == 0 || day2 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRegularRate();
                } else {
                    totalPrice += hotel.getWeekDayRegularRate();
                }
                if (day3 == 0 || day3 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRegularRate();
                } else {
                    totalPrice += hotel.getWeekDayRegularRate();
                }
            } else {
                if (day1 == 0 || day1 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRewardsRate();
                } else {
                    totalPrice += hotel.getWeekDayRewardsRate();
                }
                if (day2 == 0 || day2 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRewardsRate();
                } else {
                    totalPrice += hotel.getWeekDayRewardsRate();
                }
                if (day3 == 0 || day3 == 6) {
                    //weekend
                    totalPrice += hotel.getWeekEndRewardsRate();
                } else {
                    totalPrice += hotel.getWeekDayRewardsRate();
                }
            }
            HotelCal hotelCal = new HotelCal(hotel.getName(), totalPrice, hotel.getRating());
            hotelCalList.add(hotelCal);
        });
        hotelCalList.sort(new HotelCal());
        hotelCalList.stream().forEach(hotelCal -> {
            System.out.println(hotelCal.getName() + " " + hotelCal.getTotalPrice());

        });
        String output = null;
        if (hotelCalList.get(0).getTotalPrice() == hotelCalList.get(1).getTotalPrice()) {
            if (hotelCalList.get(0).getRating() < hotelCalList.get(1).getRating()) {
                output = hotelCalList.get(1).getName();
            } else {
                output = hotelCalList.get(0).getName();
            }

        } else {
            output = hotelCalList.get(0).getName();
        }
        return output;
    }

    public List<Hotel> load() {
        List hotels = new ArrayList();
        Hotel hotelLakewood = new Hotel("Lakewood", 3, 110, 80, 90, 80);
        Hotel hotelBridgewood = new Hotel("Bridgewood", 4, 160, 110, 60, 50);
        Hotel hotelRidgewood = new Hotel("Ridgewood", 5, 220, 100, 150, 40);
        hotels.add(hotelLakewood);
        hotels.add(hotelBridgewood);
        hotels.add(hotelRidgewood);
        return hotels;

    }
}
