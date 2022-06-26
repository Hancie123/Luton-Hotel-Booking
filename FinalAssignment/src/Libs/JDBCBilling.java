package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JDBCBilling extends Database{
	
	SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
	Date date=new Date();
	String currentDate=dateformate.format(date);
	
	public ArrayList view_all1() {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BillingLibs2>Billing=new ArrayList();
		String sql=" select booking.Booking_ID, customers.Name, customers.Credit_Number, "
				+ "rooms.Room_ID, booking.Booking_Status, rooms.rate, booking.CheckIn, "
				+ "booking.Checkout, sum(case when services.service_Price is null then 0 "
				+ "else services.service_Price end) as service_Price, sum(case when "
				+ "bar.drink_Amount is null then 0 else bar.drink_Amount end) as drink_Amount,"
				+ "sum(case when restaurant.Item_Amount is null then 0 else restaurant.Item_Amount"
				+ " end) as Item_Amount from booking left join customers on booking.Customer_ID = "
				+ "customers.Customer_ID left join rooms on booking.Room_ID = rooms.Room_ID left "
				+ "join services on services.Booking_ID = booking.Booking_ID left join restaurant "
				+ "on restaurant.Booking_ID = booking.Booking_ID left join bar on bar.Booking_ID "
				+ "= booking.Booking_ID where booking.Booking_Status='Active' and "
				+ "customers.Role='Customer'"
				+ " group by booking.Booking_ID, customers.Name, "
				+ "customers.Credit_Number, rooms.Room_ID, booking.Booking_Status, "
				+ "rooms.rate,booking.CheckIn,booking.CheckOut;";
		
		
		
		
		try {
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BillingLibs2 billing=new BillingLibs2(
						rs.getInt("Booking_ID"),
						rs.getString("Name"),
						rs.getInt("Room_ID"),
						rs.getString("Booking_Status"),
						rs.getInt("rate"),
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
						rs.getInt("Service_Price"),
						rs.getInt("drink_Amount"),
						rs.getInt("Item_Amount"),
						rs.getString("Credit_Number"));
				
				Billing.add(billing);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return Billing;
		
	}
	
	public ArrayList view_all2() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BillingLibs2>Billing=new ArrayList();
		String sql=" select booking.Booking_ID, customers.Name, customers.Credit_Number, "
				+ "rooms.Room_ID, booking.Booking_Status, rooms.rate, booking.CheckIn, "
				+ "booking.Checkout,  sum(case when services.service_Price is null then 0 "
				+ "else services.service_Price end) as service_Price, sum(case when "
				+ "bar.drink_Amount is null then 0 else bar.drink_Amount end) as drink_Amount,"
				+ "sum(case when restaurant.Item_Amount is null then 0 else restaurant.Item_Amount"
				+ " end) as Item_Amount from booking left join customers on booking.Customer_ID = "
				+ "customers.Customer_ID left join rooms on booking.Room_ID = rooms.Room_ID left "
				+ "join services on services.Booking_ID = booking.Booking_ID left join restaurant"
				+ " on restaurant.Booking_ID = booking.Booking_ID left join bar on "
				+ "bar.Booking_ID = booking.Booking_ID where booking.Booking_Status='Active' "
				+ "and customers.Role='Corp Client' "
				+ "group by booking.Booking_ID, customers.Name, customers.Credit_Number, rooms.Room_ID, "
				+ "booking.Booking_Status, rooms.rate,booking.CheckIn,booking.CheckOut;";
		
		
		//where Registration_ID=? //currentUser.getRegistration_ID();
		
		try {
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BillingLibs2 billing=new BillingLibs2(
						rs.getInt("Booking_ID"),
						rs.getString("Name"),
						rs.getInt("Room_ID"),
						rs.getString("Booking_Status"),
						rs.getInt("rate"),
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
						rs.getInt("Service_Price"),
						rs.getInt("drink_Amount"),
						rs.getInt("Item_Amount"),
						rs.getString("Credit_Number"));
				
				Billing.add(billing);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return Billing;
		
	}
	
	public boolean insert (BillingLibs3 billing) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO `billing`(`Billing_ID`, `Booking_ID`, `Name`, `VAT`, "
				+ "`Service_Charge`, `Room_Price`, `Service_Price`, `Restaurant_Price`, "
				+ "`Bar_Price`, `Total_Bill`, `Biiling_Status`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, billing.getBilling_ID());
			pstat.setInt(2, billing.getBooking_ID());
			pstat.setString(3, billing.getName());
			pstat.setDouble(4, billing.getVAT());
			pstat.setDouble(5, billing.getService_Charge());
			pstat.setDouble(6, billing.getRoom_Price());
			pstat.setInt(7, billing.getService_Price());
			pstat.setInt(8, billing.getRestaurant_Price());
			pstat.setInt(9, billing.getBar_Price());
			pstat.setDouble(10, billing.getTotal_Bill());
			pstat.setString(11, billing.getBilling_Status());
			
			pstat.executeUpdate();
			
			conn.close();
			pstat.close();
			result=true;
			
			
		}
		
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
	}
	
public ArrayList select_all() {
		
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList select2=new ArrayList();
		String sql="SELECT * FROM billing";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BillingLibs3 billing=new BillingLibs3(rs.getInt("Billing_ID"),
						rs.getInt("Booking_ID"),
						rs.getString("Name"),
						rs.getInt("VAT"),
						rs.getInt("Service_Charge"),
						rs.getInt("Room_Price"),
						rs.getInt("Service_Price"),
						rs.getInt("Restaurant_Price"),
						rs.getInt("Bar_Price"),
						rs.getDouble("Total_Bill"),
						rs.getString("Biiling_Status")
						
						
						);
						
				
				
				select2.add(billing);
			}
			
		}
		catch (Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return select2;
		
		
	}

public boolean insertCorporate (BillingLibs billing) {
	
	Connection conn;
	PreparedStatement pstat;
	boolean result=false;
	String sql="INSERT INTO billing VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
	try {
		
		conn=connect();
		
		pstat=conn.prepareStatement(sql);
		
		pstat.setInt(1, billing.getBilling_ID());
		pstat.setInt(2, billing.getBooking_ID());
		pstat.setString(3, billing.getName());
		pstat.setDouble(4, billing.getVAT());
		pstat.setDouble(5, billing.getService_Charge());
		pstat.setDouble(6, billing.getRoom_Price());
		pstat.setInt(7, billing.getService_Price());
		pstat.setInt(8, billing.getRestaurant_Price());
		pstat.setInt(9, billing.getBar_Price());
		pstat.setDouble(10, billing.getTotal_Bill());
		pstat.setString(11, billing.getBilling_Status());
		pstat.setLong(12, billing.getDiscount());
		
		pstat.executeUpdate();
		
		conn.close();
		pstat.close();
		result=true;
		
		
	}
	
	catch(Exception ex) {
		System.out.println("Error"+ex.getMessage());
	}
	return result;
}
	
public boolean update(BookingLibs booking) {
	
	Connection conn;
	PreparedStatement pstat;
	boolean result5=false;
	String sql="UPDATE booking SET Booking_Status=? WHERE Booking_ID=?";
	try {
		
		conn=connect();
		
		pstat=conn.prepareStatement(sql);
		
		pstat.setString(1, booking.getBooking_Status());		
		pstat.setInt(2, booking.getBooking_ID());
		
		
		pstat.executeUpdate();
		conn.close();
		pstat.close();
		result5=true;
		
	}
	catch(Exception ex) {
		System.out.println("Error"+ex.getMessage());
	}
	return result5;
}

}
