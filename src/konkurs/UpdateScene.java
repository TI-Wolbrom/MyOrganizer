package konkurs;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UpdateScene extends Scene implements UpdateBehaviour {

	// -----------------------------------------------------------------------------------------------------------------------------
	
	private Stage mainStage;
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	private Label status;

	// -----------------------------------------------------------------------------------------------------------------------------
	
	private Label version;
	
	// -----------------------------------------------------------------------------------------------------------------------------
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Konstruktor
	// -----------------------------------------------------------------------------------------------------------------------------
	public UpdateScene(Parent root, Stage mainStage) {
		super(root);
		
		this.mainStage = mainStage;
		this.mainStage.setTitle("MyOrganizer | " + AppManager.VERSION + " | " + AppManager.OS_NAME);
		this.mainStage.setResizable(false);
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	
	public void transfer(Label statusLabel, Label versionLabel) {
		this.status = statusLabel;
		this.version = versionLabel;
		this.version.setText(this.version.getText() + " " + AppManager.VERSION);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda zmienia status loadera
	// -----------------------------------------------------------------------------------------------------------------------------
	public void changeStatus(String text) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() { status.setText(text); }
		});
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda wczytuje pliki / ustawienia itp.
	// -----------------------------------------------------------------------------------------------------------------------------
	public void loadResources() {
		changeStatus(Main.bundle.getString("loader.loading"));
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onUpdateComplete() {
		changeStatus(Main.bundle.getString("loader.updateDone"));
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onUpdateConnectionError() {
		changeStatus(Main.bundle.getString("loader.connectionError"));
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onUpdateStarted() {
		changeStatus(Main.bundle.getString("loader.updateStarted"));
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onUpdateNothingToUpdate() {
		changeStatus(Main.bundle.getString("loader.versionOk"));
	}
	
	// --------------------------------------------------------------------------------------------------------------------

	@Override
	public void onUpdateError() {
		changeStatus(Main.bundle.getString("loader.updateError"));
	}
	
	// --------------------------------------------------------------------------------------------------------------------

}
