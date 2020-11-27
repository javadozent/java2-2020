package application;

import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController {

	@FXML
	private TextField clientNameField;

	@FXML
	private TextField fromServerField;
	
	private Client client;

	@FXML
	void sendClientAction(ActionEvent event) {
		client.send(clientNameField.getText());
	}

	@FXML
	void initialize() {
		client = new Client();
		fromServerField.textProperty().bind(client.msgProperty());
		
	}
}
