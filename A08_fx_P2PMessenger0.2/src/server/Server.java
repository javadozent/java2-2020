package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Server extends Service<String> {
	private static Logger log = LogManager.getLogger();
	private ServerSocket serverSocket;
	private MessageService messageService;
	protected String serverhost;

	public String getServerhost() {
		return serverhost;
	}

	public void setServerhost(String serverhost) {
		this.serverhost = serverhost;
	}

	public Server() {
		try {
			serverSocket = new ServerSocket();
			messageService = new MessageService();//
			log.debug("init ServerSocket + MessageService");
		} catch (IOException e) {
			log.error(e);
		}
	}

	public MessageService getService() {
		return messageService;
	}

	public void setService(MessageService service) {
		this.messageService = service;
	}

	// Server binden: serverSocket.bind(new InetSocketAddress(127.0.0.2, 1111));
	// Clientsocket erzeugen(holen), auf Message warten mit accept und
	// MessageService starten
//	public void serverStart(String serverhost) {
//		// hier...
//		try {
//			log.info("Host: " + serverhost);
//
//			// bei Test im Netzwerk über zwei Rechner, könnte das binden nach der
//			// Objekterzeugung Probleme machen
//			// -> wenn das der Fall ist: new ServerSocket(1111);
//			serverSocket.bind(new InetSocketAddress(serverhost, 1111));
//			log.debug("Server bind " + serverSocket.getInetAddress());
//
//			while (true) {
//				log.info("Server wait with accept");
//
//				Socket toClientSocket = serverSocket.accept();
//				log.debug("accept: " + toClientSocket);
//				messageService.setClientSocket(toClientSocket);
//
//				/*
//				 * beim zweiten senden einer Message-> out of ApplicationThread -> workaround
//				 * Platform.runLater
//				 */
//				Platform.runLater(() -> {//
//					messageService.restart();
//				});
//			}
//
//		} catch (IOException e) {
//			log.error(e);
//		}
//
//	}

	@Override
	protected Task<String> createTask() {
		// TODO Auto-generated method stub
		return new Task<String>() {

			@Override
			protected String call() throws Exception {
				// hier...
				try {//TODO setOnFailed Controller
					log.info("Host: " + serverhost);

					// bei Test im Netzwerk über zwei Rechner, könnte das binden nach der
					// Objekterzeugung Probleme machen
					// -> wenn das der Fall ist: new ServerSocket(1111);
					serverSocket.bind(new InetSocketAddress(serverhost, 1111));
					log.debug("Server bind " + serverSocket.getInetAddress());

					while (true) {
						log.info("Server wait with accept");

						Socket toClientSocket = serverSocket.accept();
						log.debug("accept: " + toClientSocket);
						messageService.setClientSocket(toClientSocket);

						/*
						 * beim zweiten senden einer Message-> out of ApplicationThread -> workaround
						 * Platform.runLater
						 */
						Platform.runLater(() -> {//
							messageService.restart();
						});
					}

				} catch (IOException e) {
					log.error(e);
				}
				return "";
			}
		};
	}

}
