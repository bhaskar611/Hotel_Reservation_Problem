package Reservation.Hotel_Reservation_Problem;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest 
{
	static HotelReservation hotelReservation;
	@BeforeClass
	public static void initialize() {
		hotelReservation = new HotelReservation();
	}
	
	// testing for cheap hotel for corresponding dates
	@Test
	public void Test() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-14", "2020-09-16");
		Object[] hotelName = hotelNameList.toArray();
		Object[] arrayExpectedOutput = { "LakeWood 3 Rating" };
		Assert.assertArrayEquals(arrayExpectedOutput, hotelName);
	}

	@Test
	public void Test1() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-12", "2020-09-13");
		Object[] hotelName = hotelNameList.toArray();
		Object[] arrayExpectedOutput = { "BridgeWood 4 Rating" };
		Assert.assertArrayEquals(arrayExpectedOutput, hotelName);
	}

	@Test
	public void Test3() throws Exception {
		hotelReservation.HotelDetails();
		ArrayList<String> hotelNameList = hotelReservation.CheapestHotel("2020-09-11", "2020-09-12");
		Object[] hotelName = hotelNameList.toArray();
		Object[] arrayExpectedOutput = { "LakeWood 3 Rating" , "BridgeWood 4 Rating" };
		
		Assert.assertArrayEquals(arrayExpectedOutput, hotelName);
	}

}
