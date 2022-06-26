package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReceptionPasswordChangeJDBC {
	
public boolean update(CustomerLibs2 customer) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE registration SET Username=?,Password=? WHERE Registration_ID=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, customer.getUsername());
			pstat.setString(2, customer.getPassword());
			pstat.setInt(3, customer.getRegistration_ID());
			
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
