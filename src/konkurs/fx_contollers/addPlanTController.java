package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;


public class addPlanTController {
	
	
   @FXML
   public void onBtnReturn(ActionEvent event) {
			try {
				AppManager.getAppInstance().buildGymEditor();
			} catch (Exception ex) {
				DialogHelper.showExceptionDialog(ex);
				ex.printStackTrace();
				AppManager.closeApp();
			}
   		}
   

    
    
}