package Controller;

import java.util.Scanner;

import Database.Database;
import Management.Course;
import Management.Operation;

public class ReadEmployeeCourses implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		for (Course c : new ReadCourses().getAllCourses(database)) {
			if (c.getProf().getID()==ID) {
				c.print();
			}
		}
	}

}
