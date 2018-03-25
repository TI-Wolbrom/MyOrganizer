package konkurs.fx_contollers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class PlanTreninguController{
	
	int x=0;
	String line;
	String[] ele = new String[150];
	String[] pl1 = new String[150];
	public String nazwaPlanu;
	public RadioButton radio= new RadioButton();
	public RadioButton radio2= new RadioButton();
	public RadioButton radio3= new RadioButton();
	public RadioButton radio4= new RadioButton();
	public RadioButton radio5= new RadioButton();
	public RadioButton radio6= new RadioButton();
	public RadioButton radio7= new RadioButton();
	public RadioButton radio8= new RadioButton();
	public RadioButton radio9= new RadioButton();
	public RadioButton radio10= new RadioButton();
	public RadioButton radio11= new RadioButton();
	public RadioButton radio12= new RadioButton();
	public RadioButton radio13= new RadioButton();
	public RadioButton radio14= new RadioButton();
	public RadioButton radio15= new RadioButton();

	@FXML
	private GridPane grid1;
	
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
	public void viewPlan() throws IOException{	
		
		if(radio.isSelected()){
			nazwaPlanu=radio.getText();
			System.out.println(nazwaPlanu);
		}else if(radio2.isSelected()){
			nazwaPlanu=radio2.getText();
		}else if(radio3.isSelected()){
			nazwaPlanu=radio3.getText();
		}else if(radio4.isSelected()){
			nazwaPlanu=radio4.getText();
		}else if(radio5.isSelected()){
			nazwaPlanu=radio5.getText();
		}else if(radio6.isSelected()){
			nazwaPlanu=radio6.getText();
		}else if(radio7.isSelected()){
			nazwaPlanu=radio7.getText();
		}else if(radio8.isSelected()){
			nazwaPlanu=radio8.getText();
		}else if(radio9.isSelected()){
			nazwaPlanu=radio9.getText();
		}else if(radio10.isSelected()){
			nazwaPlanu=radio10.getText();
		}else if(radio11.isSelected()){
			nazwaPlanu=radio11.getText();
		}else if(radio12.isSelected()){
			nazwaPlanu=radio12.getText();
		}else if(radio13.isSelected()){
			nazwaPlanu=radio13.getText();
		}else if(radio14.isSelected()){
			nazwaPlanu=radio14.getText();
		}else if(radio15.isSelected()){
			nazwaPlanu=radio15.getText();
		}	
		File plik1=new File("gym_data/plany_treningowe/nazwaPlanu_1.txt");
		plik1.createNewFile();
		FileWriter fileWritter = new FileWriter(plik1);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(nazwaPlanu);
        bufferWritter.close();
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
   public void initialize() throws FileNotFoundException, IOException {
	   
	   		File plik=new File("gym_data/plany_treningowe/plany_treningowe_lista.txt");
	   		Scanner odczyt = new Scanner(plik);
	   		while(odczyt.hasNextLine()) {
				line=odczyt.nextLine();
				ele=line.split(";");
	   		}
		    for(int j=0;j<ele.length;j++) {
				pl1[j]=ele[j];
		    }
		    ToggleGroup group = new ToggleGroup();
	    	radio.setText(pl1[0]);
	    	radio.setToggleGroup(group);
	    	grid1.add(radio,0,1);
	    	radio2.setText(pl1[1]);
	    	radio2.setToggleGroup(group);
	    	grid1.add(radio2,0,2);    
	    	radio3.setText(pl1[2]);
	    	radio3.setToggleGroup(group);
	    	grid1.add(radio3,0,3);
	    	radio4.setText(pl1[3]);
	    	radio4.setToggleGroup(group);
	    	grid1.add(radio4,0,4);
	    	radio5.setText(pl1[4]);
	    	radio5.setToggleGroup(group);
	    	grid1.add(radio5,0,5);
	    	radio6.setText(pl1[5]);
	    	radio6.setToggleGroup(group);
	    	grid1.add(radio6,0,6);
	    	radio7.setText(pl1[6]);
	    	radio7.setToggleGroup(group);
	    	grid1.add(radio7,0,7);
	    	radio8.setText(pl1[7]);
	    	radio8.setToggleGroup(group);
	    	grid1.add(radio8,0,8);
	    	radio9.setText(pl1[8]);
	    	radio9.setToggleGroup(group);
	    	grid1.add(radio9,0,9);
	    	radio10.setText(pl1[9]);
	    	radio10.setToggleGroup(group);
	    	grid1.add(radio10,0,10);
	    	radio11.setText(pl1[10]);
	    	radio11.setToggleGroup(group);
	    	grid1.add(radio11,0,11);
	    	radio12.setText(pl1[11]);
	    	radio12.setToggleGroup(group);
	    	grid1.add(radio12,0,12);
	    	radio13.setText(pl1[12]);
	    	radio13.setToggleGroup(group);
	    	grid1.add(radio13,0,13);
	    	radio14.setText(pl1[13]);
	    	radio14.setToggleGroup(group);
	    	grid1.add(radio14,0,14);
	    	radio15.setText(pl1[14]);
	    	radio15.setToggleGroup(group);
	    	grid1.add(radio15,0,15);
		    }

}