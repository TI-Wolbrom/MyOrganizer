package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import konkurs.AppManager;
import konkurs.Main;

public class GymController {

    @FXML
    private Button btnReturn;

    @FXML
    void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }
    
}
