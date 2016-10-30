package table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class Student {
	public final SimpleStringProperty FirstName;
	public final SimpleStringProperty LastName;
	public final SimpleIntegerProperty StudentNumber;
	public final Image QueriedImage;
	//public final Byte Image;
	
	public Student(String firstname, String lastname, int studentnumber, Image img){
		super();
		this.FirstName = new SimpleStringProperty(firstname);
		this.LastName = new SimpleStringProperty(lastname);
		this.StudentNumber = new SimpleIntegerProperty(studentnumber);
		this.QueriedImage = img;
		//Image = img;
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
}
