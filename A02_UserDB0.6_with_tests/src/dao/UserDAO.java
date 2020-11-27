package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	
	
	/**
	 * 
	 * @return ArrayList with Userobjects or empty ArrayList Object
	 */
	List<User> findAll();
	boolean save(User u);
	
	boolean delete(int id);
	boolean update(String field, String newValue, int id);
	
	List<User> find(String field, String text);
	List<User> find(String text);
	boolean deleteAll();

}
