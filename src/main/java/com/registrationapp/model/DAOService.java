package com.registrationapp.model;

import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public interface DAOService {

	public void connectDB();
	public boolean verifyCredential(String email, String password);
	public void saveRegistration(String name, String city, String email, String mobile);
	public ResultSet getAllRegistration();
	public void deleteByEmail(String email);
	public void updateRegistration(String email, String mobile);
	
	
	
	
}
