package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.URLService;

public class URLServiceController {
	
	
	private URLService urlservice;

    @FXML
    private TextArea sourceTextArea;

    @FXML
    private ListView<String> linkListView;

    @FXML
    private TextField searchfield;

    @FXML
    void onSearch(ActionEvent event) {
    	urlservice.setUrlStr(searchfield.getText());
    	urlservice.restart();// ruft call

    }
    
    @FXML
    void initialize() {
    	System.out.println("init...");
    	urlservice = new URLService();
    	
    	sourceTextArea.textProperty().bind(urlservice.valueProperty());// return URLService call
    	urlservice.setOnFailed(e->{
			Throwable th =  e.getSource().getException();
			th.printStackTrace();
		});
    }

}
