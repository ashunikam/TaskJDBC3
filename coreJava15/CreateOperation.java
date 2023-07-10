package coreJava15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOperation implements CreateTableInterface{
	private Connection connection;
	public CreateOperation(Connection connection) {
        this.connection = connection;
    }
	@Override
	public void createTable(String tableName, String[] columns) {
		// TODO Auto-generated method stub
		StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("CREATE TABLE ").append(tableName).append(" (");
        for (int i = 0; i < columns.length; i++) {
            queryBuilder.append(columns[i]);
            if (i != columns.length - 1) {
                queryBuilder.append(", ");
            }
        }
        queryBuilder.append(")");

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(queryBuilder.toString());
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
