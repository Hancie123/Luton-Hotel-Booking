package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCRestaurant  extends Database{
	
public boolean insert (RestaurantLibs restaurant) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO restaurant VALUES (?,?,?)";
		
		try {
			
			conn=connect();
			
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, restaurant.getRestaurant_ID());
			pstat.setLong(2, restaurant.getItem_Amount());
			pstat.setInt(3, restaurant.getBooking_ID());
			
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			
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
	String sql="SELECT * FROM restaurant";
	
	try {
		conn=connect();
		
		pstat=conn.prepareStatement(sql);
		
		rs=pstat.executeQuery();
		
		while(rs.next()) {
			RestaurantLibs billing=new RestaurantLibs(rs.getInt("Restaurant_ID"),
					rs.getLong("item_Amount"),
					rs.getInt("Booking_ID")	);
					
			
			
			select2.add(billing);
		}
		
	}
	catch (Exception ex) {
		
		System.out.println("Error"+ex.getMessage());
	}
	return select2;
	
	
}

}
