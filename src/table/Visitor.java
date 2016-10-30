package table;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class Visitor {
	public final SimpleStringProperty FirstName;
	public final SimpleStringProperty LastName;
	public final SimpleStringProperty MiddleName;
	public final SimpleStringProperty Purpose;
	public final SimpleStringProperty Organization;
	public final SimpleStringProperty Office;
	public final Image QueriedImage;
	//public final Byte Image;
	
	public Visitor(String fn, String ln, String mn, String pr, String or, String of, Image img){
		super();
		this.FirstName = new SimpleStringProperty(fn);
		this.LastName = new SimpleStringProperty(ln);
		this.MiddleName = new SimpleStringProperty(mn);
		this.Purpose = new SimpleStringProperty(pr);
		this.Organization = new SimpleStringProperty(or);
		this.Office = new SimpleStringProperty(of);
		this.QueriedImage = img;
		//Image = img;
	}

	public String getFirstName() {
		return FirstName.get();
	}

	public String getLastName() {
		return LastName.get();
	}

	public String getMiddleName() {
		return MiddleName.get();
	}

	public String getPurpose() {
		return Purpose.get();
	}

	public String getOrganization() {
		return Organization.get();
	}

	public String getOffice() {
		return Office.get();
	}

}
