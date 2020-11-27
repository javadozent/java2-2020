package application;

import dao.FarbeDAO;
import dao.FarbeSqlDao;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Farbe;
import javafx.scene.control.TableColumn;

public class FarbenController {
	@FXML
	private TableView<Farbe> tableView;
	@FXML
	private TableColumn<Farbe,Integer> idCol;
	@FXML
	private TableColumn<Farbe,String> nameCol;
	@FXML
	private TableColumn<Farbe,String> hexWertCol;
	
	private FarbeDAO dao;
	
	@FXML
	void initialize() {
		System.out.println("init...");
		dao = new FarbeSqlDao();
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		hexWertCol.setCellValueFactory(new PropertyValueFactory<>("hex"));
		
		
		tableView.setItems(FXCollections.observableArrayList(dao.findAll()));
		
	}

}
