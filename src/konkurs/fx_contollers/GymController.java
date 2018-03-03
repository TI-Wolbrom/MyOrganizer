package konkurs.fx_contollers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class GymController {
	

    @FXML
    private Button btnReturn;

    @FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }
    
	// --------------------------------------------------------------------------------------------------------------------

	@FXML
	public void onMenuItemCalc(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildCalcEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}
	
	@FXML
	public void onMenuItemPlanT(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildPlanTEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}
	
	@FXML
	public void onMenuItemLBM(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildLBMEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}
	
	@FXML
	public void onMenuItemBMI(ActionEvent e) {
		try {
			AppManager.getAppInstance().buildBMIEditor();
		} catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
		}
	}
	
	
}