package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDatabaseConnection implements DatabaseConnection{
	private String url;
    private String username;
    private String password;
    public JdbcDatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }


	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
	}

}
