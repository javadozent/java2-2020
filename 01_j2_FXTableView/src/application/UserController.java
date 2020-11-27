package application;

import java.time.LocalDate;
import java.time.Month;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import model.User;

public class UserController {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> vornnameCol;

    @FXML
    private TableColumn<User, String> nachnameCol;

    @FXML
    private TableColumn<User, LocalDate> gebCol;

	@FXML private TextField nachnameField;

	@FXML private DatePicker gebField;

	@FXML private TextField vornameField;
    
    
    @FXML
    void initialize() {
    	System.out.println("init...");
    	
    	ObservableList<User> oList = FXCollections.observableArrayList();
    	oList.add(new User("Max", "Meier", LocalDate.now() ));
    	oList.add(new User("Ina", "Müller", LocalDate.of(2020,Month.OCTOBER, 3) ));
    	oList.add(new User("Otto", "Lehmann", LocalDate.now() ));
    	userTable.setItems(oList);
    	vornnameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));//getVorname()
    	nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));//getNachname()
    	gebCol.setCellValueFactory(new PropertyValueFactory<>("gebDatum"));//getGebdatum()
    	
    	userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	
    	// ContextMenu -Delete
    	ContextMenu cm = new ContextMenu();
    	MenuItem deleteItem = new MenuItem("Delete");
    	deleteItem.setOnAction( e->{
    		
    		oList.remove(userTable.getSelectionModel().getSelectedItem());
    	} );
    	cm.getItems().add(deleteItem);
    	userTable.setContextMenu(cm);
    	
    	// Zellen editierbar machen
    	
    	vornnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	
    	
    	

    }


	@FXML public void onSave(ActionEvent event) {
		userTable.getItems().add(new User(vornameField.getText(), nachnameField.getText(), gebField.getValue()));
		
	}


	@FXML public void onDelete(ActionEvent event) {
		
	//	userTable.getItems().remove(userTable.getSelectionModel().getSelectedItem());
		
		ObservableList<User> selectList = userTable.getSelectionModel().getSelectedItems();
		userTable.getItems().removeAll(selectList);
		
	
		
	}

	
	
	// Update
	@FXML public void onEditCommit(CellEditEvent<User, String>  ce) {
		System.out.println(ce.getNewValue());
		User u = ce.getRowValue();
	
	}

}
