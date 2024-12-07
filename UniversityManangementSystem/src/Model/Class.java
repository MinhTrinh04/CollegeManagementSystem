package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Class {
	private int ID;
	private String name;

	
	public Class() {
		// TODO Auto-generated constructor stub
	}
	
	public Class(int ID, Database database) {
		this.ID = ID;
		String select = "SELECT * FROM `classes` WHERE `ID` = "+ID+" ;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			rs.next();
			SetName(rs.getString("Name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Class(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String GetName() {
		return name;
	}
	
	
	public void SetName(String name) {
		this.name = name;
	}

	
	public void print() {
		System.out.println("ID:\t"+ID);
		System.out.println("Name:\t"+name);
		System.out.println("______________\n");
	}
	
	public void create(Database database) {
		String insert = "INSERT INTO `classes`(`ID`, `Name`) VALUES "
				+ "('"+ID+"','"+name+"');";
		try {
			database.getStatement().execute(insert);
			System.out.println("Class created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Database database) {
		String update = "UPDATE `classes` SET `Name`='"+GetName()+"' "
				+ "WHERE `ID` = "+getID()+" ;";
		try {
			database.getStatement().execute(update);
			System.out.println("Class updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Database database) {
		String delete = "DELETE FROM `classes` WHERE `ID` = "+getID()+" ;";
		try {
			database.getStatement().execute(delete);
			System.out.println("Class deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
