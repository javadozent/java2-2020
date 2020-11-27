package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class SampleController {

	@FXML
	private Label label;
	@FXML
	private TextField textField;

	@FXML
	void initialize() {
		System.out.println("init...");

	}

	@FXML
	public void action(ActionEvent event) {
	}

}
