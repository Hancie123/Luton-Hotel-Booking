package Libs;

public class BillingLibs {
	
	int Billing_ID;
	int Booking_ID;
	String Name;
	int VAT;
	int Service_Charge;
	int Room_Price;
	int Service_Price;
	int Restaurant_Price;
	int Bar_Price;
	double Total_Bill;
	String Billing_Status;
	long Discount;
	
	
	
	public BillingLibs() {
		
		this.Billing_ID = 0;
		this.Booking_ID = 0;
		this.Name = "";
		this.VAT = 0;
		this.Service_Charge = 0;
		this.Room_Price = 0;
		this.Service_Price = 0;
		this.Restaurant_Price = 0;
		this.Bar_Price = 0;
		this.Total_Bill = 0.0;
		this.Billing_Status = "";
		this.Discount = 00;
	}
	
	public BillingLibs(int billing_ID, int booking_ID, String name, int vAT, int service_Charge, int room_Price,
			int service_Price, int restaurant_Price, int bar_Price, double total_Bill, String billing_Status,
			long discount) {
		
		this.Billing_ID = billing_ID;
		this.Booking_ID = booking_ID;
		this.Name = name;
		this.VAT = vAT;
		this.Service_Charge = service_Charge;
		this.Room_Price = room_Price;
		this.Service_Price = service_Price;
		this.Restaurant_Price = restaurant_Price;
		this.Bar_Price = bar_Price;
		this.Total_Bill = total_Bill;
		this.Billing_Status = billing_Status;
		this.Discount = discount;
	}

	public int getBilling_ID() {
		return Billing_ID;
	}

	public void setBilling_ID(int billing_ID) {
		Billing_ID = billing_ID;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getVAT() {
		return VAT;
	}

	public void setVAT(int vAT) {
		VAT = vAT;
	}

	public int getService_Charge() {
		return Service_Charge;
	}

	public void setService_Charge(int service_Charge) {
		Service_Charge = service_Charge;
	}

	public int getRoom_Price() {
		return Room_Price;
	}

	public void setRoom_Price(int room_Price) {
		Room_Price = room_Price;
	}

	public int getService_Price() {
		return Service_Price;
	}

	public void setService_Price(int service_Price) {
		Service_Price = service_Price;
	}

	public int getRestaurant_Price() {
		return Restaurant_Price;
	}

	public void setRestaurant_Price(int restaurant_Price) {
		Restaurant_Price = restaurant_Price;
	}

	public int getBar_Price() {
		return Bar_Price;
	}

	public void setBar_Price(int bar_Price) {
		Bar_Price = bar_Price;
	}

	public double getTotal_Bill() {
		return Total_Bill;
	}

	public void setTotal_Bill(double total_Bill) {
		Total_Bill = total_Bill;
	}

	public String getBilling_Status() {
		return Billing_Status;
	}

	public void setBilling_Status(String billing_Status) {
		Billing_Status = billing_Status;
	}

	public long getDiscount() {
		return Discount;
	}

	public void setDiscount(long discount) {
		Discount = discount;
	}

	@Override
	public String toString() {
		return "BillingLibs [Billing_ID=" + Billing_ID + ", Booking_ID=" + Booking_ID + ", Name=" + Name + ", VAT="
				+ VAT + ", Service_Charge=" + Service_Charge + ", Room_Price=" + Room_Price + ", Service_Price="
				+ Service_Price + ", Restaurant_Price=" + Restaurant_Price + ", Bar_Price=" + Bar_Price
				+ ", Total_Bill=" + Total_Bill + ", Billing_Status=" + Billing_Status + ", Discount=" + Discount + "]";
	}
	
	
	
	
}
