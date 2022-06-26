package Libs;

public class RestaurantLibs {

	int Restaurant_ID;
	long Item_Amount;
	int Booking_ID;

	public RestaurantLibs() {

		this.Restaurant_ID = 0;
		this.Item_Amount = 0;
		this.Booking_ID = 0;
	}

	public RestaurantLibs(int restaurant_ID, long item_Amount, int booking_ID) {

		this.Restaurant_ID = restaurant_ID;
		this.Item_Amount = item_Amount;
		this.Booking_ID = booking_ID;
	}

	public int getRestaurant_ID() {
		return Restaurant_ID;
	}

	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}

	public long getItem_Amount() {
		return Item_Amount;
	}

	public void setItem_Amount(long item_Amount) {
		Item_Amount = item_Amount;
	}

	public int getBooking_ID() {
		return Booking_ID;
	}

	public void setBooking_ID(int booking_ID) {
		Booking_ID = booking_ID;
	}

	@Override
	public String toString() {
		return "RestaurantLibs [Restaurant_ID=" + Restaurant_ID + ", Item_Amount=" + Item_Amount + ", Booking_ID="
				+ Booking_ID + "]";
	}

}
