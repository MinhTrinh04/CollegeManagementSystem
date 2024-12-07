package Model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Employee {
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String birthDate;
	private double salary;
	private Department department;
	private String password;
	
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
		
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String GetFirstName() {
		return firstName;
	}
	
	
	public void SetFirstName(String name) {
		this.firstName = name;
	}
	
	public String GetLastName() {
		return lastName;
	}
	
	
	public void SetLastName(String name) {
		this.lastName = name;
	}
	
	public String GetEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNum() {
		return phoneNumber;
	}

	public void SetPhoneNum(String phonenum ) {
		this.phoneNumber = phonenum;
	}
	
	public String GetBirth() {
		return birthDate;
	}

	public void SetBirth(String birthDate) {
		this.birthDate = birthDate;
	}
	
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
	
	public String GetPassword() {
		return password;
	}
	
	
	public void SetPassword(String password) {
		this.password = password;
	}
	
//	public void update(Database database) {
//		try(Statement statement = database.createStatement();) {
//			String update = "UPDATE employees SET " +
//	                    "FirstName='" + GetFirstName() + "'," +
//	                    "LastName='" + GetLastName() + "'," +
//	                    "Email='" + GetEmail() + "'," +
//	                    "PhoneNumber='" + getPhoneNum() + "'," +
//	                    "BirthDate='" + GetBirth() + "'," +
//	                    "Salary=" + GetSalary() + "," +
//	                    "Department='" + GetDepartment().getID() + "'," + 
//	                    "Password='" + GetPassword() + "' " +
//	                    "WHERE ID = " + getID() + ";";
//			statement.executeUpdate(update);
//			System.out.println("Employee updated successfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}  
//	}
//	
	
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
	
	public void create(Database database) {
		try {
			String insert = "INSERT INTO `employees`"
					+ "(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, "
					+ "`BirthDate`, `Salary`, `Department`, `Password`) VALUES "
					+ "('"+ID+"','"+firstName+"','"+lastName+"','"+email+"','"+
					phoneNumber+"','"+birthDate+"','"+salary+"','"+department.getID()+"','"+
					password+"');";
			database.getStatement().execute(insert);
			System.out.println("Employee added successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
