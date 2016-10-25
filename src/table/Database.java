package table;
import java.io.*;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Database {
	public Connection db = null;
	
	public void initialize(){
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

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
			return;

		}

		if (db != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public void getStudents() throws SQLException{
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Students");
		while (rs.next())
		{
		   System.out.print("Column 1 returned ");
		   System.out.println(rs.getString(1));
		   System.out.println(rs.getString(2));
		   System.out.println(rs.getInt(3));
		} rs.close();
		st.close();
		
	}
	
	public void getVisitors() throws SQLException{
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM Visitors");
		while (rs.next())
		{
		   System.out.print("Column 1 returned ");
		   System.out.println(rs.getString(1)); //prints out query strings
		   System.out.println(rs.getString(2));
		   System.out.println(rs.getString(3));
		   byte[] image = rs.getBytes(8);  	//gets the images in byte form. find a way to display the bytes using fxml
		} rs.close();
		st.close();
		
	}

}