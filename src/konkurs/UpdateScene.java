package konkurs;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UpdateScene extends Scene implements UpdateBehaviour {

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
				
		statusLabel = new Label();
		statusLabel.setFont(new Font("Tahoma", 26));
		
		changeStatus("Sprawdzanie aktualizacji...");
		
		hbox.getChildren().add(statusLabel);
		
		versionLabel = new Label("Wersja programu: " + AppManager.VERSION);
		versionLabel.setFont(new Font("Tahoma", 15));
		
		authorLabel = new Label("My Organizer by 3TI Wolbrom (2017-2018)");
		authorLabel.setFont(new Font("Tahoma", 16));
		
		hbox2.getChildren().add(authorLabel);
		hbox2.getChildren().add(versionLabel);
		
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(hbox2);
		
		setRoot(vbox);
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda zmienia status loadera
	// -----------------------------------------------------------------------------------------------------------------------------
	public void changeStatus(String status) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() { statusLabel.setText(status); }
		});
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda wczytuje pliki / ustawienia itp.
	// -----------------------------------------------------------------------------------------------------------------------------
	public void loadResources() {
		changeStatus("£adowanie niezbêdnych plików...");
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onUpdateComplete() {
		changeStatus("Aktualizacja zakoñczona!");
	}

	@Override
	public void onUpdateConnectionError() {
		changeStatus("Wyst¹pi³ problem z po³¹czeniem!");
	}

	@Override
	public void onUpdateStarted() {
		changeStatus("Rozpoczynam aktualizacje...");
	}

	@Override
	public void onUpdateNothingToUpdate() {
		changeStatus("Wersja jest aktualna!");
	}

	@Override
	public void onUpdateError() {
		changeStatus("Wyst¹pi³ problem z aktualizacj¹!");
	}
	
	// --------------------------------------------------------------------------------------------------------------------

}
