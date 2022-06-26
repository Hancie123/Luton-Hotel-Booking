package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCServices {
	
	public boolean insert(ServicesLibs services) {
		
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO services VALUES (?,?,?,?)";
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, services.getServices_ID());
			pstat.setString(2, services.getServices_Type());
			pstat.setDouble(3, services.getServices_Price());
			pstat.setInt(4, services.getBooking_ID());
			
			pstat.executeUpdate();
			
			result=true;
			pstat.close();
			conn.close();
			
			
			
			
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
		String sql="SELECT * FROM services";
		ArrayList select=new ArrayList();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				ServicesLibs services=new ServicesLibs(
						rs.getInt("Service_ID"),						
						rs.getString("Service_Type"),
						rs.getInt("Service_Price"),
						rs.getInt("Booking_ID")
						);
				
				select.add(services);
			}
			
			
			
		}
		
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
			
		}
		return select;
	}
	
	public ArrayList select_all1() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM services";
		ArrayList select=new ArrayList();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				ServicesLibs services=new ServicesLibs(
						rs.getInt("Service_ID"),						
						rs.getString("Service_Type"),
						rs.getInt("Service_Price"),
						rs.getInt("Booking_ID")
						);
				
				select.add(services);
			}
			
			
			
		}
		
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
			
		}
		return select;
	}


}
