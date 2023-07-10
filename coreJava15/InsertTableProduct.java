package coreJava15;
import java.util.*;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTableProduct {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement statement=null;
		NumberRegEx obj=new NumberRegEx();
	
		try {
			String  pid="", pqty="", price="";
			String pName="";
			int recordNum=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDb?useSSL=false","root","Hogwards4340$");
			if(con==null) {
				System.out.println("Connection failed");
				
			}else {
				System.out.println("Success... Connected with Oracle DB");
			}
			statement=con.createStatement();
			Scanner sc=new Scanner(System.in);
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
				int res=statement.executeUpdate(query);
				if(res==0) {
					System.out.println("Failed to inser the records");
				}else {
					System.out.println("Resord inserted successfully");
				}
				System.out.println("-------------------------------------------");
			}
			System.out.println(recordNum+ " "+"records inserted successfully");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			statement.close();
		}
		
	}

}
