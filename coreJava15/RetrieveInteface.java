package coreJava15;

import java.sql.SQLException;
import java.util.Scanner;

interface RetrieveInteface {
	boolean  retriveAllData(Scanner sc,JdbcDatabaseConnection con);
	boolean retriveSpecificData(Scanner sc,JdbcDatabaseConnection con)throws SQLException;
}
