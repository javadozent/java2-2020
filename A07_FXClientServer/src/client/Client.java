package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	
	private StringProperty msg = new SimpleStringProperty();
	
	

	public void send(String msg) {
		try {
			System.out.println("Client...");
			Socket sSocket = new Socket("localhost",1111);
			ObjectOutputStream out =  new ObjectOutputStream(sSocket.getOutputStream());
			ObjectInputStream  in =  new ObjectInputStream(sSocket.getInputStream());
			
//			
			out.writeObject(msg);
//			
			setMsg("Server: "+in.readObject());
			
			
			sSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public final StringProperty msgProperty() {
		return this.msg;
	}
	


	public final String getMsg() {
		return this.msgProperty().get();
	}
	


	public final void setMsg(final String msg) {
		this.msgProperty().set(msg);
	}
	

}
