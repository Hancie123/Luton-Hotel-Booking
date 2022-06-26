package Libs;

public class BarLibs {

	int Bar_ID;
	long Drink_Amount;
	int Booking_ID;

	public BarLibs() {

		this.Bar_ID = 0;
		this.Drink_Amount = 0;
		this.Booking_ID = 0;
	}

	public BarLibs(int bar_ID, long drink_Amount, int booking_ID) {

		this.Bar_ID = bar_ID;
		this.Drink_Amount = drink_Amount;
		this.Booking_ID = booking_ID;
	}

	public int getBar_ID() {
		return Bar_ID;
	}

	public void setBar_ID(int bar_ID) {
		Bar_ID = bar_ID;
	}

	public long getDrink_Amount() {
		return Drink_Amount;
	}

	public void setDrink_Amount(long drink_Amount) {
		Drink_Amount = drink_Amount;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	@Override
	public String toString() {
		return "BarLibs [Bar_ID=" + Bar_ID + ", Drink_Amount=" + Drink_Amount + ", Booking_ID=" + Booking_ID + "]";
	}

}
