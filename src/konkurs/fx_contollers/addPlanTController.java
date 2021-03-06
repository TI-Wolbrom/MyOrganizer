package konkurs.fx_contollers;

import javafx.scene.control.Label;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class addPlanTController {
	
	private int i = 1;
	private String stylesR = "-fx-background-color: #CC3300;";
	private String styles = "-fx-background-color: #FFCCCC;";
	private String cwiczText;
	private String powtText;
	private String czassText;
	private String[][] tab = new String[250][3];
	public static String nazwaPlanu;
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
	public void dodaj(ActionEvent event) {
		
		cwiczText = cwicz.getText();
		powtText = powt.getText();
		czassText = czas.getText();
		Label cwiczenie = new Label();
		Label powtorz = new Label();
		Label czass = new Label();
		cwiczenie.setStyle(stylesR);
		powtorz.setStyle(styles);
		czass.setStyle(stylesR);
		cwiczenie.setMinSize(250, 20);
		powtorz.setMinSize(136, 20);
		czass.setMinSize(117, 20);
		
		tab[i][0]=cwiczText;
		tab[i][1]=powtText;
		tab[i][2]=czassText;
		
		if(cwiczText.isEmpty()) {
			tab[i][0]="-";
		}
		if(powtText.isEmpty()) {
			tab[i][1]="-";
		}
		if(czassText.isEmpty()) {
			tab[i][2]="-";
		}
		
		if(cwiczText.isEmpty()) {
		}else{		
		cwiczenie.setText(cwiczText);
		powtorz.setText(powtText);
		czass.setText(czassText);
		grid.add(cwiczenie, 0, i);
		grid.add(powtorz, 1, i);
		grid.add(czass, 2, i);
		
		i++;
		}
	}
	
	@FXML
	public void zapisz(ActionEvent event) throws IOException {
		
		nazwaPlanu=nazwa.getText();
		if(nazwaPlanu.isEmpty()) {
			nazwaPlanu="-";
		}
		PrintWriter zapis = new PrintWriter("data/"+nazwaPlanu+".txt");
		for(int x=1;x<=i-1;x++) {
			zapis.println(tab[x][0]+";"+tab[x][1]+";"+tab[x][2]);
		}
		File file = new File("data/plany_treningowe_lista.txt");

            try {
				file.createNewFile();
				FileWriter fileWritter = new FileWriter(file,true);
		        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		        bufferWritter.write(nazwaPlanu+";");
		        bufferWritter.close();		
			} catch (IOException e) {
				e.printStackTrace();
			}
        
		
	    zapis.close();
	}
}