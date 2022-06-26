package Libs;

public class ServicesLibs {
	
	int Services_ID;
	String Services_Type;
	double Services_Price;
	int Booking_ID;
	
	
   public ServicesLibs() {
		
		this.Services_ID = 0;
		this.Services_Type = "";
		this.Services_Price = 0;
		this.Booking_ID = 0;
	}
	
	public ServicesLibs(int services_ID, String services_Type, double services_Price, int booking_ID) {
		
		this.Services_ID = services_ID;
		this.Services_Type = services_Type;
		this.Services_Price = services_Price;
		this.Booking_ID = booking_ID;
	}

	public int getServices_ID() {
		return Services_ID;
	}

	public void setServices_ID(int services_ID) {
		Services_ID = services_ID;
	}

	public String getServices_Type() {
		return Services_Type;
	}

	public void setServices_Type(String services_Type) {
		Services_Type = services_Type;
	}

	public double getServices_Price() {
		return Services_Price;
	}

	public void setServices_Price(double services_Price) {
		Services_Price = services_Price;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	@Override
	public String toString() {
		return "ServicesLibs [Services_ID=" + Services_ID + ", Services_Type=" + Services_Type + ", Services_Price="
				+ Services_Price + ", Booking_ID=" + Booking_ID + "]";
	}

	
	

}
