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
			MyService service = new MyService();
			pi.progressProperty().bind(service.progressProperty());//updateProgress
			l1.textProperty().bind(service.messageProperty());
			l2.textProperty().bind(service.valueProperty());
			
			b1.setOnAction( e->{
				service.restart(); // oder start()
			} );
			
			service.setOnSucceeded( e->{
				System.out.println("Service ist fertig...");
				//z.B. zweiten Service starten
			} );
			
			service.setOnFailed(e->{
				Throwable th =  e.getSource().getException();
				th.printStackTrace();
			});
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
