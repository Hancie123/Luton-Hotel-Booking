package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CheckInCustomerJDBC extends Database {
	
	
	
	public ArrayList view_all1() {
		
		SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String currentDate=dateformate.format(date);
		
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibs3>a1=new ArrayList<BookingLibs3>();
		String sql="select customers.Customer_ID, customers.Name, booking.Booking_ID, "
				+ "booking.CheckIn, booking.CheckOut, booking.Room_ID,booking.Booking_Type, "
				+ "booking.Booking_Status from booking left join customers on "
				+ "booking.Customer_ID = customers.Customer_ID WHERE CheckIn='"+currentDate+"' ;";
		
		
		try {
			conn=connect();
			
			pstat=conn.prepareStatement(sql);
			
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibs3 booking=new BookingLibs3(rs.getInt("Customer_ID"),
						rs.getString("Name"),
						rs.getInt("Booking_ID"),
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
						rs.getInt("Room_ID"),
						rs.getString("Booking_Type"),
						rs.getString("Booking_Status")
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}

}
