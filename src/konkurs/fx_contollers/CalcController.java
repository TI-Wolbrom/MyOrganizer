package konkurs.fx_contollers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import konkurs.AppManager;
import konkurs.Main;
import konkurs.fx.dialogs.DialogHelper;

public class CalcController {

	@FXML
	private Button btnReturn;

	@FXML
	private Button oblicz;

	@FXML
	private ComboBox<String> rodzajAktywnosci;

	@FXML
	private TextField masaCiala;

	@FXML
	private TextField spaloneKalorie;

	@FXML
	private TextField czas;

	@FXML
	private void initialize() {
		rodzajAktywnosci.getItems().addAll
		(
				Main.bundle.getString("gym.aerobik"), 
				Main.bundle.getString("gym.boks"), 
				Main.bundle.getString("gym.jazda_row"), 
				Main.bundle.getString("gym.bieg8"),
				Main.bundle.getString("gym.bieg15"), 
				Main.bundle.getString("gym.jazda_n"), 
				Main.bundle.getString("gym.koszykowka"), 
				Main.bundle.getString("gym.siatkowka"), 
				Main.bundle.getString("gym.skakanka"),
				Main.bundle.getString("gym.trampolina"), 
				Main.bundle.getString("gym.kregle"),
				Main.bundle.getString("gym.jazda_d"), 
				Main.bundle.getString("gym.spacer"), 
				Main.bundle.getString("gym.golf")
		);
		
		rodzajAktywnosci.setPromptText(Main.bundle.getString("gym.wyb_rodz_akt"));
	}

	@FXML
	public void oblicz() {		
		String aktywnosc = rodzajAktywnosci.getValue();
		String masa = masaCiala.getText();
		String czasTreningu = czas.getText();
		double masaInt = 0;
		int czasTreninguInt = 0;
		double spaloneKalorieInt;
		try {
			masaInt = Double.parseDouble(masa);
		} catch (NumberFormatException e) {
			masaCiala.setText(Main.bundle.getString("gym.bad_weight"));
		}
		try {
			czasTreninguInt = Integer.parseInt(czasTreningu);
		} catch (NumberFormatException e) {
			czas.setText(Main.bundle.getString("gym.bad_time"));
		}

		if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.aerobik"))) {
			try {
				spaloneKalorieInt = (0.12 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.boks"))) {
			try {
				spaloneKalorieInt = (0.16 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.jazda_row"))) {
			try {
				spaloneKalorieInt = (0.17 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.bieg8"))) {
			try {
				spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.bieg15"))) {
			try {
				spaloneKalorieInt = (0.27 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.jazda_n"))) {
			try {
				spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.koszykowka"))) {
			try {
				spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.siatkowka"))) {
			try {
				spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.skakanka"))) {
			try {
				spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.trampolina"))) {
			try {
				spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.kregle"))) {
			try {
				spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.jazda_d"))) {
			try {
				spaloneKalorieInt = (0.09 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.spacer"))) {
			try {
				spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
			} catch (Exception e) {}
		} else if(aktywnosc.equalsIgnoreCase(Main.bundle.getString("gym.golf"))) {
			try {
				spaloneKalorieInt = (0.09 * masaInt) * czasTreninguInt;
				String kalorie = Double.toString(spaloneKalorieInt);
				spaloneKalorie.setText(kalorie);
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