package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthScrollBarUI;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ExtractURLService extends Service<List<String>> {

	private final static String URl_PATTERN = "\\b(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	private String sourceCode;

	@Override
	protected Task<List<String>> createTask() {
		return new Task<List<String>>() {

			@Override
			protected List<String> call() throws Exception {
				System.out.println(getClass()+" call...");
				List<String> result = new ArrayList<String>();
				Pattern p = Pattern.compile(URl_PATTERN, Pattern.CASE_INSENSITIVE);
				Matcher m = p.matcher(sourceCode);
				while (m.find()) {
					result.add(m.group());
				}
				System.out.println(getClass().getName()+" Result size: "+result.size() );
				System.out.println(getClass().getName()+" Result size: "+result );
				return 	result.stream().
						filter(ExtractURLService::extensionfilter ).
						collect(Collectors.toList());// -> Controller setOnSuccedet
			}
		};
	}
	
	

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
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
				str.endsWith(".json")	||
				str.endsWith(".xml")	||
				str.endsWith(".svg"));
	}

	

	

}
