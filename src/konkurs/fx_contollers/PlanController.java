package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import konkurs.AppManager;

public class PlanController {
	
	@FXML
	private Button btnReturn;
	
	@FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }
}
