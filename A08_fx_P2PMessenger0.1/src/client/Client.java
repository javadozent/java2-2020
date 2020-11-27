package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.MessageObject;

public class Client {
	private static Logger log = LogManager.getLogger();
	private String serverhost;

	public String getServerhost() {
		return serverhost;
	}

	
	/*
	 * see Controller.connet
	 */
	public void setServerhost(String serverhost) {
		log.trace(serverhost);
		this.serverhost = serverhost;
	}

	
	//Socket und Outputstream erzeugen und Nachricht schreiben
	public void writeMSG(MessageObject msgObj){
		// hier...
		log.debug(msgObj);
		
		try (Socket socket = new Socket(serverhost,1111) ){
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(msgObj);
			log.debug("write to Server: "+msgObj);
		} catch (IOException e) {
			log.error(e.getStackTrace());
		}
	}
	
}
