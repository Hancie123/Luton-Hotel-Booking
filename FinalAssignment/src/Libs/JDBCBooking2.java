package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCBooking2 extends Database {
	
	public ArrayList staff() {
		Connection conn;
		ResultSet rs;
		String sql="SELECT Customer_ID, Name, Booking_ID, Booking_Status "
				+ "FROM booking INNER JOIN customers USING (Customer_ID) "
				+ "WHERE Booking_Status='Active' ORDER BY Booking_ID;";
		
		ArrayList staff=new ArrayList();
		
		try {
			conn=connect();
			
			PreparedStatement pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				BookingLibs4 bookingid=new BookingLibs4(rs.getInt("Customer_ID"),
						rs.getString("Name"),
						rs.getInt("Booking_ID"),
						rs.getString("Booking_Status"));
				staff.add(bookingid);
			}
			
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		
		
		return staff;
	}
	
 public boolean update(BookingLibs booking) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE booking SET Booking_Status=? WHERE Booking_ID=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			
			pstat.setString(1, booking.getBooking_Status());		
			pstat.setInt(2, booking.getBooking_ID());
			
			
			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result1=true;
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result1;
	}
 
 public ArrayList bookinghistory() {
		Connection conn;
		ResultSet rs;
		String sql="SELECT Customer_ID, Name, Booking_ID, CheckIn, CheckOut,Booking_Type, "
				+ "Booking_Status FROM booking INNER JOIN customers USING (Customer_ID) "
				+ "WHERE Booking_Status='Inactive' ORDER BY Customer_ID;";
		
		ArrayList bookinghistory=new ArrayList();
		
		try {
			conn=connect();
			
			PreparedStatement pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				BookingHistoryLibs bookingid=new BookingHistoryLibs(rs.getInt("Customer_ID"),
						rs.getString("Name"),
						rs.getInt("Booking_ID"),
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
						rs.getString("Booking_Type"),
						rs.getString("Booking_Status")
						
						
						
						);
				bookinghistory.add(bookingid);
			}
			
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		
		
		return bookinghistory;
	}

 public boolean updatebooking(BookingLibs booking) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE booking SET CheckIn=?, CheckOut=?,Booking_Type=? WHERE Booking_ID=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, booking.getCheckIn());
			pstat.setString(2, booking.getCheckOut());
			pstat.setString(3, booking.getBooking_Type());		
			pstat.setInt(4, booking.getBooking_ID());
			
			
			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result1=true;
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result1;
	}

}
