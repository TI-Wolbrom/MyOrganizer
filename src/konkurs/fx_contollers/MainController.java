package konkurs.fx_contollers;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import konkurs.AppManager;
import konkurs.Main;
import konkurs.UpdateManager;
import konkurs.fx.dialogs.DialogHelper;
import konkurs.taskmodules.impl.TaskManager;

public class MainController {

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private BorderPane borderPane;

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private MenuItem menuItemEvents;

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private MenuItem menuItemPlan;

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private MenuItem menuItemExit;

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private Label lblVersion;

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	private void initialize() {
		lblVersion.setText(lblVersion.getText() + " " + AppManager.VERSION);

		try {
			TaskManager.loadFromFile();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find data for events editor it's probably new session.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void onMenuItemGym(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildGymEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	public void onMenuItemPlan(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildPlanEditor();
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

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	public void onMenuItemSettings(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildSettings();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	public void onMenuItemUpdate(ActionEvent e) {
		int result;
		try {
			result = UpdateManager.updateRequired();
		} catch (Exception ex) {
			result = -1;
		}

		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle(Main.bundle.getString("updater.title"));
		alert.setHeaderText(null);

		switch (result) {
		case 0:
			alert.setAlertType(Alert.AlertType.INFORMATION);
			alert.setContentText(Main.bundle.getString("updater.developerMode"));
			break;
		case 1:
			alert.setAlertType(Alert.AlertType.INFORMATION);
			alert.setContentText(Main.bundle.getString("updater.updateReady"));
			break;
		case 2:
			alert.setAlertType(Alert.AlertType.ERROR);
			alert.setContentText(Main.bundle.getString("updater.updateError") + " #2");
			break;
		case 3:
			alert.setAlertType(Alert.AlertType.INFORMATION);
			alert.setContentText(Main.bundle.getString("updater.versionOk"));
			break;
		case -1:
			alert.setAlertType(Alert.AlertType.ERROR);
			alert.setContentText(Main.bundle.getString("updater.updateError") + " #-1");
			break;
		default:
			alert.setAlertType(Alert.AlertType.WARNING);
			alert.setContentText("onMenuItemUpdate (default)");
			break;
		}

		alert.showAndWait();
	}
}
