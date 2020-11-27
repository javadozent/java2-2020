package application;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Temperatur {
	
	//private float grad;

	private FloatProperty grad = new SimpleFloatProperty();

	
	/*
	 * f�r Listener und Binding geeignet
	 * -> Werte Ver�nderung Benachrichtigung (Observer)
	 */
	public FloatProperty gradProperty() {
		return this.grad;
	}
	

	public  float getGrad() {
		return this.gradProperty().get();
	}
	

	public void setGrad(float grad) {
	
		this.gradProperty().set(grad);
	}
	
	
	
	
}
