package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=tvtfitness";
	private static String userName = "hien";
	private static String password = "1234";
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static Connection connection;

	public static Connection getConnect() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection falure");
		} 
		return connection;
	}

}
