package coreJava15;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public interface InsertDataInterface {
	boolean inserData(String userName, String password,Scanner sc) throws SQLException;
}
