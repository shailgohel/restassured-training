import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggingClass {
	
	public static void main(String[] args) {
		
		final Logger logger = Logger.getLogger(LoggingClass.class);

		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("This is INFO log");
		logger.warn("This is a warning log");
		
		
		logger.error("This is n ERROR log");
		logger.info("This is a DEBUG log");
		
		
		
		
		System.out.println("Hello World");
	}
}
