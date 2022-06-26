package Libs;

public class FoodLibs {

	int Food_ID;
	int Registration_ID;
	int Room_ID;
	long Total_Amount;

	public FoodLibs() {

		this.Food_ID = 0;
		this.Registration_ID = 0;
		this.Room_ID = 0;
		this.Total_Amount = 0;
	}

	public FoodLibs(int food_ID, int registration_ID, int room_ID, long total_Amount) {

		this.Food_ID = food_ID;
		this.Registration_ID = registration_ID;
		this.Room_ID = room_ID;
		this.Total_Amount = total_Amount;
	}

	public int getFood_ID() {
		return Food_ID;
	}

	public void setFood_ID(int food_ID) {
		Food_ID = food_ID;
	}

	public int getRegistration_ID() {
		return Registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		Registration_ID = registration_ID;
	}

	public int getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(int room_ID) {
		Room_ID = room_ID;
	}

	public long getTotal_Amount() {
		return Total_Amount;
	}

	public void setTotal_Amount(long total_Amount) {
		Total_Amount = total_Amount;
	}

	@Override
	public String toString() {
		return "FoodLibs [Food_ID=" + Food_ID + ", Registration_ID=" + Registration_ID + ", Room_ID=" + Room_ID
				+ ", Total_Amount=" + Total_Amount + "]";
	}

}
