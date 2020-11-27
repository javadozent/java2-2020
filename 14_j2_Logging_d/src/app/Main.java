package app;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static Logger log = LogManager.getRootLogger();
	
	public static void main(String[] args) {
		log.info("App start");
		A a = new A();
		
		a.m1(3);
		a.m2(-3);
		a.m3(null);
	

		
		
		log.info("App end");
	}

}
