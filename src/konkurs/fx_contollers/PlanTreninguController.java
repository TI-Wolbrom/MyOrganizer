package konkurs.fx_contollers;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;


public class PlanTreninguController {
	
	int x=0;
	
	String[] lol = new String[250];
	
	
	@FXML
	private GridPane grid1;
	@FXML
	private GridPane grid2;
	
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
   

   @FXML
   public void initialize() {
	   

	   
			File directory = new File("gym_data/plany_treningowe/");
			
		    File[] pliki = directory.listFiles();
		    System.out.println(pliki[1]);
//		    for(int j=0;j<=100;j++){
//		    lol[j]=pliki[j].toString();							WTF nie dzia³a XDDDDD
//		    }
		    lol[0]=pliki[0].toString();
		    lol[1]=pliki[1].toString();
		    lol[2]=pliki[2].toString();
		    ToggleGroup group = new ToggleGroup();
		    for(int i=x;i<=pliki.length;i++) {
		    	RadioButton radio= new RadioButton();
		    	radio.setText(lol[i]);
		    	radio.setToggleGroup(group);
		    	grid1.add(radio,0,i);
		    }
		    
   		}
   
   @FXML
   public void dropPT(ActionEvent event) {

   		}
  
}