package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class BMIController {

	@FXML
	private Button btnReturn;

	@FXML
	private Button oblicz;

	@FXML
	private TextField masaCiala;

	@FXML
	private TextField wzrost;

	@FXML
	private TextField BMI;

	@FXML
	public void oblicz() {
		String masa = masaCiala.getText();
		String wzr = wzrost.getText();
		double masaDouble = 0;
		double wzrostDouble = 0;
		double wynikDouble;
			
			// dodaæ minimalny wzrost i wagê
		
			try {
				masaDouble = Double.parseDouble(masa);
			} catch (NumberFormatException e) {
				masaCiala.setText("Masa cia³a zosta³a b³êdnie podana");
			}
			try {
				wzrost.setPromptText("np. 1.92");
				wzrostDouble = Double.parseDouble(wzr);
			} catch (NumberFormatException e) {
				wzrost.setText("Wzrost zosta³ b³êdnie podany");
			}
	
			try {
				wynikDouble = masaDouble / Math.pow(wzrostDouble, 2);
				wynikDouble = wynikDouble * 10000;
				String wynik = Double.toString(wynikDouble);
				BMI.setText(wynik);
			} catch (Exception e) {
				// TODO: handle exception
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

}