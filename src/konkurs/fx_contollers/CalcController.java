package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import konkurs.AppManager;
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
		rodzajAktywnosci.getItems().addAll("Aerobik", "Boks", "Jazda na rowerze", "Bieganie (ok. 8km/h)",
				"Bieganie (ok. 15km/h)", "Jazda na nartach", "Koszykówka", "Siatkówka", "Skakanka",
				"Skakanie na trampolinie", "Gra w krêgle", "Jazda na deskorolce", "Spacer", "Golf");
		rodzajAktywnosci.setPromptText("Wybierz aktywnoœæ");
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
				masaCiala.setText("Masa cia³a zosta³a b³êdnie podana");
			}
			try {
				czasTreninguInt = Integer.parseInt(czasTreningu);
			} catch (NumberFormatException e) {
				czas.setText("Czas zosta³ b³êdnie podany");
			}
	
			switch (aktywnosc) {
			case "Boks": {
				try {
					spaloneKalorieInt = (0.16 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Aerobik": {
				try {
					spaloneKalorieInt = (0.12 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Jazda na rowerze": {
				try {
					spaloneKalorieInt = (0.17 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Bieganie (ok. 8km/h)": {
				try {
					spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Bieganie (ok. 15km/h)": {
				try {
					spaloneKalorieInt = (0.27 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Jazda na nartach": {
				try {
					spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Koszykówka": {
				try {
					spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Siatkówka": {
				try {
					spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Skakanka": {
				try {
					spaloneKalorieInt = (0.14 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Skakanie na trampolinie": {
				try {
					spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Gra w krêgle": {
				try {
					spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Jazda na deskorolce": {
				try {
					spaloneKalorieInt = (0.09 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Spacer": {
				try {
					spaloneKalorieInt = (0.06 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			}
			case "Golf": {
				try {
					spaloneKalorieInt = (0.09 * masaInt) * czasTreninguInt;
					String kalorie = Double.toString(spaloneKalorieInt);
					spaloneKalorie.setText(kalorie);
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