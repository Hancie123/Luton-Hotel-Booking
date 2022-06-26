package Libs;

public class Global {
	public static final String ROOM_TYPES[]= {"Single","Double","Twin"};	
	public static final double ROOM_PRICE[]= {1000,2000,3000};
	public static final String ROOM_STATUS[]= {"Available","Booked"};
	
	
	public static CustomerLibs currentUser;
	
	
	public static CustomerLibs2 registrationUser;
	
	
	public static Room currentRoom;
	
	public static final String SERVICE_TYPES[]= {"Laundary","Swimming","Dancing","Singing","Bar"};	
	public static final long SERVICE_PRICE[]= {500,800,2000,1500,3000};
	
	
	public static BillingLibs3 currentBilling;
	public static BillingLibs currentBilling2;
}
