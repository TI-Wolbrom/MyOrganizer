package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class LBMController {

	@FXML
	private Button btnReturn;

	@FXML
	private ComboBox<String> plec;

	@FXML
	private Button oblicz;

	@FXML
	private TextField masaCiala;

	@FXML
	private TextField wzrost;

	@FXML
	private TextField LBM;

	// dodaj minimalny wzrost i wagę
	
	@FXML
	private void initialize() {
		plec.getItems().addAll("Kobieta", "Mężczyzna");
		plec.setPromptText("Wybierz płeć");
	}

	@FXML
	public void oblicz() {
		String masa = masaCiala.getText();
		String p = plec.getValue();
		String wzr = wzrost.getText();
		double masaDouble = 0;
		double wzrostDouble = 0;
		double wynikDouble;
	
			try {
				masaDouble = Double.parseDouble(masa);
			} catch (NumberFormatException e) {
				masaCiala.setText("Masa ciała została błędnie podana");
			}
			
			try {
				wzrostDouble = Double.parseDouble(wzr);
			} catch (NumberFormatException e) {
				wzrost.setText("Wzrost został błędnie podany");
			}

			switch (p) {
				case "M�czyzna": {
				try {
					wynikDouble = 0.22 * wzrostDouble + 0.278 * masaDouble;
					String wynik = Double.toString(wynikDouble);
					LBM.setText(wynik);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
				}
				case "Kobieta": {
				try {
					wynikDouble = 0.129 * wzrostDouble + 0.384 * masaDouble;
					String wynik = Double.toString(wynikDouble);
					LBM.setText(wynik);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
				}
				default: {
	
				}
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