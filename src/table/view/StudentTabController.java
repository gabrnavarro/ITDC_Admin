package table.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import table.Database;
import table.Student;

public class StudentTabController implements Initializable{
	@FXML 
	private TableView<Student> StudentTable;
    @FXML 
    private TableColumn<Student, String> StudentFirstName;
    @FXML 
    private TableColumn<Student, String> StudentLastName;
    @FXML 
    private TableColumn<Student, Integer> StudentNumber;
    public ObservableList<Student> data;
    private Database dc;
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO 
		loadDataFromDataBase();
			
	}
	@FXML 
	private void loadDataFromDataBase(){
		dc = new Database();
		try{
			Connection conn = dc.Connect();
			data = FXCollections.observableArrayList();
			ResultSet rs = conn.createStatement().executeQuery("SELECT firstname,lastname,studentnumber FROM students");
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				data.add(new Student(rs.getString(1),rs.getString(2),rs.getInt(3)));
			}
		}catch(SQLException ex){
			System.err.println("Error"+ex);
		}
		StudentFirstName.setCellValueFactory(new PropertyValueFactory<Student,String>("StudentFirstName"));
		StudentLastName.setCellValueFactory(new PropertyValueFactory<Student,String>("StudentLastName"));
		StudentNumber.setCellValueFactory(new PropertyValueFactory<Student,Integer>("StudentNumber"));
		StudentTable.setItems(null);
		StudentTable.setItems(data);
	}
    
    
    
}
