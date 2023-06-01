package com.registrationapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteRegistration() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");

	DAOService service = new DAOServiceImpl();
	service.connectDB();
	service.deleteByEmail(email);
	
	ResultSet result = service.getAllRegistration();
	request.setAttribute("res", result);
	
	RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/get_allRegistration.jsp");
	rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
