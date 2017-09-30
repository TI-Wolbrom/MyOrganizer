package konkurs;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdateScene extends Scene {

	private Stage mainStage;
	
	private Label statusLabel;
	private Label authorLabel;
	private Label versionLabel;
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Konstruktor
	// -----------------------------------------------------------------------------------------------------------------------------
	public UpdateScene(Parent root, Stage mainStage) {
		super(root);
		
		this.mainStage = mainStage;
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda buduje scene
	// -----------------------------------------------------------------------------------------------------------------------------
	public void build() {
		mainStage.setResizable(false);
		mainStage.setTitle("Proszê czekaæ ...");
		
		VBox vbox = new VBox(20);
		
		HBox hbox = new HBox(25);
		HBox hbox2 = new HBox(30);
		
		statusLabel = new Label("Proszê czekaæ sprawdzanie aktualizacji...");
		statusLabel.setFont(new Font("Tahoma", 26));
		
		hbox.getChildren().add(statusLabel);
		
		versionLabel = new Label("Wersja programu: XXX");
		versionLabel.setFont(new Font("Tahoma", 15));
		
		authorLabel = new Label("My Organizer by 3TI Wolbrom (2017-2018)");
		authorLabel.setFont(new Font("Tahoma", 16));
		
		hbox2.getChildren().add(authorLabel);
		hbox2.getChildren().add(versionLabel);
		
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(hbox2);
		
		setRoot(vbox);
	}
	
}
