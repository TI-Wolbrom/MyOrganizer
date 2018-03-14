package konkurs.fx_contollers;

import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;

public class addPlanTController {

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

	private int i = 0;
	
	@FXML
	public void onBtnReturn(ActionEvent event) {
		try {
			AppManager.getAppInstance().buildPlanTEditor();
			i = 0;
			}catch (Exception ex) {
			DialogHelper.showExceptionDialog(ex);
			ex.printStackTrace();
			AppManager.closeApp();
			}
	}

	@FXML
	public void dodaj(ActionEvent event) {
		String cwiczText = cwicz.getText();
		String powtText = powt.getText();
		String czassText = czas.getText();
		Label cwiczenie = new Label();
		Label powtorz = new Label();
		Label czass = new Label();
		cwiczenie.setText(cwiczText);
		powtorz.setText(powtText);
		czass.setText(czassText);
		grid.add(cwiczenie, 0, i);
		grid.add(powtorz, 1, i);
		grid.add(czass, 2, i);
		i++;
	}
	@FXML
	public void zapisz(ActionEvent event) {
		String nazwaPlanu=nazwa.getText();

	}

}