package ui.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import dao.UserSQLDAO;
import db.DBException;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;
import model.User;
import util.Validator;

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

	@FXML private ComboBox<String> searchComboBox;

	@FXML private TextField searchField;


    @FXML
    void initialize() {
    	
//    	User u = new User();
//    	u.vonameProperty().addListener( (a,b,newValue) ->{
//    		
//    	});
//    	
    	System.out.println("init...");
    	try {
			dao = new UserSQLDAO();
			setupTableView();
			setupContextMenu();
			setupComboBox();
		} catch (DBException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Keine Connetion zur Datenbank! Bitte Verbindung herstellen\n und App neu starten.");
			alert.showAndWait();
			Platform.exit();
		}

    	
    	// ChangeListener
    	vornameField.textProperty().addListener( (a,b,newValue) ->{
    		
    		System.out.println(newValue);
    	}   );
    }

	private void setupComboBox() {
		searchComboBox.setItems(FXCollections.observableArrayList("Vorname","Nachname","E-Mail") );
		searchField.textProperty().addListener( (a,b,newValue)->{
			List<User> users = dao.find(searchComboBox.getSelectionModel().getSelectedItem(), searchField.getText());
			userTableView.setItems(FXCollections.observableArrayList(users));
		} );
	}

	private void setupContextMenu() {
		// ContextMenu -Delete
    	ContextMenu cm = new ContextMenu();
    	MenuItem deleteItem = new MenuItem("Delete");
    	deleteItem.setOnAction( e->{
    		
    		User u = userTableView.getSelectionModel().getSelectedItem();
    		boolean delted = dao.delete(u.getId());
			if(delted ) {
    			userTableView.getItems().remove(u);
    			setInfoMsg("Datensatz gel�scht! id: "+u.getId());
    		}
    	} );
    	cm.getItems().add(deleteItem);
    	userTableView.setContextMenu(cm);
	}

	private void setupTableView() {
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
    	nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	gebCol.setCellValueFactory(new PropertyValueFactory<>("geburtsdatum"));
    	userTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
    	
    	// Zellen editierbar machen
    	vornameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	nachnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
	}
    
    @FXML
    void onRefresh(ActionEvent event) {
    	userTableView.setItems(FXCollections.observableArrayList(dao.findAll()));
    }

    @FXML
    void onSave(ActionEvent event) {
    	valid();
    	boolean saved = dao.save(new User(vornameField.getText(), nachnameField.getText(), emailfield.getText(), gebField.getValue()));
    	if(saved) {
    		setInfoMsg("Datensatz gespeichert!");
    	}

    }

	private void valid() {
		if(!Validator.validateLength(emailfield.getText(), 7, 30)){
    		setInfoMsg("ung�ltige L�nge");
    		return;
    	}
    	
    	
    	if(!Validator.validateEMail(emailfield.getText())){
    		setInfoMsg("ung�ltige E-Mail!");
    		return;
    	}
	}

	private void setInfoMsg(String msg) {
		infoLabel.setOpacity(1);
		FadeTransition fade = new FadeTransition(Duration.seconds(1),infoLabel);
		fade.setDelay(Duration.seconds(4));
		fade.setToValue(0);
		infoLabel.setText(msg);
		fade.play();
		
		
	}

	@FXML public void onUpdate(CellEditEvent<User, String>  ce) {
		
		System.out.println(ce);
		
		String newValue = ce.getNewValue();
		User user = ce.getRowValue();
		String dbfield= ce.getTableColumn().getId(); //see FXML id (DB Fieldname) 
		System.out.println(newValue);
		dao.update(dbfield, newValue, user.getId());
	}

}
