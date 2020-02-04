package mibs.init.cabinet;

public class Responce implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;

	public Responce(String result) {
		super();
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "Responce [result=" + result + "]";
	}
	
}
