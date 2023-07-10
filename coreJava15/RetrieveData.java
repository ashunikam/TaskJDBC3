package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDb?useSSL=false","root","Hogwards4340$");
			if(connection==null) {
				System.out.println("Connection failed");
				
			}else {
				System.out.println("Success... Connected with Oracle DB");
			}
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from studentsnva");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			rs.close();
			statement.close();
			connection.close();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	

	
	}

}
