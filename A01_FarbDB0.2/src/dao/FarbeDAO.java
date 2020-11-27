package dao;

import java.util.List;

import model.Farbe;

public interface FarbeDAO {
	
	List<Farbe> findAll();
	boolean save(Farbe farbe);
	boolean delete(int id);

}
