package Libs;

public class BillingLibs2 {
	
	
	int Booking_ID;
	String Name;
	int Room_ID;
	String Room_Status;
	int Room_Rate;
	String CheckIn;
	String CheckOut;
	int Service_Price;
	int Drink_Amount;
	int Item_Amount;
	String Credit_Number;
	
	public BillingLibs2() {
		
		
		this.Booking_ID=0;
		this.Name = "";
		this.Room_ID=0;
		this.Room_Status = "";
		this.Room_Rate = 0;
		this.CheckIn = "";
		this.CheckOut = "";
		this.Service_Price = 0;
		this.Drink_Amount = 0;
		this.Item_Amount = 0;
		this.Credit_Number="";
	}
	
	
	public BillingLibs2(int booking_ID, String name, int room_ID,String room_Status, int room_Rate, String checkIn,
			String checkOut, int service_Price, int drink_Amount, int item_Amount,String credit_Number) {
		
		
		this.Booking_ID=booking_ID;
		this.Name = name;
		this.Room_ID=room_ID;
		this.Room_Status = room_Status;
		this.Room_Rate = room_Rate;
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		this.Service_Price = service_Price;
		this.Drink_Amount = drink_Amount;
		this.Item_Amount = item_Amount;
		this.Credit_Number=credit_Number;
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


	public int getRoom_ID() {
		return Room_ID;
	}


	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}


	public String getRoom_Status() {
		return Room_Status;
	}


	public void setRoom_Status(String room_Status) {
		Room_Status = room_Status;
	}


	public int getRoom_Rate() {
		return Room_Rate;
	}


	public void setRoom_Rate(int room_Rate) {
		Room_Rate = room_Rate;
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


	public int getService_Price() {
		return Service_Price;
	}


	public void setService_Price(int service_Price) {
		Service_Price = service_Price;
	}


	public int getDrink_Amount() {
		return Drink_Amount;
	}


	public void setDrink_Amount(int drink_Amount) {
		Drink_Amount = drink_Amount;
	}


	public int getItem_Amount() {
		return Item_Amount;
	}


	public void setItem_Amount(int item_Amount) {
		Item_Amount = item_Amount;
	}


	public String getCredit_Number() {
		return Credit_Number;
	}


	public void setCredit_Number(String credit_Number) {
		Credit_Number = credit_Number;
	}


	@Override
	public String toString() {
		return "BillingLibs2 [Booking_ID=" + Booking_ID + ", Name=" + Name + ", Room_ID=" + Room_ID + ", Room_Status="
				+ Room_Status + ", Room_Rate=" + Room_Rate + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut
				+ ", Service_Price=" + Service_Price + ", Drink_Amount=" + Drink_Amount + ", Item_Amount=" + Item_Amount
				+ ", Credit_Number=" + Credit_Number + "]";
	}


	


	
	

}
