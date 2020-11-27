package application;

import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<Hyperlink> linkListView;

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
    		linkListView.setItems(createHyperlinkList(extractURLService.getValue()));
    	});
	}



	private ObservableList<Hyperlink> createHyperlinkList(List<String> strList) {
		ObservableList<Hyperlink> hyperlinkList =  FXCollections.observableArrayList();
		
		for (String strLink : strList) {
			Hyperlink hLink = new Hyperlink(strLink);
			hyperlinkList.add(hLink);
			
			hLink.setOnAction( e ->{
				
				System.out.println(hLink);
				
				searchfield.setText(strLink);
				urlservice.setUrlStr(strLink);
				urlservice.restart();
			});
		}
		
		return hyperlinkList;
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
