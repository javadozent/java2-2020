package application;


import javafx.beans.property.ObjectProperty;

/**
 * Aufgabe Rectangle soll die Farbe vom ColorPicker mit Hilfe von Binding übernehemen
 * @author micha
 *
 */

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class SampleController {
	
	

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Rectangle rect;
    
    
    
    @FXML
    void initialize() {
    	
    	rect.fillProperty().bind(colorPicker.valueProperty());
    	
    }

}
