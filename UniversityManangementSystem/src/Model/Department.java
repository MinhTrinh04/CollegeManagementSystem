package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Department {
	private int ID;
	private String title;

	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int ID, Database database) {
		try {
			String select = "SELECT * FROM `departments` WHERE `ID` = "+ID+" ;";
			ResultSet rs = database.getStatement().executeQuery(select);
			if (rs.next()) { 
	            setID(rs.getInt("ID"));
	            SetTitle(rs.getString("Name"));
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
	
	public String GetTitle() {
		return title;
	}
	
	
	public void SetTitle(String name) {
		this.title = name;
	}
}
