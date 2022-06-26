package Libs;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Libs.BookingLibs;
import Libs.BookingLibs5;

public class JDBCBooking {
	
	
	
	
	public boolean insert (BookingLibs booking) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO `booking`"
				+ "(`Booking_ID`, `Customer_ID`, `CheckIn`, "
				+ "`CheckOut`, `Booking_Type`,`Booking_Status`) "
				+ " VALUES (?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, booking.getBooking_ID());
			pstat.setInt(2, booking.getCustomer_ID());
			pstat.setString(3, booking.getCheckIn());
			pstat.setString(4, booking.getCheckOut());
			pstat.setString(5, booking.getBooking_Type());
			pstat.setString(6, booking.getBooking_Status());
			
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
	
	
	public ArrayList view_all1() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibs2>a1=new ArrayList<BookingLibs2>();
		String sql="SELECT Customer_ID, Name, Booking_ID, CheckIn, CheckOut,Booking_Type, "
				+ "Booking_Status  FROM booking INNER JOIN customers USING (Customer_ID) "
				+ "WHERE Customer_ID=? AND Booking_Status='Requested' "
				+ "ORDER BY Booking_ID;";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, Global.currentUser.getCustomer_ID());
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibs2 booking=new BookingLibs2(rs.getInt("Customer_ID"),
						rs.getString("Name"),
						rs.getInt("Booking_ID"),
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
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
	
	public ArrayList ReceptionViewAllCustomer() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibs3>a5=new ArrayList();
		String sql="SELECT Customer_ID, Name, Booking_ID, CheckIn, CheckOut,Room_ID, Booking_Type, "
				+ "Booking_Status  FROM booking INNER JOIN customers USING (Customer_ID) WHERE Booking_Status='Requested' ORDER BY Booking_ID;";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
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
				
				a5.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a5;
		
	}
	
	public ArrayList CheckIn() {
		
		SimpleDateFormat dateformate=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String currentDate=dateformate.format(date);
		
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BookingLibs5> check=new ArrayList();
		String sql="SELECT Customer_ID, Name, Credit_Number,Booking_ID, CheckIn, CheckOut,Room_ID,Booking_Type, "
				+ "Booking_Status  FROM booking INNER JOIN customers USING (Customer_ID) WHERE CheckIn='"+currentDate+"' AND Booking_Status='Booked'  ORDER BY Booking_ID;";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				BookingLibs5 booking=new BookingLibs5(rs.getInt("Customer_ID"),
						rs.getString("Name"),
						rs.getString("Credit_Number"),
						rs.getInt("Booking_ID"),						
						rs.getString("CheckIn"),
						rs.getString("CheckOut"),
						rs.getInt("Room_ID"),
						rs.getString("Booking_Type"),
						rs.getString("Booking_Status")
						);
				
				check.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return check;
		
	}
	
	
	
	public ArrayList customerBookingViewAll() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList CustomerBookingStatus=new ArrayList();
		String sql="select customers.Customer_ID, customers.Name, booking.Booking_ID, "
				+ "booking.CheckIn, booking.CheckOut, booking.Room_ID,booking.Booking_Type, "
				+ "booking.Booking_Status from booking left join customers on "
				+ "booking.Customer_ID = customers.Customer_ID WHERE customers.Customer_ID=?;";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, Global.currentUser.getCustomer_ID());
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
				
				CustomerBookingStatus.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return CustomerBookingStatus;
		
	}
	
public boolean update(BookingLibs booking) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE booking SET  CheckIn=?, "
				+ "CheckOut=?, Room_ID=?, Booking_Status=? WHERE Booking_ID=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, booking.getCheckIn());
			pstat.setString(2, booking.getCheckOut());
			pstat.setInt(3, booking.getRoom_ID());
			pstat.setString(4, booking.getBooking_Status());		
			pstat.setInt(5, booking.getBooking_ID());
			
			
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


public boolean delete(int ID) {
	Connection conn;
	PreparedStatement pstat;
	boolean result4=false;
	String sql="DELETE FROM booking WHERE Booking_ID=?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Connect with database server
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
		
		pstat=conn.prepareStatement(sql);
		pstat.setInt(1,ID);
		pstat.executeUpdate();
		
		
		conn.close();
		result4 = true;
		
	}
	catch(Exception ex) {
		System.out.println("Error"+ex.getMessage());
	}
	return result4;
	
	
}
}
