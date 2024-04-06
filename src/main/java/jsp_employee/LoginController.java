package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	EmployeeCrud crud=new EmployeeCrud();
	String email=req.getParameter("email");
	try {
		String dbPassword=crud.login(email);
	
		String password=req.getParameter("password");
		
		if (dbPassword != null ) {
	
		if ( dbPassword.equals(password)) {
		    // Login successful
//			req.setAttribute("message","login successful");
			req.setAttribute("list",crud.getEmployee());
		    RequestDispatcher dispatcher = req.getRequestDispatcher("/Welcome.jsp");
		    dispatcher.forward(req, res);
		    System.err.println("success");
		} else {
		    // Login failed
			req.setAttribute("message","passord not match,plz enter valid passord");
			
		    RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
		    dispatcher.forward(req, res);
		    System.err.println("err");
		}
		}
			else {
				req.setAttribute("message","no user on this email,Plz resister");
				RequestDispatcher dispatcher=req.getRequestDispatcher("/signup.jsp");
				dispatcher.forward(req, res);
				
			
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}

}
