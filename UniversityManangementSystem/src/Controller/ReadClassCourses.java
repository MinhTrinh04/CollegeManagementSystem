package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Database.Database;
import Management.Course;
import Management.Operation;
import Users.Student;

public class ReadClassCourses implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		Student student = new Student(ID, database);
		ArrayList<Course> courses = new ReadCourses().getAllCourses(database);
		System.out.println("ID\tName\t\tDescription\tProf\t\t\tDepartment");
		for (Course c : courses) {
			if (c.getCurrentClass().getID()==student.GetCurrentClass().getID()) {
				System.out.print(c.getID()+"\t");
				System.out.print(c.getName()+"\t");
				if (c.getName().length()<8) System.out.print("\t");
				System.out.print(c.getDescription()+"\t");
				if (c.getDescription().length()<8) System.out.print("\t");
				System.out.print("Dr. "+c.getProf().GetFirstName()+" "+
				c.getProf().GetLastName()+"\t");
				System.out.print(c.getDepartment().GetName()+"\n");
			}
		}
	}

}
