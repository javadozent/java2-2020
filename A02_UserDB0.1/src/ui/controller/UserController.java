package ui.controller;

import java.time.LocalDate;

import dao.UserSQLDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;

public class UserController {
	
	private UserSQLDAO dao;

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<User, Integer> idCol;

    @FXML
    private TableColumn<User, String> vornameCol;

    @FXML
    private TableColumn<User, String> nachnameCol;

    @FXML
    private TableColumn<User, String> emailCol;

    @FXML
    private TableColumn<User, LocalDate> gebCol;

    @FXML
    private TextField nachnameField;

    @FXML
    private DatePicker gebField;

    @FXML
    private TextField vornameField;

    @FXML
    private TextField emailfield;

    @FXML
    private Label infoLabel;


    @FXML
    void initialize() {
    	System.out.println("init...");
    	dao = new UserSQLDAO();
    	idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
    	nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	gebCol.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
    	userTableView.setItems(FXCollections.observableArrayList(dao.findAll()));

    }
    
    @FXML
    void onRefresh(ActionEvent event) {
    	userTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
    }

    @FXML
    void onSave(ActionEvent event) {
    	
    	dao.save(new User(vornameField.getText(), nachnameField.getText(), emailfield.getText(), gebField.getValue()));

    }

}
