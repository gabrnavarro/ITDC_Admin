package table;

public class Visitor {
	public String FirstName;
	public String LastName;
	public String MiddleName;
	public String Purpose;
	public String Organization;
	public String Office;
	public Byte Image;
	
	Visitor(String fn, String ln, String mn, String pr, String or, String of, Byte img){
		FirstName = fn;
		LastName = ln;
		MiddleName = mn;
		Purpose = pr;
		Organization = or;
		Office = of;
		Image = img;
	}

}
