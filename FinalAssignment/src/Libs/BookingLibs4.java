package Libs;

public class BookingLibs4 {

	int Customer_ID;
	String Name;
	int Booking_ID;
	String Booking_Status;

	public BookingLibs4() {

		this.Customer_ID = 0;
		this.Name = "";
		this.Booking_ID = 0;
		this.Booking_Status = "";
	}

	public BookingLibs4(int customer_ID, String name, int booking_ID, String booking_Status) {

		this.Customer_ID = customer_ID;
		this.Name = name;
		this.Booking_ID = booking_ID;
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

	public String getBooking_Status() {
		return Booking_Status;
	}

	public void setBooking_Status(String booking_Status) {
		Booking_Status = booking_Status;
	}

	@Override
	public String toString() {
		return "BookingLibs4 [Customer_ID=" + Customer_ID + ", Name=" + Name + ", Booking_ID=" + Booking_ID
				+ ", Booking_Status=" + Booking_Status + "]";
	}
	
	

}
