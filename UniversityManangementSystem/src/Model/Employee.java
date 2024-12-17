package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.AddCourseGrades;
import Controller.CreateClass;
import Controller.CreateCourse;
import Controller.CreateDepartment;
import Controller.CreateEmployee;
import Controller.CreateStudent;
import Controller.DeleteClass;
import Controller.DeleteCourse;
import Controller.DeleteCourseGrades;
import Controller.DeleteDepartment;
import Controller.DeleteEmployee;
import Controller.DeleteSpecCourseGrade;
import Controller.DeleteStudent;
import Controller.ReadClasses;
import Controller.ReadCourseStudents;
import Controller.ReadCourseGrades;
import Controller.ReadCourses;
import Controller.ReadDepartments;
import Controller.ReadEmployeeCourses;
import Controller.ReadEmployees;
import Controller.ReadStudents;
import Controller.UpdateClass;
import Controller.UpdateCourse;
import Controller.UpdateCourseGrade;
import Controller.UpdateCourseMaxGrade;
import Controller.UpdateDepartment;
import Controller.UpdateEmployee;
import Controller.UpdateEmployeePassword;
import Controller.UpdateStudent;

public class Employee extends User {
//	private int ID;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String phoneNumber;
//	private String birthDate;
	private double salary;
	private Department department;
//	private String password;
	
	public Employee() {}
	
	public Employee(int ID, Database database) {
		try {
			setID(ID);
			String select = "SELECT `ID`, `FirstName`, `LastName`, `Email`, "
					+ "`PhoneNumber`, `BirthDate`, `Salary`, `Department`, `Password`"
					+ " FROM `employees` WHERE `ID` = "+getID()+" ;";
			ResultSet rs = database.getStatement().executeQuery(select);
			if (rs.next()) {
				SetFirstName(rs.getString("FirstName"));
				SetLastName(rs.getString("LastName"));
				SetEmail(rs.getString("Email"));
				SetPhoneNum(rs.getString("PhoneNumber"));
				SetBirth(rs.getString("BirthDate"));
				SetSalary(rs.getDouble("Salary"));
				SetPassword(rs.getString("Password"));
				int deptID = rs.getInt("Department");
				SetDepartment(new Department(deptID, database));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
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
	
	public double GetSalary() {
		return salary;
	}

	public void SetSalary(double salary) {
		this.salary = salary;
	}
	
	public Department GetDepartment() {
		return department;
	}

	public void SetDepartment(Department department) {
		this.department = department;
	}
	
//	public String GetPassword() {
//		return password;
//	}
//	
//	
//	public void SetPassword(String password) {
//		this.password = password;
//	}
	
	public void update(Database database) {
		try {
			String update = "UPDATE `employees` SET `FirstName`='"+GetFirstName()+
					"',`LastName`='"+GetLastName()+"',`Email`='"+GetEmail()+
					"',`PhoneNumber`='"+getPhoneNum()+"',`BirthDate`='"+GetBirth()
					+"',`Salary`='"+GetSalary()+"',`Department`='"+GetDepartment().getID()
					+"',`Password`='"+GetPassword()+"' WHERE `ID` = "+getID()+" ;";
			database.getStatement().execute(update);
			System.out.println("Employee updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.println("ID:\t\t"+getID());
		System.out.println("Name:\t\t"+GetFirstName()+" "+GetLastName());
		System.out.println("Email:\t\t"+GetEmail());
		System.out.println("Phone Number:\t"+getPhoneNum());
		System.out.println("Birth Date:\t"+GetBirth());
		System.out.println("Salary:\t\t"+GetSalary());
		System.out.println("Department:\t"+GetDepartment().GetName());
		System.out.println("_________________________________________\n");
	}
	
//	public void create(Database database) {
//		try {
//			String insert = "INSERT INTO `employees`"
//					+ "(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, "
//					+ "`BirthDate`, `Salary`, `Department`, `Password`) VALUES "
//					+ "('"+ID+"','"+firstName+"','"+lastName+"','"+email+"','"+
//					phoneNumber+"','"+birthDate+"','"+salary+"','"+department.getID()+"','"+
//					password+"');";
//			database.getStatement().execute(insert);
//			System.out.println("Employee added successfully");
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	public void create(Database database) {
        try {
            String insert = "INSERT INTO `employees`"
                    + "(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, "
                    + "`BirthDate`, `Salary`, `Department`, `Password`) VALUES "
                    + "('"+getID()+"','"+GetFirstName()+"','"+GetLastName()+"','"+GetEmail()+"','"+
                    getPhoneNum()+"','"+GetBirth()+"','"+salary+"','"+department.getID()+"','"+
                    GetPassword()+"');";
            database.getStatement().execute(insert);
            System.out.println("Employee added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	
	private Operation[] managerOperations = new Operation[] {
			new CreateDepartment(),
			new ReadDepartments(),
			new UpdateDepartment(),
			new DeleteDepartment(),
			new CreateClass(),
			new ReadClasses(),
			new UpdateClass(),
			new DeleteClass(),
			new CreateCourse(),
			new ReadCourses(),
			new UpdateCourse(),
			new DeleteCourse(),
			new CreateEmployee(),
			new ReadEmployees(),
			new UpdateEmployee(),
			new DeleteEmployee(),
			new CreateStudent(),
			new ReadStudents(),
			new UpdateStudent(),
			new DeleteStudent(),
			new UpdateEmployeePassword()
	};
	
	private Operation[] profOperations = new Operation[] {
			new ReadDepartments(),
			new ReadClasses(),
			new ReadCourses(),
			new ReadEmployeeCourses(),
			new ReadCourseStudents(),
			new AddCourseGrades(),
			new ReadCourseGrades(),
			new UpdateCourseGrade(),
			new UpdateCourseMaxGrade(),
			new DeleteCourseGrades(),
			new DeleteSpecCourseGrade(),
			new UpdateEmployeePassword()
	};
	
	public void showList(Database database, Scanner scanner) {
		if (department.GetName().equals("Management")) {
			System.out.println("\n__________________________");
			System.out.println("01. Add new Department");
			System.out.println("02. Show all Departments");
			System.out.println("03. Edit Department");
			System.out.println("04. Delete Department");
			System.out.println("05. Add New Class");
			System.out.println("06. Show all classes");
			System.out.println("07. Edit Class");
			System.out.println("08. Delete Class");
			System.out.println("09. Add new Course");
			System.out.println("10. Show all Courses");
			System.out.println("11. Edit Course");
			System.out.println("12. Delete Course");
			System.out.println("13. Add new Employee");
			System.out.println("14. Show all Employees");
			System.out.println("15. Edit Employee");
			System.out.println("16. Delete Employee");
			System.out.println("17. Add new Student");
			System.out.println("18. Show all Students");
			System.out.println("19. Edit Student");
			System.out.println("20. Delete Student");
			System.out.println("21. Change Password");
			System.out.println("__________________________\n");
			
			int selected = scanner.nextInt();
			managerOperations[selected-1].oper(database, scanner, getID());

			showList(database, scanner);
		} else {
			System.out.println("\n__________________________");
			System.out.println("01. Show all Departments");
			System.out.println("02. Show all Classes");
			System.out.println("03. Show all Courses");
			System.out.println("04. Show my Courses");
			System.out.println("05. Show Course Students");
			System.out.println("06. Add Course Grades");
			System.out.println("07. Show Course Grades");
			System.out.println("08. Edit Course Grades");
			System.out.println("09. Edit Course Max");
			System.out.println("10. Delete Course Grades");
			System.out.println("11. Delete Spec Course Grade");
			System.out.println("12. Change Password");
			System.out.println("__________________________\n");
			
			int selected = scanner.nextInt();
			profOperations[selected-1].oper(database, scanner, getID());

			showList(database, scanner);
		}
	}
	
	
}
