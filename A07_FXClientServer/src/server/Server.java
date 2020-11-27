package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

/*
 * Name und LocalTime zum Client schicken
 */
public class Server {
	public Server() {

		try (ServerSocket serverSocket = new ServerSocket(1111)) {

			System.out.println("Server wartet");

			while (true) {
				Socket cSocket = serverSocket.accept();
				System.out.println("vom Client " + cSocket.getInetAddress());

				go(cSocket);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void go(Socket cSocket) {

		new Thread(() -> { // für jede Anfrage einen Thread erzeugen

			try {
				/*
				 * - beliebige Objekte, die Serializable implementieren - ACHTUNG! Reihenfolge
				 * der ObjectStrem-Erzeuegung muss beim Client umgekehrt sein
				 */
				ObjectInputStream in = new ObjectInputStream(cSocket.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(cSocket.getOutputStream());

				String s = String.valueOf(in.readObject());

				System.out.println("server:"+s);
				out.writeObject(s+" "+LocalTime.now());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();
	}

	public static void main(String[] args) {
		new Server();

	}

}
