package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
	
	
	private Util() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * e.g. Util.getProperties(PFAD).get(username)->root
	 */
	public static Properties getProperties(String path) {
		Properties p = new Properties();
		try {
			p.load(Util.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}
	
	
	/**
	 * 
	 * @param path aauﬂerhalb der Pakete (Filesystem)
	 * @return
	 */
	public static Properties getPropertiesFromFileSystem(String path) {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File(path)));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return p;
	}
	
	public static void main(String[] args) {
		System.out.println(Util.getProperties("/resources/app.properties").get("host"));
	}

}
