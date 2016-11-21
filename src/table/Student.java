package table;

import java.sql.Timestamp;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class Student {
	public final SimpleStringProperty FirstName;
	public final SimpleStringProperty LastName;
	public final SimpleIntegerProperty StudentNumber;
	public final ImageView QueriedImage;
	public final Timestamp Time;
	
	public Student(String firstname, String lastname, int studentnumber, ImageView imageview,Timestamp time){
		super();
		this.FirstName = new SimpleStringProperty(firstname);
		this.LastName = new SimpleStringProperty(lastname);
		this.StudentNumber = new SimpleIntegerProperty(studentnumber);
		this.QueriedImage = imageview;
		this.Time=time;
	}

	public String getFirstName() {
		return FirstName.get();
	}

	public String getLastName() {
		return LastName.get();
	}

	public int getStudentNumber() {
		return StudentNumber.get();
	}	
	
	public ImageView getImage(){
		return QueriedImage;
	}
	public Timestamp getTime(){
		return Time;
	}
}
