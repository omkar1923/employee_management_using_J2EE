package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud {
	public Connection loadDriver() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "root");
		return connection;
	}

	public int signup(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "insert into employee values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setString(6, employee.getDesignation());
		preparedStatement.setDouble(7, employee.getSalary());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}

	public String login(String email) throws SQLException, ClassNotFoundException {
		Connection connection = loadDriver();
		String query = "select password from employee where email=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet set = preparedStatement.executeQuery();
		String password = null;
		while (set.next()) {
			password = set.getString("password");
		}
		connection.close();
		return password;
	}

	public int deleteEntry(int id) throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "delete from employee where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int set = preparedStatement.executeUpdate();
		connection.close();
		return set;
	}

	public Employee update(int id) throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "select * from employee where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet set = preparedStatement.executeQuery();
//	
		Employee employee = new Employee();
		while (set.next()) {
			
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setDesignation(set.getString("designation"));
			employee.setEmail(set.getString("email"));
			employee.setSalary(set.getDouble("salary"));
			employee.setPhone(set.getLong("phone"));
			employee.setPassword(set.getString("password"));
//			

		}
		connection.close();
//	.
		
		
		return employee;

	}
//	public String resister(String email) throws ClassNotFoundException, SQLException {
//		Connection connection = loadDriver();
//		String query = "select email from employee where email=?";
//		PreparedStatement preparedStatement = connection.prepareStatement(query);
//		preparedStatement.setString(1, email);
//		ResultSet set = preparedStatement.executeQuery();
//		String email1 = null;
//		while (set.next()) {
//			email1 = set.getString("email");
//		}
//		connection.close();
//		return email1;
//	}

	public List<Employee> getEmployee() throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "select * from employee;";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet set = preparedStatement.executeQuery();
		List<Employee> list = new ArrayList<Employee>();

		while (set.next()) {
			Employee employee = new Employee();
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setDesignation(set.getString("designation"));
			employee.setEmail(set.getString("email"));
			employee.setSalary(set.getDouble("salary"));
			employee.setPhone(set.getLong("phone"));
			employee.setPassword(set.getString("password"));
			list.add(employee);

		}
		connection.close();
		System.out.println(list);
		return list;
	}
	
	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String query="update employee set name=?,phone=?,email=?,password=?,designation=?,salary=? where id=? ";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(7, employee.getId());
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.setString(4, employee.getPassword());
		preparedStatement.setString(5, employee.getDesignation());
		preparedStatement.setDouble(6, employee.getSalary());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

}
