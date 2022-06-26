package Libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCEmployees {
	
	public boolean insert(EmployeesLibs employees) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, employees.getID());
			pstat.setString(2, employees.getName());
			pstat.setInt(3, employees.getAge());
			pstat.setLong(4, employees.getMobile());
			pstat.setString(5, employees.getEmail());
			pstat.setString(6, employees.getAddress());
			pstat.setLong(7, employees.getSalary());
			pstat.setString(8, employees.getDepartment());
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
		ArrayList select=new ArrayList();
		String sql="SELECT * FROM employees";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				EmployeesLibs employees=new EmployeesLibs(rs.getInt("ID"),
						rs.getString("Name"),
						rs.getInt("Age"),
						rs.getLong("Mobile"),
						rs.getString("Email"),
						rs.getString("Address"),
						rs.getLong("Salary"),
						rs.getString("Department"));
				select.add(employees);
			}
			
		}
		catch (Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return select;
		
		
	}
	public EmployeesLibs search(int ID) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM employees WHERE ID=?";
		EmployeesLibs employees=new EmployeesLibs();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, ID);
			rs=pstat.executeQuery();
			while(rs.next()) {
				
				employees.setID(rs.getInt("ID"));
				employees.setName(rs.getString("Name"));
				employees.setAge(rs.getInt("Age"));
				employees.setMobile(rs.getLong("Mobile"));
				employees.setEmail(rs.getString("Email"));
				employees.setAddress(rs.getString("Address"));
				employees.setSalary(rs.getLong("Salary"));
				employees.setDepartment(rs.getString("Department"));
				
				
			}
		}
		catch (Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return employees;
		
	}
	public boolean delete(int ID) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql ="DELETE FROM employees WHERE ID=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setInt(1, ID);
			pstat.executeUpdate();
			
			conn.close();
			result=true;
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		return result;

	}
	
	public boolean update(EmployeesLibs employees) {
		
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql ="UPDATE employees SET Name=?, Age=?,Mobile=?,Email=?,Address=?,Salary=?,"
				+ "Department=? WHERE ID=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database","root","");
			
			pstat=conn.prepareStatement(sql);
			
			
			pstat.setString(1, employees.getName());
			pstat.setInt(2, employees.getAge());
			pstat.setLong(3, employees.getMobile());
			pstat.setString(4, employees.getEmail());
			pstat.setString(5, employees.getAddress());
			pstat.setLong(6, employees.getSalary());
			pstat.setString(7,employees.getDepartment());
			pstat.setInt(8, employees.getID());
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

}
