package coreJava15;

import java.sql.SQLException;
import java.util.Scanner;

interface UpdateInterface {
	boolean updateData(Scanner sc,JdbcDatabaseConnection con) throws SQLException;
	
}
