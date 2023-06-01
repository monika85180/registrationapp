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

@WebServlet("/getAllReg")
public class GetAllRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetAllRegistrationController() {
        super();
          }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);  
			if(session.getAttribute("email")!=null) {
			DAOService service = new DAOServiceImpl();
			service.connectDB();
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

}
