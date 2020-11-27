package app2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public Client() {
		try {
			System.out.println("Client...");
			Socket sSocket = new Socket("localhost",1111);
			ObjectOutputStream out =  new ObjectOutputStream(sSocket.getOutputStream());
			ObjectInputStream  in =  new ObjectInputStream(sSocket.getInputStream());
			
			
			out.writeObject("Hallo Server...");
			
			System.out.println(in.readObject());
			
			
			sSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();

	}

}
