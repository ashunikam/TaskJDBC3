package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDb?useSSL=false","root","Hogwards4340$");
			if(con==null) {
				System.out.println("Connection failed");
				
			}else {
				System.out.println("Success... Connected with Oracle DB");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
