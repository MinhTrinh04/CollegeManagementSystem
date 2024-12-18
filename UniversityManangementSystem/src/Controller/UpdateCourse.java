package Controller;

import java.util.Scanner;

import Database.Database;
import Management.Class;
import Management.Course;
import Management.Department;
import Management.Operation;
import Users.Employee;

public class UpdateCourse implements Operation {

	@Override
	public void oper(Database database, Scanner scanner,int id) {
		System.out.println("Enter Course ID (-1 to show all courses):");
		int ID = scanner.nextInt();
		while (ID<0) {
			new ReadCourses().oper(database, scanner,id);
			System.out.println("Enter Course ID (-1 to show all courses):");
			ID = scanner.nextInt();
		}
		Course c = new Course(ID, database);
		
		scanner.nextLine();
		
		System.out.println("Enter Course Name (-1 to keep "+c.getName()+"):");
		String name = scanner.nextLine();
		if (!name.equals("-1")) c.setName(name);
		
		System.out.println("Enter Class ID (-1 to keep "+c.getCurrentClass().GetName()+")\n"
				+ "(-2 to show all classes):");
		int classID = scanner.nextInt();
		if (classID!=-1) {
			while (classID<0) {
				new ReadClasses().oper(database, scanner,id);
				System.out.println("Enter Class ID (-2 to show all classes):");
				classID = scanner.nextInt();
			}
			c.setClass(new Class(classID, database));
		}
		
		scanner.nextLine();
		
		System.out.println("Enter Course Description (-1 to keep "+c.getDescription()+"):");
		String description = scanner.nextLine();
		if (!description.equals("-1")) c.setDescription(description);
		
		System.out.println("Enter Course Limit (-1 to keep "+c.getLimit()+"):");
		int limit = scanner.nextInt();
		if (limit!=-1) c.setLimit(limit);
		
		scanner.nextLine();
		
		System.out.println("Enter Prof ID (-1 to keep Dr. "+c.getProf().GetFirstName()
				+" "+c.getProf().GetLastName()+")\n(-2 to show all employees):");
		int profID = scanner.nextInt();
		if (profID!=-1) {
			while (profID<0) {
				new ReadEmployees().oper(database, scanner,id);
				System.out.println("Enter Prof ID (-2 to show all employees):");
				profID = scanner.nextInt();
			}
			c.setProf(new Employee(profID, database));
		}
		
		scanner.nextLine();
		
		System.out.println("Enter Department ID (-1 to keep "+
				c.getDepartment().GetName()+")\n(-2 to show all departments):");
		int deptID = scanner.nextInt();
		if (deptID!=-1) {
			while (deptID<0) {
				new ReadDepartments().oper(database, scanner,id);
				System.out.println("Enter Department ID (-2 to show all departments):");
				deptID = scanner.nextInt();
			}
			c.setDepartment(new Department(deptID, database));
		}
		
		c.update(database);
	}

}
