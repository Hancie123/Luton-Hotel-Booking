package Libs;

public class BookingLibs {
	
	int Booking_ID;
	int Customer_ID;
	String CheckIn;
	String CheckOut;
	int Room_ID;
	String Booking_Type;
	String Booking_Status;
	
	
	public BookingLibs() {
		
		this.Booking_ID = 0;
		this.Customer_ID = 0;
		this.CheckIn = "";
		this.CheckOut = "";
		this.Room_ID = 0;
		this.Booking_Type = "";
		this.Booking_Status="";
	}
	
	public BookingLibs(int booking_ID, int customer_ID, String checkIn, String checkOut, int room_ID,
			String booking_Type, String booking_status) {
		
		this.Booking_ID = booking_ID;
		this.Customer_ID = customer_ID;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.Room_ID = room_ID;
		this.Booking_Type = booking_Type;
		this.Booking_Status=booking_status;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	public int getCustomer_ID() {
		return Customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}

	public String getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}

	public String getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	public String getBooking_Type() {
		return Booking_Type;
	}

	public void setBooking_Type(String booking_Type) {
		Booking_Type = booking_Type;
	}

	public String getBooking_Status() {
		return Booking_Status;
	}

	public void setBooking_Status(String booking_Status) {
		Booking_Status = booking_Status;
	}

	@Override
	public String toString() {
		return "BookingLibs [Booking_ID=" + Booking_ID + ", Customer_ID=" + Customer_ID + ", CheckIn=" + CheckIn
				+ ", CheckOut=" + CheckOut + ", Room_ID=" + Room_ID + ", Booking_Type=" + Booking_Type
				+ ", Booking_Status=" + Booking_Status + "]";
	}

	
	
	   

}
