package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCFoods {
	
	
	public boolean insert (FoodLibs food) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO foods VALUES (?,?,?,?)";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, food.getFood_ID());
			pstat.setLong(2, food.getTotal_Amount());
			pstat.setInt(3, food.getRoom_ID());
			pstat.setInt(4, food.getRegistration_ID());
			
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

}
