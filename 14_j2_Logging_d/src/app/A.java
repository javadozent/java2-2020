package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class A {
	
	private static Logger log = LogManager.getLogger();// Logger heist app.A

	
	public void m1(int a) {
		int b = 4;
		log.debug(a);
		log.trace(b);
		
	}
	
	
	public void m2(int temperatur) {
		if(temperatur < 0) {
			log.warn("Temperatur zu niedrig {} {}",temperatur, "weitere infos...");
		}
	}
	
	public void m3(String s) {
		try {
			s.chars();
		} catch (Exception e) {
			log.error(e);
		}
		
	}
}
