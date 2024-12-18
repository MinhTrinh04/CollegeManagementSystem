package Controller;

import java.util.Scanner;

import Database.Database;
import Management.Operation;
import Users.Student;

public class ReadStudentData implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		Student student = new Student(ID, database);
		student.print();
	}

}
