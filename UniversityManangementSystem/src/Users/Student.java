package Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.ReadAvailableCourses;
import Controller.ReadStudentData;
import Controller.ReadStudentGrades;
import Controller.RegisterCourse;
import Controller.UpdateStudentPassword;
import Database.Database;
import Management.Class;
import Management.Course;
import Management.Operation;

public class Student extends User{
//	private int ID;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String phoneNumber;
//	private String birthDate;
	private Management.Class c;
//	private String password;
	
	public Student() {}
	
	 public Student(int ID) {
	        super();
	        this.setID(ID);
	 }
	 
	 public Student(int ID, Database database) {
	        super(); 
	        try {
	            setID(ID);
	            String select = "SELECT `FirstName`, `LastName`, `Email`, "
	                    + "`PhoneNumber`, `BirthDate`, `Class`, `Password`"
	                    + " FROM `students` WHERE `ID` = "+getID()+" ;";
	            ResultSet rs = database.getStatement().executeQuery(select);
	            if (rs.next()) {
	                SetFirstName(rs.getString("FirstName"));
	                SetLastName(rs.getString("LastName"));
	                SetEmail(rs.getString("Email"));
	                SetPhoneNum(rs.getString("PhoneNumber"));
	                SetBirth(rs.getString("BirthDate"));
	                SetPassword(rs.getString("Password"));
	                SetClass(new Class(rs.getInt("Class"), database));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
//	public String getPassword() {
//	return password;
//	}
//
//	public void setPassword(String password) {
//	this.password = password;
//	}
//	
//	public int getID() {
//		return ID;
//	}
//	
//	public void setID(int ID) {
//		this.ID = ID;
//	}
//	
//	public String GetFirstName() {
//		return firstName;
//	}
//	
//	
//	public void SetFirstName(String name) {
//		this.firstName = name;
//	}
//	
//	public String GetLastName() {
//		return lastName;
//	}
//	
//	
//	public void SetLastName(String name) {
//		this.lastName = name;
//	}
//	
//	public String GetEmail() {
//		return email;
//	}
//
//	public void SetEmail(String email) {
//		this.email = email;
//	}
//	
//	public String getPhoneNum() {
//		return phoneNumber;
//	}
//
//	public void SetPhoneNum(String phonenum ) {
//		this.phoneNumber = phonenum;
//	}
//	
//	public String GetBirth() {
//		return birthDate;
//	}
//
//	public void SetBirth(String birthDate) {
//		this.birthDate = birthDate;
//	}
	
	
	public Class GetCurrentClass() {
		return c;
	}

	public void SetClass(Class c) {
		this.c = c;
	}
	
	
	public void print() {
		System.out.println("ID:\t\t"+getID());
		System.out.println("Name:\t\t"+GetFirstName()+" "+GetLastName());
		System.out.println("Email:\t\t"+GetEmail());
		System.out.println("Phone Number:\t"+getPhoneNum());
		System.out.println("Birth Date:\t"+GetBirth());
		System.out.println("Class:\t\t"+c.GetName());
		System.out.println("_________________________________________\n");
	}
	
	public void create(Database database) {
        String insert = "INSERT INTO `students`(`ID`, `FirstName`, `LastName`, `Email`,"
                + " `PhoneNumber`, `BirthDate`, `Class`, `Password`) VALUES "
                + "('"+getID()+"','"+GetFirstName()+"','"+GetLastName()+"','"+GetEmail()+"','"+
                getPhoneNum()+"','"+GetBirth()+"','"+c.getID()+"','"+GetPassword()+"');";
        try {
            database.getStatement().execute(insert);
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void update(Database database) {
        try {
            String update = "UPDATE `students` SET `FirstName`='"+GetFirstName()+"',"
                    + "`LastName`='"+GetLastName()+"',`Email`='"+GetEmail()+"',"
                    + "`PhoneNumber`='"+getPhoneNum()+"',`BirthDate`='"+GetBirth()+"',"
                    + "`Class`='"+c.getID()+"',`Password`='"+GetPassword()+"' "
                    + "WHERE `ID` = "+getID()+" ;";
            database.getStatement().execute(update);
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void delete(Database database) {
        String delete = "DELETE FROM `students` WHERE `ID` = "+getID()+" ;";
        try {
            database.getStatement().execute(delete);
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

	public void registerCourse(Database database, int courseID) {
	    try {
	        // First, retrieve the course, student, and class information
	        Course course = new Course(courseID, database);
	        Student student = new Student(getID(), database); // Assuming getID() returns the student's ID
	        Class classObj = course.getCurrentClass(); // Assuming getCurrentClass() returns the Class object

	        // Build the INSERT statement (like your example, but with all required columns)
	        String insert = "INSERT INTO `enrollments`(`Course_id`, `Course_name`, `Student_id`, `Student_name`, `Class_id`, `Class_name`, `Prof_id`, `Prof_name`) " +
	                "VALUES ('" + course.getID() + "', '" + course.getName() + "', '" + student.getID() + "', '" + 
	                student.GetFirstName() + " " + student.GetLastName() + "', '" + classObj.getID() + "', '" + classObj.GetName() + "', '" + 
	                course.getProf().getID() + "', '" + course.getProf().GetFirstName() + " " + course.getProf().GetLastName() + "')";
	        database.getStatement().execute(insert);
	        System.out.println("Course registered successfully");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    
	    }
	}
	
	
	private Operation[] operations = new Operation[] {
			new RegisterCourse(),
			new ReadStudentData(),
			new ReadAvailableCourses(),
			new ReadStudentGrades(),
			new UpdateStudentPassword()
	};
	
	
	public void showList(Database database, Scanner scanner) {
		System.out.println("\n_______________________");
		System.out.println("01. Register Courses");
		System.out.println("02. Show my Data");
		System.out.println("03. Show Available Courses");
		System.out.println("04. Show my Grades");
		System.out.println("05. Change Password");
		System.out.println("_______________________\n");
		
		int selected = scanner.nextInt();
		operations[selected-1].oper(database, scanner, getID());

		showList(database, scanner);
	}
}
