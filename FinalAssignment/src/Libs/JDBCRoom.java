package Libs;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Libs.Room;


public class JDBCRoom extends Database {
	
	public boolean update (Room room) {
		Connection conn;
		PreparedStatement pstat;
		String sql="UPDATE rooms SET type=?,rate=?, room_status=? WHERE Room_ID=?";
		boolean result=false;
		
		try {
			conn=connect();
			pstat=conn.prepareStatement(sql);
			pstat.setString(1, room.getType());
			pstat.setDouble(2, room.getRate());
			pstat.setString(3, room.getStatus());
			pstat.setInt(4, room.getId());
			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result=true;
		}
		catch (Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return result;
		
	}
	
	public Room search (int rid) {
		
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM rooms WHERE Room_ID=?";
		Room room=new Room();
		
		try {
			conn=connect();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, rid);
			rs=pstat.executeQuery();
			while(rs.next())
			{
				
				room.setId(rs.getInt("Room_ID"));
				room.setType(rs.getString("type"));
				room.setRate(rs.getDouble("rate"));
				room.setStatus(rs.getString("rooms_status"));
				
			}
			
			
		}
		catch (Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		return room;
		
	}
	
	public boolean insert (Room room) {
		Connection conn;
		PreparedStatement pstat;
		boolean result=false;
		String sql="INSERT INTO rooms VALUES (?,?,?,?)";
		
		try {
			
			//insert
			conn=connect();
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, room.getId());
			pstat.setString(2, room.getType());
			pstat.setDouble(3, room.getRate());
			pstat.setString(4,room.getStatus());
			
			pstat.executeUpdate(); //insert, delete, update
			
			pstat.close();
			conn.close();
			result=true;
			
		}
		catch (Exception ex) {
			
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		return result;
		
		
		
		
	}
	public ArrayList getAvailableRooms() {
		ResultSet rs;
		String sql="SELECT  * FROM rooms WHERE rooms_status='Available'";
		ArrayList rooms=new ArrayList();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			
			PreparedStatement pstat=conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()) {
				Room room=new Room(rs.getInt("Room_ID"),
						rs.getString("type"),
						rs.getInt("rate"),
						rs.getString("rooms_status"));
				rooms.add(room);
			}
			
			
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
		
		
		return rooms;
	}
	
	
public ArrayList select_all() {
		
		String sql="SELECT  * FROM rooms";
		ArrayList room=new ArrayList();

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			
			ResultSet rs=pstat.executeQuery();
		
			while(rs.next()) {
				
			Room tmp= new Room(
		    rs.getInt("Room_ID"),
			rs.getString("type"),
			rs.getDouble("rate"),
			rs.getString("rooms_status"));				
			room.add(tmp);
			}
			
			conn.close();
			
		} catch (Exception ex) {

			System.out.println("Error" + ex.getMessage());
		}
		return room;
	}
  
public boolean update1 (Room room) {
	
	
	PreparedStatement pstat;
	boolean result1=false;
	String sql="UPDATE rooms SET rooms_status=? WHERE Room_ID=?";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_database", "root","");			
		pstat=conn.prepareStatement(sql);			
		pstat.setString(1, room.getStatus());
		pstat.setInt(2, room.getId());
		
		pstat.executeUpdate();			
		pstat.close();
		conn.close();
		result1=true;			
	}
	
	
	
	
	catch (Exception ex){
		System.out.println("Error"+ex.getMessage());
		
		
	}

	return result1;
	
}

}
