package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/delete")
public class deleteController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	EmployeeCrud crud=new EmployeeCrud();
int id=Integer.parseInt(req.getParameter("id"));
try {
	int result=crud.deleteEntry(id);
	HttpSession httpSession=req.getSession();
	String value=(String) httpSession.getAttribute("session");
	if(result!=0) {
		if(value!=null) {
			
	req.setAttribute("message", value);
		req.setAttribute("list",crud.getEmployee());
	    RequestDispatcher dispatcher = req.getRequestDispatcher("/Welcome.jsp");
	    dispatcher.forward(req, res);
	    System.err.println("success");
		}
	}
	else {
		System.err.println("error");
	}
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
	
		


}
