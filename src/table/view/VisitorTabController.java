package table.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import table.Visitor;

public class VisitorTabController extends Convert implements Initializable{
	@FXML 
	private TableView<Visitor> VisitorTable;
    @FXML 
    private TableColumn<Visitor, String> VisitorFirstName;
    @FXML 
    private TableColumn<Visitor, String> VisitorLastName;
    @FXML 
    private TableColumn<Visitor, String> VisitorMiddleName;
    @FXML 
    private TableColumn<Visitor, String> VisitorPurpose;
    @FXML 
    private TableColumn<Visitor, String> VisitorOrganization;
    @FXML 
    private TableColumn<Visitor, String> VisitorDes;
    @FXML 
    private TableColumn<Visitor, String> VisitorOffice;
    @FXML
    private TableColumn<Visitor, ImageView> VisitorImage;
    @FXML
    private TableColumn<Visitor,Timestamp > VisitorTime;
    
    private ObservableList<Visitor> data;
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
			ResultSet rs = conn.createStatement().executeQuery("SELECT firstname,lastname,middlename, purpose,organization,office, image,timestamp FROM visitors");
			while(rs.next()){
				byte[] rawimage = rs.getBytes(7);
				Image image = convert(rawimage, 300, 300);
				ImageView imageview= new ImageView(image);
				imageview.setFitHeight(100);
				imageview.setFitWidth(100);
				data.add(new Visitor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), imageview,rs.getTimestamp(8)));
			}
		}catch(SQLException ex){
			System.err.println("Error"+ex);
		}
	

		VisitorFirstName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("FirstName"));
		VisitorLastName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("LastName"));
		VisitorMiddleName.setCellValueFactory(new PropertyValueFactory<Visitor,String>("MiddleName"));
		VisitorPurpose.setCellValueFactory(new PropertyValueFactory<Visitor,String>("Purpose"));
		VisitorOrganization.setCellValueFactory(new PropertyValueFactory<Visitor,String>("Organization"));
		VisitorOffice.setCellValueFactory(new PropertyValueFactory<Visitor,String>("Office"));
		VisitorImage.setCellValueFactory(new PropertyValueFactory<Visitor,ImageView>("Image"));
		VisitorTime.setCellValueFactory(new PropertyValueFactory<Visitor,Timestamp>("Time"));
		VisitorTable.setItems(null);
		VisitorTable.setItems(data);
	}
    
    
    
}
