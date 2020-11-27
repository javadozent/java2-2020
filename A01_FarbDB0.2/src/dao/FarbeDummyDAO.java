package dao;

import java.util.Arrays;
import java.util.List;

import model.Farbe;

public class FarbeDummyDAO implements FarbeDAO{

	@Override
	public List<Farbe> findAll() {
		List<Farbe> farben =  Arrays.asList(new Farbe(1, "schwarz", "#000000"));  //List.of() ab14
		return farben;
	}

	@Override
	public boolean save(Farbe farbe) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return true;
	}

}
