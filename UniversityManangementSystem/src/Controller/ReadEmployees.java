package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

public class ReadEmployees implements Operation {

	@Override
	public void oper(Database database, Scanner scanner,int id) {
		
		ArrayList<Employee> employees = getAllEmployees(database);
		for (Employee e : employees) {
			e.print();
		}
		
	}	
	
	public ArrayList<Employee> getAllEmployees(Database database) {
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Integer> deptIDs = new ArrayList<>();

		try {
			String select = "SELECT * FROM `employees`;";
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setID(rs.getInt("ID"));
				employee.SetFirstName(rs.getString("FirstName"));
				employee.SetLastName(rs.getString("LastName"));
				employee.SetEmail(rs.getString("Email"));
				employee.SetPhoneNum(rs.getString("PhoneNumber"));
				employee.SetBirth(rs.getString("BirthDate"));
				employee.SetSalary(rs.getDouble("Salary"));
				employee.SetPassword(rs.getString("Password"));
				employees.add(employee);
				deptIDs.add(rs.getInt("Department"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i=0;i<employees.size();i++) {
			employees.get(i).SetDepartment(new Department(deptIDs.get(i), database));
		}
		return employees;
	}

}
