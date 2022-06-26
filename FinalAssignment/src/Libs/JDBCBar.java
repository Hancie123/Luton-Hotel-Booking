package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCBar extends Database {
	
public boolean insert (BarLibs bar) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO bar VALUES (?,?,?)";
		
		try {
			
			conn=connect();
			
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, bar.getBar_ID());
			pstat.setLong(2, bar.getDrink_Amount());
			pstat.setInt(3, bar.getBooking_ID());
			
			
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
