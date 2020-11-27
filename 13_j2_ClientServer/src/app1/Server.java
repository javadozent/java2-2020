package app1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
				InputStream  in =   cSocket.getInputStream();
				OutputStream out = cSocket.getOutputStream();
				int a = in.read();
				int b = in.read();
				
				out.write(a + b);
				
			}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Server();

	}

}
