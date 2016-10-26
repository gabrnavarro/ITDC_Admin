package table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	public final SimpleStringProperty FirstName;
	public final SimpleStringProperty LastName;
	public final SimpleIntegerProperty StudentNumber;
	//public final Byte Image;
	
	public Student(String firstname, String lastname, int studentnumber/*, Byte img*/){
		super();
		this.FirstName = new SimpleStringProperty(firstname);
		this.LastName = new SimpleStringProperty(lastname);
		this.StudentNumber = new SimpleIntegerProperty(studentnumber);
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
