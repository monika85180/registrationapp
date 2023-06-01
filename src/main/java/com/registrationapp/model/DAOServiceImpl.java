package com.registrationapp.model;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class DAOServiceImpl implements DAOService{

	private Connection con;
	private Statement stmnt;
	
	@Override
	public boolean verifyCredential(String email, String password) {
		
		try {
			ResultSet result = stmnt.executeQuery("select * from login where username='"+email+"' and password='"+password+"'");
			return result.next();
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return false;
	}

	@Override
	public void connectDB() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp_2","root","test");
			stmnt = con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			
			stmnt.executeUpdate("INSERT INTO registration (name, city, email, mobile) VALUES ('"+name+"', '"+city+"', '"+email+"', '"+mobile+"')");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet getAllRegistration() {

		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"'");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("UPDATE registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
