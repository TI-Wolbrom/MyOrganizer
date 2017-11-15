package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import konkurs.AppManager;

public class MainController {

	@FXML
	private BorderPane borderPane;
	
	@FXML
	private MenuItem menuItemExit;

	@FXML
	private void initialize() {
		System.out.println("MainController.initialize()");
	}
	
	@FXML
	public void onMenuItemExit(ActionEvent e) {
		AppManager.closeApp();
	}
}
