package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCCorporateCustomer {
	
	public boolean insert(CustomerLibs customer) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");

			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, customer.getCustomer_ID());
			pstat.setString(2, customer.getTitle());
			pstat.setString(3, customer.getName());
			pstat.setString(4, customer.getGender());
			pstat.setString(5, customer.getDOB());
			pstat.setString(6, customer.getMobile());
			pstat.setString(7, customer.getEmail());
			pstat.setString(8, customer.getAddress());
			pstat.setString(9, customer.getUsername());
			pstat.setString(10, customer.getPassword());
			pstat.setString(11, customer.getCredit_Number());
			pstat.setString(12, customer.getRole());
			

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	public ArrayList select_all() {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customers WHERE Role='Corp Client'";
		ArrayList<CustomerLibs>select = new ArrayList<CustomerLibs>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();
			while (rs.next()) {

				CustomerLibs customer = new CustomerLibs(rs.getInt("Customer_ID"),
						rs.getString("Title"), 
						rs.getString("Name"),
						rs.getString("Gender"), 
						rs.getString("DOB"), 
						rs.getString("Mobile"), 
						rs.getString("Email"),
						rs.getString("Address"),
						rs.getString("Username"), 
						rs.getString("Password"),
						rs.getString("Credit_Number"),
						rs.getString("Role"));

				select.add(customer);
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return select;

	}

	public CustomerLibs search(int ID) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql = "SELECT * FROM customers WHERE Customer_ID=?";
		CustomerLibs search = new CustomerLibs();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");

			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, ID);

			rs = pstat.executeQuery();
			while (rs.next()) {

				search.setCustomer_ID(rs.getInt("Customer_ID"));
				search.setTitle(rs.getString("Title"));
				search.setName(rs.getString("Name"));
				search.setGender(rs.getString("Gender"));
				search.setDOB(rs.getString("DOB"));
				search.setMobile(rs.getString("Mobile"));
				search.setEmail(rs.getString("Email"));
				search.setAddress(rs.getString("Address"));
				search.setUsername(rs.getString("Username"));
				search.setPassword(rs.getString("Password"));				
				search.setCredit_Number(rs.getString("Credit_Number"));
				search.setRole(rs.getString("Role"));

			}

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return search;
	}
	
	public boolean update(CustomerLibs customer) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result1=false;
		String sql="UPDATE customers SET Title=?, Name=?, Gender=?, DOB=?, Mobile=?, "
				+ "Email=?,Address=?, Username=?, Password=?"
				+ ",Credit_Number=?, Role=? WHERE Customer_ID=?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, customer.getTitle());
			pstat.setString(2, customer.getName());
			pstat.setString(3, customer.getGender());
			pstat.setString(4, customer.getDOB());
			pstat.setString(5, customer.getMobile());
			pstat.setString(6, customer.getEmail());
			pstat.setString(7, customer.getAddress());
			pstat.setString(8, customer.getUsername());
			pstat.setString(9, customer.getPassword());
			pstat.setString(10, customer.getCredit_Number());
			pstat.setString(11, customer.getRole());
			pstat.setLong(12, customer.getCustomer_ID());
			
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
		String sql="DELETE FROM customers WHERE Customer_ID=?";
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
