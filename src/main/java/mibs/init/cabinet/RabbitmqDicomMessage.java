package mibs.init.cabinet;


public class RabbitmqDicomMessage  implements java.io.Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private byte[] payload ;
	
	public RabbitmqDicomMessage(String fileName, byte[] payload)  {
		this.fileName = fileName;
		this.payload = payload;
	}
	public byte[] getPayload() {
		
		return this.payload;
		
	}
	public String getFileName() {
		
		return this.fileName;
		
	}
	
	
	
	
}
