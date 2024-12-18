package Controller;


import java.util.Scanner;

import Database.Database;
import Management.Department;
import Management.Operation;
import Users.Employee;

public class UpdateEmployee implements Operation {

		
	@Override
	public void oper(Database database, Scanner scanner,int id) {
		
			System.out.println("Enter User ID (-1 to show all employees):");
			int userID = scanner.nextInt();
			while (userID <0) {
				System.out.println("Enter User ID (-1 to show all employees):");
				new ReadEmployees().oper(database, scanner,id);
				userID = scanner.nextInt();
			}
		
		
		Employee employee = new Employee(userID,database);
		
		System.out.println("Enter First name (-1 to keep "+employee.GetFirstName()+"):");
		String firstName = scanner.next();
		if(!firstName.equals("-1")) employee.SetFirstName(firstName);
		

		System.out.println("Enter Last name (-1 to keep " + employee.GetLastName() + "):");
		String lastName = scanner.next();
		if (!lastName.equals("-1")) {
		  employee.SetLastName(lastName);
		}

		System.out.println("Enter Email (-1 to keep " + employee.GetEmail() + "):");
		String email = scanner.next();
		if (!email.equals("-1")) {
		  employee.SetEmail(email);
		}

		System.out.println("Enter Phone number (-1 to keep " + employee.getPhoneNum() + "):");
		String phoneNumber = scanner.next();
		if (!phoneNumber.equals("-1")) {
		  employee.SetPhoneNum(phoneNumber);
		}

		System.out.println("Enter Birth date (YYYY-MM-DD) (-1 to keep " + employee.GetBirth() + "):");
		String birthDate = scanner.next();
		if (!birthDate.equals("-1")) {
		  employee.SetBirth(birthDate);
		}

		System.out.println("Enter Salary (-1 to keep " + employee.GetSalary() + "$ ):");
		double salary = scanner.nextDouble();
		if (salary != -1) {
		  employee.SetSalary(salary);
		}


		System.out.println("Enter Password (-1 to keep old password ):");
		String password = scanner.next();
		if (!password.equals("-1")) {
			System.out.println("Confirm Password:");
			String cfpassword = scanner.next();
			while (!password.equals(cfpassword)) {
				System.out.println("Enter Password:");
				password = scanner.next();
				System.out.println("Confirm Password:");
				cfpassword = scanner.next();
			}
		  employee.SetPassword(password);
		}
		
		
		System.out.println("Enter Department (-1 to keep " + employee.GetDepartment().GetName() + ")\n"
				+ "(-2 to show all departments):");
		int deptID = scanner.nextInt();
		if(deptID != -1) {
			while (deptID == -2 ) {
				new ReadDepartments().oper(database, scanner,id);
				deptID = scanner.nextInt();
			}
			employee.SetDepartment(new Department(deptID, database));
		}
		employee.update(database);
			
		
			
			
			
	}
		
		
		
		
		
		
		
}
	

