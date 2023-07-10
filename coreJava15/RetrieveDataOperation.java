package coreJava15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetrieveDataOperation implements RetrieveInteface{

	@Override
	public boolean retriveAllData(Scanner sc) {
		// TODO Auto-generated method stub
			Statement statement=null;
			Connection connection=null;
			String userName="";
			String password="";
			JdbcDatabaseConnection con;
			try {
				String url="jdbc:mysql://localhost:3306/studentDb?useSSL=false";
				System.out.println("Enter userName");
				userName=sc.next();
				System.out.println("Enter password");
				password=sc.next();
				con =new JdbcDatabaseConnection(url, userName, password);
				if(con.getConnection()==null) {
					System.out.println("Failed to connect");
				}else {
					System.out.println("Success... Connected with Oracle DB");
					connection=con.getConnection();
				}
				statement=connection.createStatement();
				ResultSet rs=statement.executeQuery("select * from Product");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
				}
				return true;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return false;
		
	}

	@Override
	public boolean retriveSpecificData(Scanner sc) throws SQLException {
		// TODO Auto-generated method stub
		String ans="";
		String choice="";
		String userName="";
		String password="";
		Connection connection=null;
		NumberRegEx obj=new NumberRegEx();
		PreparedStatement statement=null;
		JdbcDatabaseConnection con=null;
		ResultSet rs=null;
		String query="";
		int pid;
		try {
			String url="jdbc:mysql://localhost:3306/studentDb?useSSL=false";
			System.out.println("Enter userName");
			userName=sc.next();
			System.out.println("Enter password");
			password=sc.next();
			con =new JdbcDatabaseConnection(url, userName, password);
			if(con.getConnection()==null) {
				System.out.println("Failed to connect");
			}else {
				System.out.println("Success... Connected with Oracle DB");
				connection=con.getConnection();
			}
		do {
			System.out.println("Menu to retrive info");
			System.out.println("1. Name");
			System.out.println("2.Quantity");
			System.out.println("3. Price");
			System.out.println("4.All details");
			System.out.println("Enter choice");
			choice=sc.next();
			switch(choice) {
//			
			case "1":
				System.out.println("Enter product id");
				pid=sc.nextInt();
				query="select pname from Product where pid = ?";
				statement=connection.prepareStatement(query);
				statement.setInt(1, pid);
				rs=statement.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
				break;
			case "2":
				System.out.println("Enter product id");
				pid=sc.nextInt();
				query="select pqty from Product where pid = ?";
				statement=connection.prepareStatement(query);
				statement.setInt(1, pid);
				rs=statement.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
			break;
			case "3":
				System.out.println("Enter product id");
				pid=sc.nextInt();
				query="select price from Product where pid = ?";
				statement=connection.prepareStatement(query);
				statement.setInt(1, pid);
				rs=statement.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
			break;
			case "4":
				System.out.println("Enter product id");
				pid=sc.nextInt();
				query="select pname ,pqty, price from Product where pid = ?";
				statement=connection.prepareStatement(query);
				statement.setInt(1, pid);
				rs=statement.executeQuery();
				while(rs.next()) {
					System.out.println("Name"+" "+rs.getString(1));
					System.out.println("Quantity"+" "+rs.getInt(2));
					System.out.println("Price"+" "+rs.getInt(3));
				}
			break;
				
			}
			System.out.println("Do you want to continue?");
			ans=sc.next();
		}while(ans.equals("y")||ans.equals("y"));
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		rs.close();
		statement.close();
		connection.close();
	}
		return true;
	}

		
}
