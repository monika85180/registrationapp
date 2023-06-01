package com.registrationapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;


@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		// Creating object of Model layer via using class upcasting
		DAOService service = new DAOServiceImpl();
		service.connectDB();  							// first connect with DB		
		boolean status =service.verifyCredential(email, pass); 			// call verifyCredential method which retrive the data from table and give us "result"
		if(status==true) {
			HttpSession session = request.getSession(true);    // creating session variable after login and setting the value email
			session.setMaxInactiveInterval(10);                 // setting the time for that non working stage it will auto logout
			session.setAttribute("email", email);               // this is our first step where we create the session variable now we have to move on logout page and destroy the session 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
		}else {
			
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
