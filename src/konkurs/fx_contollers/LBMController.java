package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.Main;
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

	@FXML
	private void initialize() {
		plec.getItems().addAll(Main.bundle.getString("gym.female"), Main.bundle.getString("gym.male"));
		plec.setPromptText(Main.bundle.getString("gym.plec"));
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
			masaCiala.setText(Main.bundle.getString("gym.bad_weight"));
		}

		try {
			wzrostDouble = Double.parseDouble(wzr);
		} catch (NumberFormatException e) {
			wzrost.setText(Main.bundle.getString("gym.bad_height"));
		}

		String female = Main.bundle.getString("gym.female");
		String male = Main.bundle.getString("gym.male");

		if (p.equalsIgnoreCase(female)) {
			try {
				wynikDouble = 0.129 * wzrostDouble + 0.384 * masaDouble;
				String wynik = Double.toString(wynikDouble);
				LBM.setText(wynik);
			} catch (Exception e) {}
		} else if (p.equalsIgnoreCase(male)) {
			try {
				wynikDouble = 0.22 * wzrostDouble + 0.278 * masaDouble;
				String wynik = Double.toString(wynikDouble);
				LBM.setText(wynik);
			} catch (Exception e) {}
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