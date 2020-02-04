package mibs.init.cabinet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.function.Consumer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rabbitmq.client.Channel;

public abstract class Actions implements Cabinet{
	private static final Logger logger = LogManager.getLogger(Actions.class.getName());
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss d MMM uuuu");
	
	protected String rabbitmqHost;
	protected String rabbitmqLogin;
	protected String rabbitmqPassword;
	
	
	protected String directExchange;
	protected String masterRoutingKey;
	protected String localRoutingKey;
	protected String inboundQueue;
	protected String localInQueue;
	protected String localOutQueue;
	
	protected Channel channel = null;
	
	
	protected Map< String, Consumer< RabbitmqCommandMessage< ? > > > commands ;
	
	
	protected  void initConfig(String conf) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream(conf)) {
			props.load(fis);
			rabbitmqHost =  props.getProperty("rabbitmq-host");
			rabbitmqLogin = props.getProperty("rabbitmq-login");
			rabbitmqPassword = props.getProperty("rabbitmq-password");
			directExchange = props.getProperty("direct-exchange");
			masterRoutingKey = props.getProperty("master-routing-key");
			localRoutingKey =  props.getProperty("local-routing-key");
			inboundQueue = props.getProperty("inboundQueue");
			localInQueue   = props.getProperty("localInQueue");
			localOutQueue   = props.getProperty("localOutQueue");
			logger.trace("Application started at " + formatter.format(LocalDateTime.now()));
		}
	}

	public Actions(String conf) {
		
		try {
			initConfig(conf);
		} catch (FileNotFoundException e) {
			logger.error("Error! Configuration file not found!");
			exit();
		} catch (IOException e) {
			logger.error("Error! IO Exception with message: " + e.getMessage());
			exit();
		}
		
		commands = new TreeMap<>();
		commands.put(CMD_INIT_CABINET, ( u ) -> {
			u.setRoutingKey( localRoutingKey );
			byte[] rc = SerializationUtils.serialize ( u );
			try {
				channel.basicPublish( directExchange, masterRoutingKey, true, null, rc );
				logger.trace("Public to exchange " + directExchange + " message:  " + u);
			} catch (IOException e) {
				logger.error("Error! Public to queue localin failed with message: " + e.getMessage());
			}
		});
		commands.put(CMD_INITIALIZED,  ( u )->{
			byte[] rc = SerializationUtils.serialize ( u );
			try {
				channel.basicPublish( "", localOutQueue , true, null, rc );
				logger.trace("Public to queue " + localOutQueue + " message:  " + u);
			} catch (IOException e) {
				logger.error("Error! Public to queue localin failed with message: " + e.getMessage());
			}
		});
		
	}
	
	protected static void exit() {
		logger.info("Application exit at " + formatter.format(LocalDateTime.now()));
		System.exit(0);
	}
}
