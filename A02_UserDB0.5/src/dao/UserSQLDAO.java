package dao;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import db.DBConnect;
import db.DBException;
import model.User;
import util.Util;

public class UserSQLDAO implements UserDAO {

	private Connection con;
	private Properties p = Util.getProperties("/resources/app.properties");

	public UserSQLDAO() throws DBException {
		con = DBConnect.getInstance().getCon();
	}

	@Override
	public List<User> findAll() {
		ArrayList<User> list = new ArrayList<>();

		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM user");
			fillResultList(list, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean save(User u) {
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO user(vorname,nachname,email, geburtsdatum) VALUES (?,?,?,?) ");
			ps.setString(1, u.getVorname());
			ps.setString(2, u.getNachname());
			ps.setString(3, u.getEmail());

			ps.setDate(4, Date.valueOf(u.getGeburtsdatum()));// LocalDate zu sql.Date konvertieren
			return ps.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// delete

		try {
			PreparedStatement deleteStatment = con.prepareStatement("DELETE FROM user WHERE id =?");
			deleteStatment.setInt(1, id);
			System.out.println(deleteStatment);
			return deleteStatment.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean deleteAll() {
		// delete

		try {
			PreparedStatement deleteStatment = con.prepareStatement("DELETE FROM user");
			System.out.println(deleteStatment);
			return deleteStatment.executeUpdate() == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(String field, String newValue, int id) {
		// update
		try {
			PreparedStatement updateStatement = con.prepareStatement("UPDATE user SET "+field +"=? WHERE id=? ");
			updateStatement.setString(1,newValue);
			updateStatement.setInt(2,id);
			updateStatement.executeUpdate();
			return updateStatement.getUpdateCount() == 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public static void main(String[] args) {
		// UserSQLDAO dao = new UserSQLDAO();
		// System.out.println(dao.findAll());
	}

	
	//FIXME
	@Override
	public List<User> find(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> find(String field, String text) {
		ArrayList<User> list = new ArrayList<>();
		try {
			
			//System.out.println(field +" "+text);
			String q = "SELECT * FROM user WHERE " + p.get(field) + " LIKE ?";
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, text+"%");
			ResultSet rs =    ps.executeQuery();
			fillResultList(list, rs);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private void fillResultList(ArrayList<User> list, ResultSet rs) throws SQLException {
		//assert(list!=null);
		while (rs.next()) {
			int id = rs.getInt("id");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			String email = rs.getString("email");
			Date geburtsdatum = rs.getDate("geburtsdatum");
			list.add(new User(id, vorname, nachname, email, geburtsdatum.toLocalDate()));
		}
	}

}
