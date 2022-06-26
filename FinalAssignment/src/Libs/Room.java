package Libs;

public class Room {
	int id;
	String type;
	double rate;
	String status;
	
	
	
    public Room() {
		
		this.id = 0;
		this.type = "";
		this.rate = 0;
		this.status = "";
		
	}
	
	public Room(int id, String type, double rate, String status) {
		
		this.id = id;
		this.type = type;
		this.rate = rate;
		this.status = status;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", type=" + type + ", rate=" + rate + ", status=" + status + "]";
	}

	

	
	
	
	
	
	
}
