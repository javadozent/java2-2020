package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {
	
	public static boolean extensionfilter(String str) {
		str = str.toLowerCase();
		return !(str.endsWith(".css")	||
				str.endsWith(".js") 	||
				str.endsWith(".ico")	||
				str.endsWith(".png")	||
				str.endsWith(".jpg")	||
				str.endsWith(".jpeg")	||
				str.endsWith(".mov")	||
				str.endsWith(".mp4")	||
				str.endsWith(".avi")	||
				str.endsWith(".mpeg")	||
				str.endsWith(".svg"));
	}

	public static void main(String[] args) {

		try {
			URL url = new URL("http://www.java2s.com/");
			StringBuilder sb = new StringBuilder();


			Scanner sc = new Scanner(url.openStream());

			while (sc.hasNext()) {
				sb.append(sc.nextLine());
				sb.append(System.lineSeparator());

			}

			sc.close();
			String sourceCode = sb.toString();

			List<String> result = new ArrayList<String>();
			//String urlPattern = "href=\"(.*?)\"";
			//String urlPattern = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
			String urlPattern = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
			
			

			
			Pattern p = Pattern.compile(urlPattern, Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(sourceCode);
			while (m.find()) {
				result.add(m.group());
			}
			
			result = result.stream().filter(Test::extensionfilter).collect(Collectors.toList());
			System.out.println(result.size());
			
			result.forEach(System.out::println);
			
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
