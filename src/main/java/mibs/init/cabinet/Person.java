package mibs.init.cabinet;

public class Person implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String serName;
	private String dateOfBirth;
	private String emeil;
	public Person(String firstName, String lastName, String serName, String dateOfBirth, String emeil) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.serName = serName;
		this.dateOfBirth = dateOfBirth;
		this.emeil = emeil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSerName() {
		return serName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public String getEmeil() {
		return emeil;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", serName=" + serName + ", dateOfBirth="
				+ dateOfBirth + ", emeil=" + emeil + "]";
	}
	
	
	

}
