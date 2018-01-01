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
	private static boolean check = false;
	
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

//		System.out.println(check);
//		if(!check){
//			
//		loadPlan("res/plan.txt");
//		
//		txtList.add(txtPlanHourLesson1);
//		txtList.add(txtPlanHourLesson2);
//		txtList.add(txtPlanHourLesson3);
//		txtList.add(txtPlanHourLesson4);
//		txtList.add(txtPlanHourLesson5);
//		txtList.add(txtPlanHourLesson6);
//		txtList.add(txtPlanHourLesson7);
//		txtList.add(txtPlanHourLesson8);
//		txtList.add(txtPlanMondayLesson1);
//		txtList.add(txtPlanMondayLesson2);
//		txtList.add(txtPlanMondayLesson3);
//		txtList.add(txtPlanMondayLesson4);
//		txtList.add(txtPlanMondayLesson5);
//		txtList.add(txtPlanMondayLesson6);
//		txtList.add(txtPlanMondayLesson7);
//		txtList.add(txtPlanMondayLesson8);
//		txtList.add(txtPlanTuesdayLesson1);
//		txtList.add(txtPlanTuesdayLesson2);
//		txtList.add(txtPlanTuesdayLesson3);
//		txtList.add(txtPlanTuesdayLesson4);
//		txtList.add(txtPlanTuesdayLesson5);
//		txtList.add(txtPlanTuesdayLesson6);
//		txtList.add(txtPlanTuesdayLesson7);
//		txtList.add(txtPlanTuesdayLesson8);
//		txtList.add(txtPlanWednesdayLesson1);
//		txtList.add(txtPlanWednesdayLesson2);
//		txtList.add(txtPlanWednesdayLesson3);
//		txtList.add(txtPlanWednesdayLesson4);
//		txtList.add(txtPlanWednesdayLesson5);
//		txtList.add(txtPlanWednesdayLesson6);
//		txtList.add(txtPlanWednesdayLesson7);
//		txtList.add(txtPlanWednesdayLesson8);
//		txtList.add(txtPlanThursdayLesson1);
//		txtList.add(txtPlanThursdayLesson2);
//		txtList.add(txtPlanThursdayLesson3);
//		txtList.add(txtPlanThursdayLesson4);
//		txtList.add(txtPlanThursdayLesson5);
//		txtList.add(txtPlanThursdayLesson6);
//		txtList.add(txtPlanThursdayLesson7);
//		txtList.add(txtPlanThursdayLesson8);
//		txtList.add(txtPlanFridayLesson1);
//		txtList.add(txtPlanFridayLesson2);
//		txtList.add(txtPlanFridayLesson3);
//		txtList.add(txtPlanFridayLesson4);
//		txtList.add(txtPlanFridayLesson5);
//		txtList.add(txtPlanFridayLesson6);
//		txtList.add(txtPlanFridayLesson7);
//		txtList.add(txtPlanFridayLesson8);
//		
//		check = true;
//		}
//
//		System.out.println(check);
//		System.out.println(txtList.size());
//		
//		for(int i=0;i<txtList.size();i++){
//			System.out.println(tokens[i] + "AAAAA" + i);
//			System.out.println(txtList.get(i));
//			txtList.get(i).setText(tokens[i]);
//		}

///////////////////////////////////////////////////////////////////////////
//
//		tyn na górze nie dzia³a(why ;-; ?), a tyn na dole tak i nwm ;-;
//	
///////////////////////////////////////////////////////////////////////////
		
		
		if(!check){
			loadPlan("res/plan.txt");
			check=true;
		}
		
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
    	txtPlanMondayLesson7.setText(tokens[14]);
    	txtPlanMondayLesson8.setText(tokens[15]);

    	// Tuesday
    	txtPlanTuesdayLesson1.setText(tokens[16]);
    	txtPlanTuesdayLesson2.setText(tokens[17]);
    	txtPlanTuesdayLesson3.setText(tokens[18]);
    	txtPlanTuesdayLesson4.setText(tokens[19]);
    	txtPlanTuesdayLesson5.setText(tokens[20]);
    	txtPlanTuesdayLesson6.setText(tokens[21]);
    	txtPlanTuesdayLesson7.setText(tokens[22]);
    	txtPlanTuesdayLesson8.setText(tokens[23]);

    	// Wednesday
    	txtPlanWednesdayLesson1.setText(tokens[24]);
    	txtPlanWednesdayLesson2.setText(tokens[25]);
    	txtPlanWednesdayLesson3.setText(tokens[26]);
    	txtPlanWednesdayLesson4.setText(tokens[27]);
    	txtPlanWednesdayLesson5.setText(tokens[28]);
    	txtPlanWednesdayLesson6.setText(tokens[29]);
    	txtPlanWednesdayLesson7.setText(tokens[30]);
    	txtPlanWednesdayLesson8.setText(tokens[31]);

    	// Thursday
    	txtPlanThursdayLesson1.setText(tokens[32]);
    	txtPlanThursdayLesson2.setText(tokens[33]);
    	txtPlanThursdayLesson3.setText(tokens[34]);
    	txtPlanThursdayLesson4.setText(tokens[35]);
    	txtPlanThursdayLesson5.setText(tokens[36]);
    	txtPlanThursdayLesson6.setText(tokens[37]);
    	txtPlanThursdayLesson7.setText(tokens[38]);
    	txtPlanThursdayLesson8.setText(tokens[39]);

    	// Friday
    	txtPlanFridayLesson1.setText(tokens[40]);
    	txtPlanFridayLesson2.setText(tokens[41]);
    	txtPlanFridayLesson3.setText(tokens[42]);
    	txtPlanFridayLesson4.setText(tokens[43]);
    	txtPlanFridayLesson5.setText(tokens[44]);
    	txtPlanFridayLesson6.setText(tokens[45]);
    	txtPlanFridayLesson7.setText(tokens[46]);
    	txtPlanFridayLesson8.setText(tokens[47]);
	}
	
    public static void loadPlan(String path){
		String file = Utils.loadFileAsString(path);
		tokens = file.split("~");
		System.out.println("AAAA");
	}
    
}
