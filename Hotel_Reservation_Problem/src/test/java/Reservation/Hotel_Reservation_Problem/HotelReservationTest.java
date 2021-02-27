package Reservation.Hotel_Reservation_Problem;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {
	static HotelReservation hotelReservation;

	@BeforeClass
	public static void initialize() {
		hotelReservation = new HotelReservation();
	}

	

	@Test
	public void given_WeekDay_Return_CheapestHotelNameRidgeWood() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-14", "2020-09-16");
		Object[] hotelName = hotelNameList.toArray();
		Object[] ExpectedOutput = { "RidgeWood" };
		Assert.assertArrayEquals(ExpectedOutput, hotelName);
	}

	@Test
	public void given_Weekend_Return_CheapestHotelNameRideWood() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-12", "2020-09-13");
		Object[] hotelName = hotelNameList.toArray();
		Object[] ExpectedOutput = { "RidgeWood" };
		Assert.assertArrayEquals(ExpectedOutput, hotelName);
	}

	@Test
	public void givenWeekDayWeekend_Return_CheapestHotelNameGivesRidgeWood() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-11", "2020-09-12");
		Object[] hotelName = hotelNameList.toArray();
		Object[] ExpectedOutput = { "RidgeWood" };
		Assert.assertArrayEquals(ExpectedOutput, hotelName);
	}

}