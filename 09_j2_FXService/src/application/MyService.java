package application;

import javafx.concurrent.Service;
import javafx.concurrent.Task;


/*
 * Service ist ein Thread (erweitert)
 * - kann direkt gestartet werden mit start oder restart
 */
public class MyService extends Service<String>{
	
	// Mögliche Instanzvariablen
	// und set-getMethoden

	@Override
	protected Task<String> createTask() {

		Task<String> task = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
				if(isCancelled()) {// stop
					return "cancel...";
				}
				updateMessage("call start");// -> messageProperty
				
				final long  MAX = 10_000_000;
				long result = 0;
				for (int i = 0; i <= MAX; i++) {
					result+=i;
					updateValue(result+"");// Zwischenergebnis // -> valueProperty
					updateProgress(i, MAX);// -> progressProperty
					
				}
				updateMessage("call end");
				return "Result: "+result;// Endergebnis // -> valueProperty
			}
		};
		
		return task;
		
	}

}
