package mibs.init.cabinet;

import java.io.Serializable;

public class Exploration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String uniqueID ;
	private String folderName;
	public Exploration(String email, String uniqueID, String folderName) {
		super();
		this.email = email;
		this.uniqueID = uniqueID;
		this.folderName = folderName;
	}
	public String getEmail() {
		return email;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public String getFolderName() {
		return folderName;
	}
	
}
