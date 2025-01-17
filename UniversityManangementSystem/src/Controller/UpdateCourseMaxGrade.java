package Controller;

import java.sql.SQLException;
import java.util.Scanner;

import Database.Database;
import Management.Operation;

public class UpdateCourseMaxGrade implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		System.out.println("Enter Course ID (-1 to show all your courses):");
		int courseID = scanner.nextInt();
		while (courseID<0) {
			new ReadEmployeeCourses().oper(database, scanner, ID);
			System.out.println("Enter Course ID (-1 to show all your courses):");
			courseID = scanner.nextInt();
		}
		
		System.out.println("Enter Max Grade:");
		double max = scanner.nextDouble();
		
		String update = "UPDATE `grades` SET `Max`='"+max+"' "
				+ "WHERE `Course` = "+courseID+" ;";
		try {
			database.getStatement().execute(update);
			System.out.println("Max Grade updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
