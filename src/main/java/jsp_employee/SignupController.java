package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/details")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Employee employee = new Employee();
		EmployeeCrud crud = new EmployeeCrud();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String designation = req.getParameter("designation");
	
		double salary = Double.parseDouble(req.getParameter("salary"));

		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setPassword(password);
		employee.setDesignation(designation);
		employee.setSalary(salary);

		try {
			int result = crud.signup(employee);
			if (result != 0) {
				req.setAttribute("message","Signup Successful,Plz login");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, res);
				
			} else {
				req.setAttribute("message","invalid credentials,Plz try again");
				RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
				dispatcher.forward(req, res);

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
