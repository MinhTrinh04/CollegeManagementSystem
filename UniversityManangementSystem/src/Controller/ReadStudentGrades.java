package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Database.Database;
import Management.Class;
import Management.Course;
import Management.Grade;
import Management.Operation;
import Users.Student;

public class ReadStudentGrades implements Operation {

	@Override
	public void oper(Database database, Scanner scanner, int ID) {
		String select = "SELECT * FROM `grades` WHERE `Student` = "+ID+" ;";
		ArrayList<Grade> grades = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			ArrayList<Integer> coursesIDs = new ArrayList<>();
			ArrayList<Integer> classesIDs = new ArrayList<>();
			while (rs.next()) {
				Grade g = new Grade();
				g.setID(rs.getInt("ID"));
				coursesIDs.add(rs.getInt("Course"));
				classesIDs.add(rs.getInt("Class"));
				g.SetGrade(rs.getDouble("Grade"));
				g.SetMax(rs.getDouble("Max"));
				grades.add(g);
			}
			
			Student student = new Student(ID, database);
			for (int i=0;i<grades.size();i++) {
				grades.get(i).SetCourse(new Course(coursesIDs.get(i), database));
				grades.get(i).SetClass(new Class(classesIDs.get(i), database));
				grades.get(i).SetStudent(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("ID\tCourse\t\t\tClass\t\t\tGrade\tMax");
		for (Grade g : grades) {
			System.out.print(g.getID()+"\t");
			System.out.print(g.GetCourse().getName()+"\t");
			if (g.GetCourse().getName().length()<8) System.out.print("\t");
			System.out.print(g.GetCurrentClass().GetName()+"\t");
			System.out.print(g.GetGrade()+"\t");
			System.out.print(g.GetMax()+"\n");
		}
	}

}
