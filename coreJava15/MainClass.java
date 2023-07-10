package coreJava15;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String choice="";
		String userName="", password="",ans="";
		JdbcDatabaseConnection connection=null;
		RetrieveDataOperation retrieve=null;
		InsertDataOperation insert=null;
		Statement statement=null;
		CRUDOperations createobj=null;
		UpdateDataBaseOperation update=null;
		NumberRegEx regEx=new NumberRegEx();
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Menu");
		System.out.println("1.Create");
		System.out.println("2.Insert");
		System.out.println("3.Retrieve All data");
		System.out.println("4.Retrieve specific data");
		System.out.println("5.Update data");
		
		do {
			System.out.println("Enter choice");
			try {
			choice=sc.next();

			}catch(InputMismatchException e) {
				System.out.println("Enter numbers only");
				sc.next();
				choice=sc.next();
			}
		}while(!regEx.isValid(choice));
			switch(choice) {
			case "1":
				createobj=new CRUDOperations();
				if(!createobj.createTable()) {
					System.out.println("Failed to create table");
				}
			break;
			case "2":
				insert=new InsertDataOperation();
				if(!insert.inserData(sc)) {
					System.out.println("Failed to insert");
				}
				break;
			case "3":
				retrieve=new RetrieveDataOperation();
				if(!retrieve.retriveAllData(sc)) {
					System.out.println("Failed to retrieve");
				}
				
				break;
			case "4": 
				retrieve=new RetrieveDataOperation();
				if(!retrieve.retriveSpecificData(sc)) {
					System.out.println("Failed to retrieve");
				}
				break;
			case "5":
				update=new UpdateDataBaseOperation();
				if(! update.updateData(sc)) {
					System.out.println("Failed to update");
				}
				break;
				
			}

		System.out.println("Do you want to continue for main menu?");
		ans=sc.next();
		}while(ans.equals("Y")||ans.equals("y"));
	}

}
