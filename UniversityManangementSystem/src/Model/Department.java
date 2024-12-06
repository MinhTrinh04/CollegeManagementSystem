package Model;

public class Department {
	private int ID;
	private String title;

	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department (int ID,Database database) {
	
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
}
