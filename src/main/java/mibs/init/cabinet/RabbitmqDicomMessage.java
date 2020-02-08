package mibs.init.cabinet;


public class RabbitmqDicomMessage  implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String explorationID;
	
	private byte[] payload ;
	
	public RabbitmqDicomMessage(String fileName, byte[] payload , String explorationID)  {
		this.fileName = fileName;
		this.payload = payload;
		this.explorationID  = explorationID;
	}
	public byte[] getPayload() {
		
		return this.payload;
		
	}
	public String getFileName() {
		
		return this.fileName;
		
	}
	public String getExplorationID() {
		return this.explorationID;
	}
	
	
	
	
}
