package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class MainController {

	// --------------------------------------------------------------------------------------------------------------------
	
	@FXML
	private BorderPane borderPane;

	@FXML
	private MenuItem menuItemEvents;
	
	@FXML
	private MenuItem menuItemExit;

	@FXML
	private Label lblVersion;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@FXML
	private void initialize() {
		lblVersion.setText(lblVersion.getText() + AppManager.VERSION);
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@FXML
	public void onMenuItemEvents(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildEventsEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	@FXML
	public void onMenuItemExit(ActionEvent e) {
		AppManager.closeApp();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@FXML
	public void onMenuItemAbout(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildAbout();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}
}
