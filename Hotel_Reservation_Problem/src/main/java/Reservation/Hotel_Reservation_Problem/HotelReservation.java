package Reservation.Hotel_Reservation_Problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class HotelReservation {
	ArrayList<Hotel> hotelList;
	long minCostLakeWood;
	long minCostBridgeWood;
	long minCostRidgeWood;
	long totalDays;
	long weekDays;
	long weekendDays;
	int rating;
	
	// Constructor
		public HotelReservation() {
		hotelList = new ArrayList<>();
	}
	
	

	public void HotelDetails() {
		hotelList.add(new Hotel("LakeWood", 3, 110, 90));
		hotelList.add(new Hotel("BridgeWood", 4, 150, 50));
		hotelList.add(new Hotel("RidgeWood", 5, 220, 150));
	}

	// count week days 
	private static long countWeekDaysMath(LocalDate arrival, LocalDate departure) {
		long count = 0;
		final DayOfWeek startDay = arrival.getDayOfWeek();
		final DayOfWeek endDay = departure.getDayOfWeek();

		final long days = ChronoUnit.DAYS.between(arrival, departure);
		final long daysWithoutWeekends = days - 2 * ((days + startDay.getValue()) / 7);

		// adjust for starting and ending on a Sunday:
		count = daysWithoutWeekends + (startDay == DayOfWeek.SUNDAY ? 1 : 0) + (endDay == DayOfWeek.SUNDAY ? 1 : 0);
		return count;
	}

	// Find cheapest hotel
	public ArrayList<String> CheapestCost(long weekDays, long weekendDays) {
		ArrayList<String> hotel = new ArrayList<>();
		minCostLakeWood = 0;long cost = 0; minCostBridgeWood = 0; minCostRidgeWood = 0; rating = 0; String hotelName = null;
		minCostLakeWood = (hotelList.get(0).getRegularRate() * weekDays
				+ hotelList.get(0).getWeekendRate() * weekendDays);
		minCostBridgeWood = (hotelList.get(1).getRegularRate() * weekDays
				+ hotelList.get(1).getWeekendRate() * weekendDays);
		minCostRidgeWood = (hotelList.get(2).getRegularRate() * weekDays
				+ hotelList.get(2).getWeekendRate() * weekendDays);
		long minCostHotel = Math.min(minCostRidgeWood, Math.min(minCostBridgeWood, minCostLakeWood));
		if ((hotelList.get(2).getHotelRating() > rating)) {
			hotelName = hotelList.get(2).getHotelName();
			cost = minCostRidgeWood;
			rating = hotelList.get(2).getHotelRating();
			hotel.add(hotelName);
		}
		if ((hotelList.get(1).getHotelRating() > rating)) {
			hotelName = hotelList.get(1).getHotelName();
			cost = minCostBridgeWood;
			rating = hotelList.get(1).getHotelRating();
			hotel.add(hotelName);
		}
		if ((hotelList.get(0).getHotelRating() > rating)) {
			hotelName = hotelList.get(0).getHotelName();
			cost = minCostLakeWood;
			rating = hotelList.get(0).getHotelRating();
			hotel.add(hotelName);
		}
		System.out.println("Cost for "+hotelName+" is " + cost + " & rating is " + rating);
		return hotel;
	}

	// Calculated rate based on period of stay at hotel
	public ArrayList<String> CheapestHotel(String dateOfArrival, String dateOfDeparture)throws Exception {
		totalDays = 0; weekDays = 0; weekendDays = 0;
		LocalDate dateArrival = LocalDate.parse(dateOfArrival);
		LocalDate dateDeparture = LocalDate.parse(dateOfDeparture);
		totalDays = ChronoUnit.DAYS.between(dateArrival, dateDeparture) + 1;
		weekDays = countWeekDaysMath(dateArrival, dateDeparture);
		weekendDays = totalDays - weekDays;
		return CheapestCost(weekDays, weekendDays);
	}

}