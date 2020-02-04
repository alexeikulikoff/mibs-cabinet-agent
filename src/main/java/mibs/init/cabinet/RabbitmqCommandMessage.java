package mibs.init.cabinet;

public class RabbitmqCommandMessage<T> implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String command;
	private String routingKey;
	private T content;
	public RabbitmqCommandMessage(String command,  T content) {
		super();
		this.command = command;
		this.content = content;
	}
	public String getCommand() {
		return command;
	}
	public T getContent() {
		return content;
	}
	
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	@Override
	public String toString() {
		return "RabbitmqCommandMessage [command=" + command + ", routingKey=" + routingKey + ", content=" + content
				+ "]";
	}


	
}
