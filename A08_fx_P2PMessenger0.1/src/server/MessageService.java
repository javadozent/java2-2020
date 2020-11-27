package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import model.MessageObject;

public class MessageService extends Service<MessageObject>{
	private static Logger log = LogManager.getLogger();
	private Socket clientSocket;

	@Override
	protected Task<MessageObject> createTask() {
		return new Task<MessageObject>(){

			
			
			@Override
			protected MessageObject call() throws Exception {
				updateMessage("MessageService: call");
				log.debug("call...");
				// ObjectInputstream erzeugen, Nachricht lesen, zurückgeben
				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
				MessageObject msgObj =  (MessageObject) in.readObject();
				log.debug("read {}",msgObj);
				//hier...
				return msgObj;//value-> valueProperty
			}
			
		};
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
		
	}

}
