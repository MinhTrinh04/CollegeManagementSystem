package Model;

public class Student {
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String birthDate;
	private Model.Class c;
	
	
public Student() {}
	
	
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
	
	
	
	
	public Class GetCurrentClass() {
		return c;
	}

	public void SetClass(Class c) {
		this.c = c;
	}
}
