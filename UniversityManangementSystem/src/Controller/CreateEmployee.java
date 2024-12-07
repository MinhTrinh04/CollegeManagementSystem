package Controller;


import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

public class CreateEmployee implements Operation{

	@Override
		public void oper(Database database, Scanner scanner) {
		
		Employee e = new Employee();
		
		System.out.println("Enter First Name:");
		e.SetFirstName(scanner.next());
		System.out.println("Enter Last Name:");
		e.SetLastName(scanner.next());
		System.out.println("Enter Email:");
		e.SetEmail(scanner.next());
		System.out.println("Enter Phone Number:");
		e.SetPhoneNum(scanner.next());
		System.out.println("Enter Birth Date:");
		e.SetBirth(scanner.next());
		System.out.println("Enter Salary (double):");
		e.SetSalary(scanner.nextDouble());
		System.out.println("Enter Department ID (-1 to show all departments):");
		int deptID = scanner.nextInt();
		while (deptID<0) {
			new ReadDepartments().oper(database, scanner);
			System.out.println("Enter Department ID (-1 to show all departments):");
			deptID = scanner.nextInt();
		}
		
		e.SetDepartment(new Department(deptID, database));
		
		System.out.println("Enter Password:");
		String password = scanner.next();
		System.out.println("Confirm Password:");
		String confirmPassword = scanner.next();
		
		while (!confirmPassword.equals(password)) {
			System.out.println("Enter Password:");
			password = scanner.next();
			System.out.println("Confirm Password:");
			confirmPassword = scanner.next();
		}
		e.SetPassword(password);
		
		ArrayList<Employee> employees = new ReadEmployees().getAllEmployees(database);
		int ID = 0;
		if (employees.size()!=0) {
			ID = employees.get(employees.size()-1).getID()+1;
		}
		e.setID(ID);
		e.create(database);
	}
	
}
