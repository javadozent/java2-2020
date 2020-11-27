package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.ExtractURLService;
import service.URLService;

public class URLServiceController {
	
	
	private URLService urlservice;
	private ExtractURLService extractURLService;

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
    	extractURLService = new ExtractURLService();
    	sourceTextArea.textProperty().bind(urlservice.valueProperty());// return URLService call
    	handleException();
    	handelSuccededServices();
    	
    }

	private void handelSuccededServices() {
		urlservice.setOnSucceeded( e->{
    		// zweiten Service Starten
    		extractURLService.setSourceCode(urlservice.getValue());
    		extractURLService.restart();
    	});
    	extractURLService.setOnSucceeded(e->{
    		linkListView.getItems().setAll(extractURLService.getValue());
    	});
	}

	private void handleException() {
		urlservice.setOnFailed(e->{
    		Throwable th =  e.getSource().getException();
    		th.printStackTrace();
    	});
    	extractURLService.setOnFailed(e->{
			Throwable th =  e.getSource().getException();
			th.printStackTrace();
		});
	}

}
