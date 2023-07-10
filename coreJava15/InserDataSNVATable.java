package coreJava15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class InserDataSNVATable {

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
			Statement statement=con.createStatement(); 
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the student number");
			int no=sc.nextInt();
			System.out.println("Enter student name");
			String name=sc.next();
			System.out.println("Enter the course");
			String course=sc.next();
			String sqlQuery="insert into studentsnva values("+ no +", '"+name+"', '"+course+"')";
			int result=statement.executeUpdate(sqlQuery);
			if(result==0) {
				System.out.println("Failed to inser the records");
			}else{
				System.out.println("Record inserted successfully");
			}
			statement.close();
			con.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		

	}
	public static void establishConnection() throws SQLException {

		// TODO Auto-generated method stub
		

	
	}

}
