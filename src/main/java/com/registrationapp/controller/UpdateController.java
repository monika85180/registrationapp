package com.registrationapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registrationapp.model.DAOService;
import com.registrationapp.model.DAOServiceImpl;


@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// this data is coming from get_allRegistration page when we click on update it send email and mobile 
		
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			// after getting  email and mobile we are sending it to updateRegistration page and after that build query for update
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateRegistration.jsp");
			rd.forward(request, response);
			
			
			
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);  
			if(session.getAttribute("email")!=null) {
				
			
			// we are getting the data from updateRegistration page because we have to save the data in database
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			DAOService service = new DAOServiceImpl();
			
			service.connectDB();
			service.updateRegistration(email, mobile);
			ResultSet result = service.getAllRegistration();
			
			request.setAttribute("res", result);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/get_allRegistration.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd= request.getRequestDispatcher("login.jsp"); 
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp"); 
			rd.forward(request, response);
		}
		
	
		
		
	
	}

}
