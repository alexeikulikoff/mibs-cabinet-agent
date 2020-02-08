package mibs.init.cabinet;

import java.io.Serializable;
import java.util.Arrays;

public class Conclusion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String conclusionName;
	private byte[] conclusionContent;
	private String uniqueID;
	public Conclusion(String email, String conclusionName, byte[] conclusionContent, String uniqueID) {
		super();
		this.email = email;
		this.conclusionName = conclusionName;
		this.conclusionContent = conclusionContent;
		this.uniqueID = uniqueID;
	}
	public String getEmail() {
		return email;
	}
	public String getConclusionName() {
		return conclusionName;
	}
	public byte[] getConclusionContent() {
		return conclusionContent;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	@Override
	public String toString() {
		return "Conclusion [email=" + email + ", conclusionName=" + conclusionName + ", conclusionContent="
				+ Arrays.toString(conclusionContent) + ", uniqueID=" + uniqueID + "]";
	}
	
}
