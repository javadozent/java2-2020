package ui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import client.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.MessageObject;
import server.Server;

public class MessengerController implements Initializable{
	@FXML
	private TextField localServerTextField;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField messageTextField;
	@FXML
	private TextField toServerTextField;
	@FXML
	private TableView<MessageObject>messageTableView;
	
	//----------------------- Member---------------------------
	
	private Client client;
	private Server server;
	

	// Event Listener on Button.onAction
	@FXML
	public void serverStartAction(ActionEvent event) {
		System.out.println("serverStartAction");
		// Server starten (in einem  Task-Thread??) 
		
	
	}
	// Event Listener on Button.onAction
	/*
	 * nachricht senden und der Liste anhängen
	 * -Nachricht TableView -OberervabelList
	 * Client send
	 */
	@FXML
	public void messageSendAction(ActionEvent event) {
		System.out.println("messageSendAction");
		
	}
	// Event Listener on Button.onAction
	@FXML // Client setzt Serverhost
	public void connectToServerAction(ActionEvent event) {
		System.out.println("connectToServerAction");
	
	}
	
	
	// Server und Client erzeugen
	// Listener für die empfangene Nachricht
	// Nachricht an die Liste hängen
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
}
