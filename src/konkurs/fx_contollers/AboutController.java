package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import konkurs.AppManager;

public class AboutController {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnExit;

    @FXML
    public void onButtonOkAction(ActionEvent e) {
    	AppManager.getAppInstance().switchToMain();
    }
    
    @FXML
    public void onButtonExitAction(ActionEvent e) {
    	AppManager.closeApp();
    }

}
