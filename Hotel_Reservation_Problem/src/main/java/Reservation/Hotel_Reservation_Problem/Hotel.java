package Reservation.Hotel_Reservation_Problem;

public class Hotel {

	
	private String hotelName;
	private int regularRate;
	private int weekendRate;

	
	public Hotel(String hotelName, int regularRate, int weekendRate) {
		this.hotelName = hotelName;
		this.regularRate = regularRate;
		this.weekendRate = weekendRate;
	}

	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularRate() {
		return regularRate;
	}

	public void setRegularRate(int regularRate) {
		this.regularRate = regularRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}
}	
