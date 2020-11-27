package ui;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static Logger log = LogManager.getLogger();
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
		log.info("serverStartAction");
		new Thread( ()->{
			
			server.serverStart(localServerTextField.getText());
			
		}  ).start();
		
	
	}
	// Event Listener on Button.onAction
	/*
	 * nachricht senden und der Liste anhängen
	 * -Nachricht TableView -OberervabelList
	 * Client send
	 */
	@FXML
	public void messageSendAction(ActionEvent event) {
		log.info("messageSendAction");
		MessageObject msgo = new MessageObject(nameTextField.getText(),
				messageTextField.getText(), LocalTime.now());
		messageTableView.getItems().add(msgo);
		client.writeMSG(msgo);
		
	}
	// Event Listener on Button.onAction
	@FXML // Client setzt Serverhost
	public void connectToServerAction(ActionEvent event) {
		log.info("connectToServerAction");
		
		client.setServerhost(toServerTextField.getText());
	
	}
	
	
	// Server und Client erzeugen
	// Listener/setOnSuccedet für die empfangene Nachricht
	// Nachricht an die Liste hängen
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		log.info("init...");
		server = new Server();
		client =  new Client();
		
		server.getService().setOnFailed( e->{
			Throwable ex =	e.getSource().getException();
			log.error(ex.getStackTrace());
		} );
		
		server.getService().setOnSucceeded(e->{
			MessageObject msgobj = server.getService().getValue();
			log.debug(msgobj);
			messageTableView.getItems().add(msgobj);
		});
		
	}
}
