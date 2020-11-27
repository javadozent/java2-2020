package app1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	
	public Client() {
		try {
			System.out.println("Client...");
			Socket sSocket = new Socket("localhost",1111);
			InputStream in = sSocket.getInputStream();
			OutputStream out = sSocket.getOutputStream();
			out.write(3);
			out.write(5);
			
			System.out.println(in.read());
			
			sSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();

	}

}
