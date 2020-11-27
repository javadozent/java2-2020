package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import model.User;

public class UserSQLDAO implements UserDAO {

	private Connection con = DBConnect.getInstance().getCon();

	@Override
	public List<User> findAll() {
		ArrayList<User> list = new ArrayList<>();

		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				int id = rs.getInt("id");
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");
				String email = rs.getString("email");
				Date geburtsdatum = rs.getDate("geburtsdatum");
				list.add(new User(id, vorname, nachname, email, geburtsdatum.toLocalDate()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean save(User u) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user(vorname,nachname,email, geburtsdatum) VALUES (?,?,?,?) ");
			ps.setString(1, u.getVorname());
			ps.setString(2, u.getNachname());
			ps.setString(3, u.getEmail());
			
			
			ps.setDate(4, Date.valueOf(u.getGeburtsdatum()));//LocalDate zu sql.Date konvertieren 
			return ps.executeUpdate()==1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String field, String newValue, int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static void main(String[] args) {
		UserSQLDAO dao = new UserSQLDAO();
		System.out.println(dao.findAll());
	}

}
