package Reservation.Hotel_Reservation_Problem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class HotelReservation {

	ArrayList<Hotel> hotelList = new ArrayList<>();

	long minCostLakeWood;
	long minCostBridgeWood;
	long minCostRidgeWood;
	long totalDays;
	long weekDays;
	long weekendDays;

	public void HotelDetails() {
		hotelList.add(new Hotel("Lakewood", 3, 110, 90));
		hotelList.add(new Hotel("Bridgewood", 4, 150, 50));
		hotelList.add(new Hotel("Ridgewood", 5, 220, 150));
	}
	


	private static long countWeekDaysMath(LocalDate arrival, LocalDate departure) {
		long count = 0;
		final DayOfWeek arrivalday = arrival.getDayOfWeek();
		final DayOfWeek departureday = departure.getDayOfWeek();

		final long days = ChronoUnit.DAYS.between(arrival, departure);
		final long daysWithoutWeekends = days - 2 * ((days + arrivalday.getValue()) / 7);

		// adjust for starting and ending on a Sunday:
		count = daysWithoutWeekends + (arrivalday == DayOfWeek.SUNDAY ? 1 : 0) + (departureday == DayOfWeek.SUNDAY ? 1 : 0);
		return count;
	}

	//Find cheap hotel
	public ArrayList<String> CheapCost(long weekDays, long weekendDays ) {
		ArrayList<String> hotel = new ArrayList<>();
		minCostLakeWood = 0;
		minCostBridgeWood = 0;
		minCostRidgeWood = 0;
		minCostLakeWood = (hotelList.get(0).getRegularRate() * weekDays
				+ hotelList.get(0).getWeekendRate() * weekendDays);
		minCostBridgeWood = (hotelList.get(1).getRegularRate() * weekDays
				+ hotelList.get(1).getWeekendRate() * weekendDays);
		minCostRidgeWood = (hotelList.get(2).getRegularRate() * weekDays
				+ hotelList.get(2).getWeekendRate() * weekendDays);
		long minCostHotel = Math.min(minCostRidgeWood, Math.min(minCostBridgeWood, minCostLakeWood));
		if (minCostHotel == minCostLakeWood)
			hotel.add("LakeWood 3 Rating" );
		if (minCostHotel == minCostBridgeWood)
			hotel.add("BridgeWood 4 Rating");
		if (minCostHotel == minCostRidgeWood)
			hotel.add("RidgeWood 5 Rating");
		System.out.println("The minimum cost for Hotel is " + minCostHotel + hotel);
		return hotel;
	}

	// Calculated rate based on period of stay at hotel
	public ArrayList<String> CheapestHotel(String Arrival, String Departure) throws Exception {
		totalDays = 0;
		weekDays = 0;
		weekendDays = 0;
		LocalDate dateArrival = LocalDate.parse(Arrival);
		LocalDate dateDeparture = LocalDate.parse(Departure);
		totalDays = ChronoUnit.DAYS.between(dateArrival, dateDeparture) + 1;
		weekDays = countWeekDaysMath(dateArrival, dateDeparture);
		weekendDays = totalDays - weekDays;
		return CheapCost(weekDays, weekendDays);
	}

}