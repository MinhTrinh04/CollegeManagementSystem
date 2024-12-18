package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Database.Database;
import Management.Class;
import Management.Operation;
import Users.Student;

public class CreateStudent implements Operation {

	@Override
	public void oper(Database database, Scanner scanner,int id) {
		
		Student s = new Student();
		
		ArrayList<Student> students = new ReadStudents().getAllStudents(database);
		int ID = 0;
		if (students.size()!=0) {
			ID = students.get(students.size()-1).getID()+1;
		}
		s.setID(ID);

		System.out.println("Enter First Name:");
		s.SetFirstName(scanner.next());
		
		System.out.println("Enter Last Name:");
		s.SetLastName(scanner.next());
		
		System.out.println("Enter Email:");
		s.SetEmail(scanner.next());
		
		System.out.println("Enter Phone Number:");
		s.SetPhoneNum(scanner.next());
		
		System.out.println("Enter Birth Date:");
		s.SetBirth(scanner.next());
		
		System.out.println("Enter Class ID (-1 to show all classes):");
		int classID = scanner.nextInt();
		while (classID<0) {
			new ReadClasses().oper(database, scanner,id);
			System.out.println("Enter Class ID (-1 to show all classes):");
			classID = scanner.nextInt();
		}
		s.SetClass(new Class(classID, database));
		
		System.out.println("Enter Password:");
		String password = scanner.next();
		System.out.println("Confirm Password:");
		String confirmPassword = scanner.next();
		while (!password.equals(confirmPassword)) {
			System.out.println("Password doesn't match");
			System.out.println("Enter Password:");
			password = scanner.next();
			System.out.println("Confirm Password:");
			confirmPassword = scanner.next();
		}
		s.SetPassword(password);
		s.create(database);
		
	}

}
