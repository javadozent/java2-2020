package service;

import java.net.URL;
import java.util.Scanner;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class URLService extends Service<String> {

	private String urlStr;
	
	
	
	public String getUrlStr() {
		return urlStr;
	}



	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}



	@Override
	protected Task<String> createTask() {
	
		return new Task<String>() {
			

			@Override
			protected String call() throws Exception {
				System.out.println("URLService.call url: "+urlStr);
				
				URL url = new URL(urlStr);
				StringBuilder sb = new StringBuilder();
//				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//				String line="";
//				while((line = br.readLine()) !=null ) {
//					sb.append(line);
//				}
				
				Scanner sc = new Scanner(url.openStream());
				
				while (sc.hasNext()) {
					sb.append(sc.nextLine());
					sb.append(System.lineSeparator());
					
				}
				
				sc.close();		
				return sb.toString();
			}
		};
	}

}
