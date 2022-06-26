package Trial;



import java.sql.*;

import com.mysql.cj.xdevapi.Statement;

		public class sqlConnectionDemo{ 
			
		public static Connection getConnection() {
			Connection con=null;
			try {
				
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/Company1","root","root");
		} 
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			
		}
			return con;
		}  

		}


