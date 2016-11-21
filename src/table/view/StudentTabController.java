package table.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import table.Convert;
import table.Database;
import table.Student;

public class StudentTabController extends Convert implements Initializable{
	@FXML 
	private TableView<Student> StudentTable;
    @FXML 
    private TableColumn<Student, String> StudentFirstName;
    @FXML 
    private TableColumn<Student, String> StudentLastName;
    @FXML 
    private TableColumn<Student, Integer> StudentNumber;
    @FXML
    private TableColumn<Student, ImageView> StudentImage;
    @FXML
    private TableColumn<Student,Timestamp > StudentTime;
    private ObservableList<Student> data;
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
			ResultSet rs = conn.createStatement().executeQuery("SELECT firstname,lastname,studentnumber, image,timestamp FROM students");
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println("Hello");
				System.out.println(rs.getString(3));
				Image image = convert(rs.getBytes(4), 300, 300);
				ImageView imageview = new ImageView(image);
				imageview.setFitHeight(100);
				imageview.setFitWidth(100);
				data.add(new Student(rs.getString(1),rs.getString(2),rs.getInt(3), imageview,rs.getTimestamp(5)));
			}
		}catch(SQLException ex){
			System.err.println("Error"+ex);
		}
	

		StudentFirstName.setCellValueFactory(new PropertyValueFactory<Student,String>("FirstName"));
		StudentLastName.setCellValueFactory(new PropertyValueFactory<Student,String>("LastName"));
		StudentNumber.setCellValueFactory(new PropertyValueFactory<Student,Integer>("StudentNumber"));
		StudentImage.setCellValueFactory(new PropertyValueFactory<Student,ImageView>("Image"));
		StudentTime.setCellValueFactory(new PropertyValueFactory<Student,Timestamp>("Time"));
		StudentTable.setItems(null);
		StudentTable.setItems(data);
	}
    
    
    
}
