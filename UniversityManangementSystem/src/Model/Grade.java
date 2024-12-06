package Model;

public class Grade {
	
	private int ID;
	private Course course;
	private Class c;
	private Student student;
	private double grade;
	private double max;
		
	public Grade() {
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public Course GetCourse() {
		return course;
	}
	
	public void SetCourse(Course course) {
		this.course = course;
	}
	
	public Class GetCurrentClass() {
		return c;
	}

	public void SetClass(Class c) {
		this.c = c;
	}
	
	public Student GetStudent() {
		return student;
	}

	public void SetStudent(Student student) {
		this.student = student;
	}
	
	public double GetGrade() {
		return grade;
	}

	public void SetGrade(double grade) {
		this.grade = grade;
	}
	
	public double GetMax() {
		return max;
	}

	public void SetMax(double max) {
		this.max = max;
	}
}
