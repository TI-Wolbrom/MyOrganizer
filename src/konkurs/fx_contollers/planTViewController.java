package konkurs.fx_contollers;

import javafx.scene.control.Label;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class planTViewController {
	
	private int i = 1;
	
	private String stylesR = "-fx-background-color: #CC3300;";
	
	private String styles = "-fx-background-color: #FFCCCC;";
	
	private String cwiczText;
	private String powtText;
	private String czassText;
	
	private String[][] tab = new String[250][3];
	
	@FXML
	private GridPane grid;
	@FXML
	private TextField cwicz;
	@FXML
	private TextField powt;
	@FXML
	private TextField czas;
	@FXML
	private TextField nazwa;

	
	@FXML
	public void onBtnReturn(ActionEvent event) {
		try {
			AppManager.getAppInstance().buildPlanTEditor();
			}catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
			}
	}

	@FXML
	public void initialize() throws IOException {

//		Scanner odczyt = new Scanner("gym_data/plany_treningowe/123.txt");
//		StringTokenizer token;		
//		while(odczyt.hasNextLine()) {
//			token=new StringTokenizer(odczyt.nextLine()," ");
//			while(token.hasMoreElements()) {
//				System.out.println(token.nextToken());
//			}
//		}
//		
//		
//		
//		String[][] tab=new String[250][3];
//		
//		
//		
		Label cwiczenie = new Label();
		Label powtorz = new Label();
		Label czass = new Label();
		cwiczenie.setStyle(stylesR);
		powtorz.setStyle(styles);
		czass.setStyle(stylesR);
		cwiczenie.setMinSize(250, 20);
		powtorz.setMinSize(136, 20);
		czass.setMinSize(117, 20);
		
		cwiczenie.setText(cwiczText);
		powtorz.setText(powtText);
		czass.setText(czassText);
		grid.add(cwiczenie, 0, i);
		grid.add(powtorz, 1, i);
		grid.add(czass, 2, i);
	}

}