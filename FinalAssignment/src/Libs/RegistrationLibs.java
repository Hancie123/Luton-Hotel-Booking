package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RegistrationLibs{
	
	
		public ArrayList select_all() {
			Connection conn;
			PreparedStatement pstat;
			ResultSet rs;
			String sql ="SELECT * FROM registration WHERE Role=customers";
			ArrayList search=new ArrayList();
			
			
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				
				RegistrationLibs2 reg=new RegistrationLibs2(rs.getInt("ID"),
						rs.getString("Title"),
						rs.getString("Name"),
						rs.getString("Address"),
						rs.getInt("Mobile"),
						rs.getString("Email"),
						rs.getString("Username"),
						rs.getString("Password"),
						rs.getString("Role"));
				        search.add(reg);
				
			}
		         conn.close();

		}
		catch(Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return search;
	
	}

}
