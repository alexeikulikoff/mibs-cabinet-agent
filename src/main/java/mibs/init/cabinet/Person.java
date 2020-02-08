package mibs.init.cabinet;

import java.time.LocalDate;
import org.apache.commons.validator.routines.EmailValidator;

public class Person   implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String patronymic;
	private LocalDate dateOfBirth;
	private String email;
	
	public Person(String firstName, String lastName, String patronymic, LocalDate dateOfBirth, String email) {
		super(  );
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
/*		
		boolean isValid = EmailValidator.getInstance().isValid(email);
		if (isValid) {
			this.email = email.toLowerCase();
		}else {
			throw new IllegalArgumentException( "Email " + email + " is incorrect!"  );	
		}
*/		
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getPatronymic() {
		return this.patronymic;
	}
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	public String getEmail() {
		return this.email;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName + ", patronymic=" + this.patronymic + ", email=" + this.email + "]";
	}

}
