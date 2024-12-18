package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Database.Database;
import Management.Course;
import Management.Operation;
import Users.Student;

public class ReadAvailableCourses implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		Student student = new Student(ID, database);
		ArrayList<Course> courses = new ReadCourses().getAllCourses(database);
		
		for (Course c : courses) {
			if (c.getCurrentClass().getID()==student.GetCurrentClass().getID()
					&& c.getStudents().size()<c.getLimit()) {
				c.print();
			}
		}
	}

}
