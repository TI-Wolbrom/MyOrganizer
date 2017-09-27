package konkurs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/resources/fxml/Base.fxml"));
		
		BorderPane pane = loader.load();
		
		Scene scene = new Scene(pane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("[My Organizer] by 3TI Wolbrom");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
		
}
