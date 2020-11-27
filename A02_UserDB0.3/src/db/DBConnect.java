package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnect {// final -> Vererbung ausschalten

	private static DBConnect instance = null;
	private Connection con;

	private DBConnect() throws DBException {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/java2?serverTimezone=UTC", "root", "");
			
			
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
