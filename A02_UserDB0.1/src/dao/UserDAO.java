package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	List<User> findAll();
	boolean save(User u);
	
	boolean delete(int id);
	boolean update(String field, String newValue, int id);

}
