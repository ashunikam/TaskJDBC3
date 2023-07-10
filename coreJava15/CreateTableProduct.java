package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			boolean success=statement.execute("create table Product (pid int(5), pname varchar(35), qty int (5), price int (5))");
			if(success) {
				System.out.println("Success.. Table created");
			}else {
				System.out.println("Failed to create table");
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	

	}

}
