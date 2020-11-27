package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java2?serverTimezone=UTC", "root","");
				
				// select all
				
				
				System.out.println("DB connect...");
				Statement selectStatement = con.createStatement();
				ResultSet rs = selectStatement.executeQuery("SELECT * FROM farben");
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String hex = rs.getString("hex");
					
					System.out.printf("%d %s %s\n",id,name,hex);
				}
				
				
				
				// insert
				Statement  insertStatement = con.createStatement();
				
				int n = insertStatement.executeUpdate("INSERT INTO farben(name,hex) VALUES('blau', '#0000ff')   ");// INSERT, DELETE, UPDATE
				System.out.println("INSERT: "+n);
				
				
				// delete
				PreparedStatement deleteStatment = con.prepareStatement("DELETE FROM farben WHERE name =?");
				deleteStatment.setString(1, "blau");// 1 == erstes Fragezeichen
				int x = deleteStatment.executeUpdate();
				System.out.println("DELETE: "+ x);
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
