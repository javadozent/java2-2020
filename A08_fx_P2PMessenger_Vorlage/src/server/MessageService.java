package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import model.MessageObject;

public class MessageService extends Service<MessageObject>{
	
	private Socket clientSocket;

	@Override
	protected Task<MessageObject> createTask() {
		return new Task<MessageObject>(){

			
			
			@Override
			protected MessageObject call() throws Exception {
				updateMessage("MessageService: call");
				// ObjectInputstream erzeugen, Nachricht lesen, zurückgeben
			
				//hier...
				return null;
			}
			
		};
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
		
	}

}
