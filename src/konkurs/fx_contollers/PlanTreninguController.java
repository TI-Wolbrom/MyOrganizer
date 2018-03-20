package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;


public class PlanTreninguController {
	
	@FXML
	public void addPlan(){
		try {
			AppManager.getAppInstance().buildAddPlanTEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
		
	}
	
	@FXML
	public void viewPlan(){
		try {
			AppManager.getAppInstance().buildPlanTView();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
		
	}


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