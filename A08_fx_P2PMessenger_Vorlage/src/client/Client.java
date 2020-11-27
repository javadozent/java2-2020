package client;

import model.MessageObject;

public class Client {
	
	private String serverhost;

	public String getServerhost() {
		return serverhost;
	}

	public void setServerhost(String serverhost) {
		this.serverhost = serverhost;
	}

	
	//Socket und Outputstream erzeugen und Nachricht schreiben
	public void writeMSG(MessageObject msgObj){
		// hier...
	}
	
}
