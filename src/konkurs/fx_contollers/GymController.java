package konkurs.fx_contollers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class GymController {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate dataDzis = LocalDate.now();
	
    @FXML
    private Button btnReturn;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private Label data;

    @FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }
    
	// --------------------------------------------------------------------------------------------------------------------

    @FXML
    public void initialize(){
    	grid.add(new CheckBox("AAA"), 0, 0);
    	data.setText(dtf.format(dataDzis));
    	
    	
    }
    
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
	
	//--------------------------------------------------------------------------------------------------------------------
	
	@FXML
	public void zapisz(ActionEvent e) {

	}
	
	@FXML
	public void edytuj(ActionEvent e) {

	}
	
	
	
	
	
	
	
	
}