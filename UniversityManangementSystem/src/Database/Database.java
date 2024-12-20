package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private String user = "root";
    private String pass = "1234";
    private String url = "jdbc:mysql://localhost:3306/college";
    private Connection connection;
    private Statement statement;
    
    public Database() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
		return statement;
	}
}
