package ui.controller;

import dao.FarbeDAO;
import dao.FarbeSqlDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Farbe;

public class FarbenController {
	// Member
	private FarbeDAO dao;

	
	// FXML
	@FXML
	private TableView<Farbe> tableView;
	@FXML
	private TableColumn<Farbe, Integer> idCol;
	@FXML
	private TableColumn<Farbe, String> nameCol;
	@FXML
	private TableColumn<Farbe, String> hexWertCol;
	@FXML
	private TextField farbeField;
	@FXML
	private TextField hexField;

	@FXML
	void initialize() {
		System.out.println("init...");
		dao = new FarbeSqlDao();
		// dao = new FarbeDummyDAO();
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		hexWertCol.setCellValueFactory(new PropertyValueFactory<>("hex"));

		tableView.setItems(FXCollections.observableArrayList(dao.findAll()));

	}

	@FXML
	void onDelete(ActionEvent event) {
		System.out.println("onDelete...");
		Farbe farbe = tableView.getSelectionModel().getSelectedItem();
		boolean deleted = dao.delete(farbe.getId());
		System.out.println("onDelete:deleted: "+deleted);
		if(deleted) {
			tableView.getItems().remove(farbe);
		}
	}

	@FXML
	void onSave(ActionEvent event) {
		System.out.println("onSave...");
		boolean saved = dao.save(new Farbe( farbeField.getText(), hexField.getText()));
		if(saved) {
			tableView.setItems(FXCollections.observableArrayList(dao.findAll()));
		}
	}

}
