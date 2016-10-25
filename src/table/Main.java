package table;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane mainLayout;
	
	/* @FXML private TableView<Student> tableView;
	    @FXML private TableColumn<Student, String> StudentFirstName;
	    @FXML private TableColumn<Student, String> StudentLastName;
	    @FXML private TableColumn<Student, Integer> StudentNumber;
*/
	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Table App");
		showMainView();
		
	}
	
	private void showMainView() throws IOException, SQLException {
		FXMLLoader loader = new FXMLLoader();
		Database DBManager = new Database();
		DBManager.initialize();
		
		//get data. trial palang. place return values and put into arrays then iterate into table view.
		DBManager.getStudents();
		DBManager.getVisitors();
		
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
