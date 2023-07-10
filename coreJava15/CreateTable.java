package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args)  {
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
			boolean success=statement.execute("create table studentsnva (sno int(5), sname varchar(35), course varchar(50))");
			if(success==false) {
				System.out.println("Success.. Table created");
			}else {
				System.out.println("Failed to create table");
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
