package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginLibs {
	
	final String Driver="com.mysql.cj.jdbc.Driver";		
	final String DBNAME="hotel_database";
	final String HOST="localhost";
	final int PORT =3306;
	final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME;
	final String USER ="root";
	final String PASSWORD="";
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			Class.forName(Driver);   //loading driver
			conn=DriverManager.getConnection(URL,USER, PASSWORD);
		
		}
		
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return conn;
		
	}
	
	public CustomerLibs login(CustomerLibs user) {
		String sql="SELECT * FROM customers WHERE Username=? AND Password=?";
		try {
			Connection conn=connect();
			if(conn!=null) {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1,user.getUsername());
			pstat.setString(2, user.getPassword());
			ResultSet rs=pstat.executeQuery();
			
			while(rs.next()) {
				
				user.setCustomer_ID(rs.getInt("Customer_ID"));
				user.setTitle(rs.getString("Title"));
				user.setName(rs.getString("Name"));
				user.setGender(rs.getString("Gender"));
				user.setDOB(rs.getString("DOB"));
				user.setAddress(rs.getString("Address"));
				user.setUsername(rs.getString("Username"));
				user.setMobile(rs.getString("Mobile"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Role"));
			}
			}
			
		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return user;
	}

}
