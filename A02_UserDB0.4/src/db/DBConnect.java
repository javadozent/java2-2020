package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import util.Util;

public final class DBConnect {// final -> Vererbung ausschalten

	private static DBConnect instance = null;
	private Connection con;
	
	private Properties p = Util.getProperties("/resources/app.properties");

	private DBConnect() throws DBException {

		try {
			con = DriverManager.getConnection(p.getProperty("host"), p.getProperty("username"), p.getProperty("password"));
			
			
		} catch (SQLException e) {
			//Log.error..
			throw  new DBException();
			//e.printStackTrace();
		}

	}

	public synchronized static DBConnect getInstance() throws DBException {// DBConnect.getIntsance(), synchronized==Threadsicher
		if (instance == null) {
			instance = new DBConnect();
		}

		return instance;
	}

	public Connection getCon() {
		return con;
	}

}
