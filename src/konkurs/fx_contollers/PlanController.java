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
	
	private static String[] tokens;
	private static ArrayList<TextField> txtList = new ArrayList<TextField>();
	
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

	public void initialize() {
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
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanMondayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		txtList.add(txtPlanTuesdayLesson1);
		
		// GODZINY
    	txtPlanHourLesson1.setText(tokens[0]);
    	txtPlanHourLesson2.setText(tokens[1]);
    	txtPlanHourLesson3.setText(tokens[2]);
    	txtPlanHourLesson4.setText(tokens[3]);
    	txtPlanHourLesson5.setText(tokens[4]);
    	txtPlanHourLesson6.setText(tokens[5]);
    	txtPlanHourLesson7.setText(tokens[6]);
    	txtPlanHourLesson8.setText(tokens[7]);

    	// Monday
    	txtPlanMondayLesson1.setText(tokens[8]);
    	txtPlanMondayLesson2.setText(tokens[9]);
    	txtPlanMondayLesson3.setText(tokens[10]);
    	txtPlanMondayLesson4.setText(tokens[11]);
    	txtPlanMondayLesson5.setText(tokens[12]);
    	txtPlanMondayLesson6.setText(tokens[13]);
    	txtPlanMondayLesson7.setText(tokens[8]);
    	txtPlanMondayLesson8.setText(tokens[8]);

    	// Tuesday
    	txtPlanTuesdayLesson1.setText(tokens[8]);
    	txtPlanTuesdayLesson2.setText(tokens[8]);
    	txtPlanTuesdayLesson3.setText(tokens[8]);
    	txtPlanTuesdayLesson4.setText(tokens[8]);
    	txtPlanTuesdayLesson5.setText(tokens[8]);
    	txtPlanTuesdayLesson6.setText(tokens[8]);
    	txtPlanTuesdayLesson7.setText(tokens[8]);
    	txtPlanTuesdayLesson8.setText(tokens[8]);

    	// Wednesday
    	txtPlanWednesdayLesson1.setText(tokens[8]);
    	txtPlanWednesdayLesson2.setText(tokens[8]);
    	txtPlanWednesdayLesson3.setText(tokens[8]);
    	txtPlanWednesdayLesson4.setText(tokens[8]);
    	txtPlanWednesdayLesson5.setText(tokens[8]);
    	txtPlanWednesdayLesson6.setText(tokens[8]);
    	txtPlanWednesdayLesson7.setText(tokens[8]);
    	txtPlanWednesdayLesson8.setText(tokens[8]);

    	// Thursday
    	txtPlanThursdayLesson1.setText(tokens[8]);
    	txtPlanThursdayLesson2.setText(tokens[8]);
    	txtPlanThursdayLesson3.setText(tokens[8]);
    	txtPlanThursdayLesson4.setText(tokens[8]);
    	txtPlanThursdayLesson5.setText(tokens[8]);
    	txtPlanThursdayLesson6.setText(tokens[8]);
    	txtPlanThursdayLesson7.setText(tokens[8]);
    	txtPlanThursdayLesson8.setText(tokens[8]);

    	// Friday
    	txtPlanFridayLesson1.setText(tokens[8]);
    	txtPlanFridayLesson2.setText(tokens[8]);
    	txtPlanFridayLesson3.setText(tokens[8]);
    	txtPlanFridayLesson4.setText(tokens[8]);
    	txtPlanFridayLesson5.setText(tokens[8]);
    	txtPlanFridayLesson6.setText(tokens[8]);
    	txtPlanFridayLesson7.setText(tokens[8]);
    	txtPlanFridayLesson8.setText(tokens[8]);
	}
	
    public static void loadPlan(String path){
		String file = Utils.loadFileAsString(path);
		tokens = file.split("~");
		System.out.println("AAAA");
	}
    
}
