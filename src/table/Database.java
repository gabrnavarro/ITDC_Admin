package table;

import java.sql.*;

public class Database {
	public Connection db = null;
	
	public Connection Connect(){
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		try {
			String url = "jdbc:postgresql:login";
			String username = "postgres";
			String password = "postgresql";
			db = DriverManager.getConnection(url, username, password);
			

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (db != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return db;
	}
	
	

}