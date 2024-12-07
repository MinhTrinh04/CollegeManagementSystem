package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
	private int ID;
	private String Name;

	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(int ID) {
		this.ID = ID;
	}
	
	public Department(int ID, Database database) {
		try {
			String select = "SELECT * FROM `departments` WHERE `ID` = "+ID+" ;";
			ResultSet rs = database.getStatement().executeQuery(select);
			if (rs.next()) { 
	            setID(rs.getInt("ID"));
	            SetName(rs.getString("Name"));
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
	
	public String GetName() {
		return Name;
	}
	
	
	public void SetName(String name) {
		this.Name = name;
	}
	
	public void print() {
		System.out.println("ID:\t"+getID());
		System.out.println("Name:\t"+GetName());
		System.out.println("____________________________\n");
	}
	
	public void create(Database database) {
		String insert = "INSERT INTO `departments`(`ID`, `Name`) "
				+ "VALUES ('"+getID()+"','"+GetName()+"');";
		try {
			database.getStatement().execute(insert);
			System.out.println("Department created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Database database) {
		String update = "UPDATE `departments` SET `Name`='"+GetName()+"' "
				+ "WHERE `ID` = "+getID()+" ;";
		try {
			database.getStatement().execute(update);
			System.out.println("Department updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Database database) {
		try {
			String delete = "DELETE FROM `departments` WHERE `ID` = "+ID+" ;";
			database.getStatement().execute(delete);
			System.out.println("Department deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
