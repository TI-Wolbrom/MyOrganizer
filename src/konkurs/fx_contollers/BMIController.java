package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.Main;
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
			
			// dodać minimalny wzrost i wagę
		
			try {
				masaDouble = Double.parseDouble(masa);
			} catch (NumberFormatException e) {
				masaCiala.setText(Main.bundle.getString("gym.bad_weight"));
			}
			try {
				wzrost.setPromptText("ex. 1.92?..");
				wzrostDouble = Double.parseDouble(wzr);
			} catch (NumberFormatException e) {
				wzrost.setText(Main.bundle.getString("gym.bad_height"));
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