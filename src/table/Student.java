package table;

public class Student {
	public String FirstName;
	public String LastName;
	public int StudentNumber;
	public Byte Image;
	
	public Student(String firstname, String lastname, int studentnumber/*, Byte img*/){
		this.FirstName = firstname;
		this.LastName = lastname;
		this.StudentNumber = studentnumber;
		//Image = img;
	}
}
