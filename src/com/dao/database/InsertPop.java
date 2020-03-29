package com.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.model.Message;


public class InsertPop {
	
	String DBusername = "chatroom";
	String DBpassword = "pass123";
	String DBURL = "jdbc:postgresql://localhost:5432/msgdb";
	
	// Inserts data to DB
	public Boolean Insert(String message, String user) {
		
		if(message!=null) {
		System.out.println("Message : "+message);
		System.out.println("User : "+user);
		
		try{
			Connection con = DriverManager.getConnection(DBURL, DBusername, DBpassword);
			Statement st = con.createStatement();
			String statement = "Insert into msg values('"+user+"','"+message+"');";
			st.executeUpdate(statement);
			return true;
		}
		catch (Exception e) {
			System.out.println("Insert Message failed");
			e.printStackTrace();
			return false;
		}
		}
		else {
			System.out.println("Message Field NuLL");
			return true;
		}
		
	}
	
	
	// Retrieves Data from DB
	public ArrayList<Message> getData(){
		
		ArrayList<Message> mlist = new ArrayList<Message>();
		
		try(Connection con = DriverManager.getConnection(DBURL, DBusername, DBpassword)){
			
			Statement st = con.createStatement();
			String statement = "select * from msg;";
			ResultSet rs = st.executeQuery(statement);
			while(rs.next()) {
				Message um = new Message();  
				um.setUsername(rs.getString("usr"));
				um.setSmessage(rs.getString("message"));
				mlist.add(um);
			}
		}
		catch (Exception e) {
			System.out.println("Retrieve Message failed");
			e.printStackTrace();
			
		}
		
		return mlist;
		
	}
	
	// Resset data from DB
		public Boolean ResetData() {
			
			try{
				Connection con = DriverManager.getConnection(DBURL, DBusername, DBpassword);
				Statement st = con.createStatement();
				String statement = "delete from msg;";
				st.executeUpdate(statement);
				return true;
			}
			catch (Exception e) {
				System.out.println("Delete failed");
				e.printStackTrace();
				return false;
			}
			
		}
	
	

}
