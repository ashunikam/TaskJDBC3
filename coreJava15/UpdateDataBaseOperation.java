package coreJava15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDataBaseOperation implements UpdateInterface {
	@Override
	public boolean updateData(Scanner sc, JdbcDatabaseConnection con) throws SQLException {
		int choice=0, qty=0, price=0,id=0,  rowsAffected ;
		String name="",userName="",password="",ans="",sql="";
			PreparedStatement statement=null;
			Connection connection=null;
		// TODO Auto-generated method stub

		try {
			String url="jdbc:mysql://localhost:3306/studentDb?useSSL=false";
			System.out.println("Enter userName");
			userName=sc.next();
			System.out.println("Enter password");
			password=sc.next();
			con=new JdbcDatabaseConnection(url,userName,password );
			if(con.getConnection()==null) {
				System.out.println("Failed to connect");
			}else {
				System.out.println("Success... Connected with Oracle DB");
				connection=con.getConnection();
			}
			
			do {
				System.out.println("1. Name");
				System.out.println("2. Quantity");
				System.out.println("3.Price");
				System.out.println("Enter choice");
				choice=sc.nextInt();
				switch(choice) {
				case 1: 
					System.out.println("Enter the new name");
					name=sc.next();
					System.out.println("enter the id for which you want to change the name");
					id=sc.nextInt();
					  sql = "UPDATE product SET pname = ? WHERE pid = ?";
					 statement = connection.prepareStatement(sql);
					 statement.setString(1, name);
					 statement.setInt(2, id);
					 rowsAffected = statement.executeUpdate();
					 if (rowsAffected > 0) {
			                System.out.println("Product name updated successfully.");
			            } else {
			                System.out.println("Product not found or update failed.");
			            }
					
				break;
				case 2: 
					System.out.println("Enter the new qty");
					qty=sc.nextInt();
					System.out.println("enter the id for which you want to change the qty");
					id=sc.nextInt();
					  sql = "UPDATE product SET pqty = ? WHERE pid = ?";
					 statement = connection.prepareStatement(sql);
					 statement.setInt(1, qty);
					 statement.setInt(2, id);
					  rowsAffected = statement.executeUpdate();
					 if (rowsAffected > 0) {
			                System.out.println("Product name updated successfully.");
			            } else {
			                System.out.println("Product not found or update failed.");
			            }
					
				break;
				case 3: 
					System.out.println("Enter the new price");
					price=sc.nextInt();
					System.out.println("enter the id for which you want to change the price");
					id=sc.nextInt();
					  sql = "UPDATE product SET price = ? WHERE pid = ?";
					 statement = connection.prepareStatement(sql);
					 statement.setInt(1, price);
					 statement.setInt(2, id);
					  rowsAffected = statement.executeUpdate();
					 if (rowsAffected > 0) {
			                System.out.println("Product name updated successfully.");
			            } else {
			                System.out.println("Product not found or update failed.");
			            }
					
				break;
				
				}
				System.out.println("Do you want to continue");
				ans=sc.next();
				
			}while(ans.equals("y")||ans.equals("Y"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
			statement.close();
		}
		return true;
	}


	
}
