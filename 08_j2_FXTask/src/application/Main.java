package application;
	
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			Button b1 = new Button("Start");
			ProgressIndicator pi = new ProgressIndicator();
			Label l1 = new Label();
			Label l2 = new Label();
			
			
			root.setTop(l1);
			root.setBottom(l2);
			root.setCenter(pi);
			root.setRight(b1);
			
			
			b1.setOnAction( e->{
				Task<String> task = createTask();
				pi.progressProperty().bind(task.progressProperty());//updateProgress
				l1.textProperty().bind(task.messageProperty());
				l2.textProperty().bind(task.valueProperty());
				
				
				
				Thread t1 = new Thread(task);
				t1.start();
			} );
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * die Klasse Task ist ein Runnable--> verbessert
	 * - statt run, gibt es eine call-Methode mit Rückgabe
	 */
	public Task<String> createTask(){
		
		Task<String> task = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
