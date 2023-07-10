package coreJava15;

import java.sql.SQLException;
import java.util.Scanner;

interface RetrieveInteface {
	boolean  retriveAllData(Scanner sc);
	boolean retriveSpecificData(Scanner sc)throws SQLException;
}
