package konkurs.fx_contollers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class GymController {
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate dataDzis = LocalDate.now();
	
	String[] tab= new String[4];
	String line;
	
    @FXML
    private Button btnReturn;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private Label data;
    @FXML
    private TextField masaCiala;
    @FXML
    private TextField obwodKP;
    @FXML
    private TextField obwodBrz;
    @FXML
    private TextField obwodBic;
    
    private String masaC;
    private String obwKP;
    private String obwBrz;
    private String obwBic;
    

    
    @FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }
    
	// --------------------------------------------------------------------------------------------------------------------

    @FXML
    public void initialize() throws FileNotFoundException{
    	
    	data.setText(dtf.format(dataDzis));
   		File plik=new File("data/informacje.txt");
   		Scanner odczyt = new Scanner(plik);
   		while(odczyt.hasNextLine()) {
			line=odczyt.nextLine();
			tab=line.split(";");
   		}
   		obwodBic.setText(tab[0]);
   		obwodBrz.setText(tab[1]);
   		obwodKP.setText(tab[2]);
   		masaCiala.setText(tab[3]);
    
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
	public void zapisz(ActionEvent e) throws FileNotFoundException {
		
		obwBic=obwodBic.getText();
		obwBrz=obwodBrz.getText();
		obwKP=obwodKP.getText();
		masaC=masaCiala.getText();
		File plik=new File("data/informacje.txt");
		PrintWriter zapis = new PrintWriter(plik);
			zapis.write(obwBic+";"+obwBrz+";"+obwKP+";"+masaC);
			zapis.close();
	}
}