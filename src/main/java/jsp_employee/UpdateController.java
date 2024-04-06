package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeCrud crud = new EmployeeCrud();
				try {
		Employee employee=crud.update(id);
			if (employee !=null) {
				
				req.setAttribute("emp",employee);
				RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String designation = req.getParameter("designation");
	
		double salary = Double.parseDouble(req.getParameter("salary"));
Employee employee=new Employee();
employee.setId(id);
employee.setName(name);
employee.setEmail(email);
employee.setPhone(phone);
employee.setPassword(password);
employee.setDesignation(designation);
employee.setSalary(salary);
EmployeeCrud crud=new EmployeeCrud();
int result;
try {
	result = crud.updateEmployee(employee);
	if(result!=0) {
	req.setAttribute("list",crud.getEmployee());
	RequestDispatcher dispatcher=req.getRequestDispatcher("Welcome.jsp");
	dispatcher.forward(req, res);
	}
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
		


}
}