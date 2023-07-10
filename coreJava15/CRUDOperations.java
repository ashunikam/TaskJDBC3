package coreJava15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDOperations {
	public boolean createTable(String userName, String password, JdbcDatabaseConnection con, Statement statement,Scanner sc) throws SQLException {
		String url="jdbc:mysql://localhost:3306/studentDb?useSSL=false";
		System.out.println("Enter userName");
		userName=sc.next();
		System.out.println("Enter password");
		password=sc.next();
		con =new JdbcDatabaseConnection(url, userName, password);
		if(con.getConnection()!=null) {
			System.out.println("Connection Established");
			Connection connection=con.getConnection();
			statement=connection.createStatement();
			boolean success=statement.execute("create table Product (pid int(5), pname varchar(35), pqty int(5), price int(5));");
			if(success==false) {
				System.out.println("Table is created");
				return true;
			}
			
		}else {
			System.out.println(" Connection Failed");
		}
		return false;
	}

}
