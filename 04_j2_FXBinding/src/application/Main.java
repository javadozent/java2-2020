package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);

			Button b1 = new Button("+");
			Button b2 = new Button("-");
			ProgressBar pb = new ProgressBar();
			
			Temperatur t = new Temperatur();
			
			b1.setOnAction( e->{
				t.setGrad(t.getGrad()+0.1f);// 0.1 == 1%, 1 == 100%
			});
			
			b2.setOnAction( e->{
				t.setGrad(t.getGrad()-0.1f);// 0.1 == 1%, 1 == 100%
			});
			//###############################
			
			//t.gradProperty().addListener(..);
			
			//links->Empfänger
			pb.progressProperty().bind(t.gradProperty());
			
			root.setTop(pb);
			root.setLeft(b2);
			root.setRight(b1);
			
			
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
