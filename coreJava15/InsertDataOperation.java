package coreJava15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertDataOperation implements InsertDataInterface{

	@Override
	public boolean inserData(Scanner sc) throws SQLException {
		 JdbcDatabaseConnection con=null;
		 String userName="",password="";
		 
		 Connection connection=null;
		PreparedStatement statement=null;
		try {
		NumberRegEx obj=new NumberRegEx();
		String  pid="", pqty="", price="";
		String pName="";
		int recordNum=0;
		String url="jdbc:mysql://localhost:3306/studentDb?useSSL=false";
		System.out.println("Enter userName");
		userName=sc.next();
		System.out.println("Enter password");
		password=sc.next();
		con=new JdbcDatabaseConnection(url, userName, password);
		
		if(con.getConnection()!=null) {
			connection=con.getConnection();
			System.out.println("Connection Established");
			System.out.println("How many records would you like to insert?");
			recordNum=sc.nextInt();
			for(int i=0;i<recordNum;i++) {
				do {
				System.out.println("Enter product id");
				try {
				pid=sc.next();
				}catch(InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.next();
					pid=sc.next();
				}
				}while(!obj.isValid(pid));
				System.out.println("Enter product name");
				pName=sc.next();
				do {
				System.out.println("Enter quantity");
				try {
				pqty=sc.next();
				}catch(InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.next();
					pqty=sc.next();
				}}while(!obj.isValid(pqty));
				do {
				System.out.println("Enter price");
				try {
				price=sc.next();
				}catch(InputMismatchException e) {
					System.out.println("Enter numbers only");
					sc.next();
					price=sc.next();
				}
				}while(!obj.isValid(price));
				String query="insert into Product values("+pid+", '"+pName+"', "+pqty+", "+price+")";
				statement=connection.prepareStatement(query);
				
				int res=statement.executeUpdate(query);
				if(res==0) {
					System.out.println("Failed to insert the records");
				}else {
					System.out.println("Record inserted successfully");
				}
				System.out.println("-------------------------------------------");
			}
			System.out.println(recordNum+ " "+"records inserted successfully");
			return true;
		}else {
			System.out.println(" Connection Failed");
		}
		}
		catch(SQLException e) {
				e.printStackTrace();
		}
		finally {
			statement.close();
		}
		
		return false;
	}

}
