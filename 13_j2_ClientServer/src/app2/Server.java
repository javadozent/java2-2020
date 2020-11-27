package app2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	public Server() {
		
		try (ServerSocket serverSocket = new ServerSocket(1111)){
			
			System.out.println("Server wartet");
			
			while(true) {
				Socket cSocket = serverSocket.accept();
				System.out.println("vom Client "+cSocket.getInetAddress());
				
				go(cSocket);
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void go(Socket cSocket)  {
		
		new Thread(  ()->{      // für jede Anfrage einen Thread erzeugen
			
			try {
				/*
				 * - beliebige Objekte, die Serializable implementieren
				 * - ACHTUNG! 
				 *   Reihenfolge der ObjectStrem-Erzeuegung muss beim Client umgekehrt sein
				 */
				ObjectInputStream  in =  new ObjectInputStream(cSocket.getInputStream());
				ObjectOutputStream out =  new ObjectOutputStream(cSocket.getOutputStream());
				
				
				String s = String.valueOf(in.readObject());
				
				out.writeObject(s.toUpperCase());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} ).start();
	}

	public static void main(String[] args) {
		new Server();

	}

}
