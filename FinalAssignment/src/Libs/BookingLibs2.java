package Libs;

public class BookingLibs2 {

	int Customer_ID;
	String Name;
	int Booking_ID;
	String CheckIn;
	String CheckOut;
	String Booking_Type;
	String Booking_Status;
	
	
	public BookingLibs2() {
		
		this.Customer_ID = 0;
		this.Name = "";
		this.Booking_ID = 0;
		this.CheckIn = "";
		this.CheckOut = "";
		this.Booking_Type = "";
		this.Booking_Status = "";
	}


	public BookingLibs2(int customer_ID, String name, int booking_ID, String checkIn, String checkOut, 
			String booking_Type, String booking_Status) {
		
		this.Customer_ID = customer_ID;
		this.Name = name;
		this.Booking_ID = booking_ID;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.Booking_Type = booking_Type;
		this.Booking_Status = booking_Status;
	}


	public int getCustomer_ID() {
		return Customer_ID;
	}


	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getBooking_ID() {
		return Booking_ID;
	}


	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
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
		return "BookingLibs2 [Customer_ID=" + Customer_ID + ", Name=" + Name + ", Booking_ID=" + Booking_ID
				+ ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", Booking_Type=" + Booking_Type
				+ ", Booking_Status=" + Booking_Status + "]";
	}


	

}
