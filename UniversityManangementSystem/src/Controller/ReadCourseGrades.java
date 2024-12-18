package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Database.Database;
import Management.Course;
import Management.Grade;
import Management.Operation;
import Users.Student;

public class ReadCourseGrades implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		System.out.println("Enter Course ID (-1 to show all your courses):");
		int courseID = scanner.nextInt();
		while (courseID<0) {
			new ReadEmployeeCourses().oper(database, scanner, ID);
			System.out.println("Enter Course ID (-1 to show all your courses):");
			courseID = scanner.nextInt();
		}
		
		Course course = new Course(courseID, database);
		String select = "SELECT * FROM `grades` WHERE `Course` = "+course.getID()+" ;";
		ArrayList<Grade> grades = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			ArrayList<Integer> studentsIDs = new ArrayList<>();
			while (rs.next()) {
				Grade g = new Grade();
				g.setID(rs.getInt("ID"));
				g.SetCourse(course);
				g.SetClass(course.getCurrentClass());
				studentsIDs.add(rs.getInt("Student"));
				g.SetGrade(rs.getDouble("Grade"));
				g.SetMax(rs.getDouble("Max"));
				grades.add(g);
			}
			
			for (int i=0;i<grades.size();i++) {
				grades.get(i).SetStudent(new Student(studentsIDs.get(i), database));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (grades.size()!=0) {
			System.out.println("ID\tStudent\t\tClass\t\t\tGrade/"+grades.get(grades.size()-1).GetMax());
		}
		for (Grade g : grades) {
			System.out.print(g.getID()+"\t");
			System.out.print(g.GetStudent().GetFirstName()+" "+
						g.GetStudent().GetLastName()+"\t");
			System.out.print(g.GetCurrentClass().GetName()+"\t");
			System.out.print(g.GetGrade()+"\n");
		}
	}

}
