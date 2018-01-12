package konkurs.fx_contollers;


import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.Utils;

public class PlanController {

	
	// --------------------------------------------------------------------------------------------------------------------
	
	private String[] tokens;
	private ArrayList<TextField> txtList = new ArrayList<TextField>();
	
	// --------------------------------------------------------------------------------------------------------------------	
	
    public void PlanControler(){
    }
    
	
	@FXML
    private Label lblPlanHour;

    @FXML
    private TextField txtPlanHourLesson8;

    @FXML
    private TextField txtPlanHourLesson7;

    @FXML
    private TextField txtPlanHourLesson6;

    @FXML
    private TextField txtPlanHourLesson5;

    @FXML
    private TextField txtPlanHourLesson4;

    @FXML
    private TextField txtPlanHourLesson1;

    @FXML
    private TextField txtPlanHourLesson3;

    @FXML
    private TextField txtPlanHourLesson2;

    @FXML
    private Label lblPlanMonday;

    @FXML
    private TextField txtPlanMondayLesson1;

    @FXML
    private TextField txtPlanMondayLesson2;

    @FXML
    private TextField txtPlanMondayLesson3;

    @FXML
    private TextField txtPlanMondayLesson4;

    @FXML
    private TextField txtPlanMondayLesson5;

    @FXML
    private TextField txtPlanMondayLesson6;

    @FXML
    private TextField txtPlanMondayLesson7;

    @FXML
    private TextField txtPlanMondayLesson8;

    @FXML
    private Label lblPlanTuesday;

    @FXML
    private TextField txtPlanTuesdayLesson8;

    @FXML
    private TextField txtPlanTuesdayLesson7;

    @FXML
    private TextField txtPlanTuesdayLesson6;

    @FXML
    private TextField txtPlanTuesdayLesson5;

    @FXML
    private TextField txtPlanTuesdayLesson4;

    @FXML
    private TextField txtPlanTuesdayLesson3;

    @FXML
    private TextField txtPlanTuesdayLesson2;

    @FXML
    private TextField txtPlanTuesdayLesson1;

    @FXML
    private Label lblPlanWednesday;

    @FXML
    private TextField txtPlanWednesdayLesson8;

    @FXML
    private TextField txtPlanWednesdayLesson7;

    @FXML
    private TextField txtPlanWednesdayLesson6;

    @FXML
    private TextField txtPlanWednesdayLesson5;

    @FXML
    private TextField txtPlanWednesdayLesson4;

    @FXML
    private TextField txtPlanWednesdayLesson3;

    @FXML
    private TextField txtPlanWednesdayLesson2;

    @FXML
    private TextField txtPlanWednesdayLesson1;

    @FXML
    private Label lblPlanThursday;

    @FXML
    private TextField txtPlanThursdayLesson8;

    @FXML
    private TextField txtPlanThursdayLesson7;

    @FXML
    private TextField txtPlanThursdayLesson6;

    @FXML
    private TextField txtPlanThursdayLesson5;

    @FXML
    private TextField txtPlanThursdayLesson4;

    @FXML
    private TextField txtPlanThursdayLesson3;

    @FXML
    private TextField txtPlanThursdayLesson2;

    @FXML
    private TextField txtPlanThursdayLesson1;

    @FXML
    private Label lblPlanFriday;

    @FXML
    private TextField txtPlanFridayLesson8;

    @FXML
    private TextField txtPlanFridayLesson7;

    @FXML
    private TextField txtPlanFridayLesson6;

    @FXML
    private TextField txtPlanFridayLesson5;

    @FXML
    private TextField txtPlanFridayLesson4;

    @FXML
    private TextField txtPlanFridayLesson3;

    @FXML
    private TextField txtPlanFridayLesson2;

    @FXML
    private TextField txtPlanFridayLesson1;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Button btnReverseChanges;
	
	// --------------------------------------------------------------------------------------------------------------------

    
    
    // --------------------------------------------------------------------------------------------------------------------
    @FXML
    void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }

	// --------------------------------------------------------------------------------------------------------------------

    @FXML
    void onBtnReverseChanges(ActionEvent event) {
    }

	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    void onBtnSaveChanges(ActionEvent event) {
    }

	// --------------------------------------------------------------------------------------------------------------------
    // GETTERS
    // --------------------------------------------------------------------------------------------------------------------
    
    // --------------------------------------------------------------------------------------------------------------------
    
    @FXML
	public void initialize() {
		
		// wczytywanie stuffu do list 

		loadPlan("res/plan.txt");

		txtList.add(txtPlanHourLesson1);
		txtList.add(txtPlanHourLesson2);
		txtList.add(txtPlanHourLesson3);
		txtList.add(txtPlanHourLesson4);
		txtList.add(txtPlanHourLesson5);
		txtList.add(txtPlanHourLesson6);
		txtList.add(txtPlanHourLesson7);
		txtList.add(txtPlanHourLesson8);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson2);
		txtList.add(txtPlanMondayLesson3);
		txtList.add(txtPlanMondayLesson4);
		txtList.add(txtPlanMondayLesson5);
		txtList.add(txtPlanMondayLesson6);
		txtList.add(txtPlanMondayLesson7);
		txtList.add(txtPlanMondayLesson8);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson2);
		txtList.add(txtPlanTuesdayLesson3);
		txtList.add(txtPlanTuesdayLesson4);
		txtList.add(txtPlanTuesdayLesson5);
		txtList.add(txtPlanTuesdayLesson6);
		txtList.add(txtPlanTuesdayLesson7);
		txtList.add(txtPlanTuesdayLesson8);
		txtList.add(txtPlanWednesdayLesson1);
		txtList.add(txtPlanWednesdayLesson2);
		txtList.add(txtPlanWednesdayLesson3);
		txtList.add(txtPlanWednesdayLesson4);
		txtList.add(txtPlanWednesdayLesson5);
		txtList.add(txtPlanWednesdayLesson6);
		txtList.add(txtPlanWednesdayLesson7);
		txtList.add(txtPlanWednesdayLesson8);
		txtList.add(txtPlanThursdayLesson1);
		txtList.add(txtPlanThursdayLesson2);
		txtList.add(txtPlanThursdayLesson3);
		txtList.add(txtPlanThursdayLesson4);
		txtList.add(txtPlanThursdayLesson5);
		txtList.add(txtPlanThursdayLesson6);
		txtList.add(txtPlanThursdayLesson7);
		txtList.add(txtPlanThursdayLesson8);
		txtList.add(txtPlanFridayLesson1);
		txtList.add(txtPlanFridayLesson2);
		txtList.add(txtPlanFridayLesson3);
		txtList.add(txtPlanFridayLesson4);
		txtList.add(txtPlanFridayLesson5);
		txtList.add(txtPlanFridayLesson6);
		txtList.add(txtPlanFridayLesson7);
		txtList.add(txtPlanFridayLesson8);

		for(int i=0;i<txtList.size();i++){
			txtList.get(i).setText(tokens[i]);
		}
		System.out.println(tokens.length);
		System.out.println(txtList.size());
	}
	
    public void loadPlan(String path){
		String file = Utils.loadFileAsString(path);
		tokens = file.split("~");
		System.out.println("AAAA");
	}
    
}
