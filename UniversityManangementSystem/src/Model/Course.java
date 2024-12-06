package Model;

import java.util.ArrayList;

public class Course {
	private int ID;
	private String title;
	private Class c;
	private String desc;
	private int limit;
	private ArrayList<Student> students;
	private Employee prof; 
	
	public  Course() {
		// TODO Auto-generated constructor stub
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String GetTitle() {
		return title;
	}
	
	
	public void SetTitle(String name) {
		this.title = name;
	}
	
	public Class GetCurrentClass() {
		return c;
	}

	public void SetClass(Class c) {
		this.c = c;
	}
	
	public String GetDesc() {
		return desc;
	}
	
	
	public void SetDesc(String desc) {
		this.desc = desc;
	}
	
	
	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public ArrayList<Student> getStudentts(){
		return students;
	}
	
	public void SetStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public Employee GetProf() {
		return prof;		
	}
	
	public void SetProf(Employee prof) {
		this.prof = prof;
	}
	
}
