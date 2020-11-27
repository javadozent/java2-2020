package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import db.DBConnect;
import model.Farbe;

public class FarbeSqlDao implements FarbeDAO{
	
	private Connection con = DBConnect.getInstance().getCon();

	@Override
	public List<Farbe> findAll() {
		ArrayList<Farbe> list = new ArrayList<>();
		
		try {
			Statement  statement = con.createStatement();
			ResultSet rs =  statement.executeQuery("SELECT * FROM farben");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String hex = rs.getString("hex");
				list.add(new Farbe(id, name, hex));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean save(Farbe farbe) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO farben(name,hex) VALUES (?,?) ");
			ps.setString(1, farbe.getName());
			ps.setString(2, farbe.getHex());
			return ps.executeUpdate()==1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// delete
		
		try {
			PreparedStatement deleteStatment = con.prepareStatement("DELETE FROM farben WHERE id =?");
			deleteStatment.setInt(1, id);
			System.out.println(deleteStatment);
			return deleteStatment.executeUpdate()==1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
