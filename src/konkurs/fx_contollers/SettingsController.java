package konkurs.fx_contollers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import konkurs.AppManager;
import konkurs.Settings;

public class SettingsController {

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    private ChoiceBox<String> choiceBoxLang;

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnReturn;

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    private CheckBox chbSettings;

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    private void initialize() {
        choiceBoxLang.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                AppManager.getAppInstance().getSettings().setLangInterfaceByName(choiceBoxLang.getItems().get( (Integer) newValue));
            }
        });

        Settings s = AppManager.getAppInstance().getSettings();

        chbSettings.setSelected(s.updatesEnabled);

        switch(s.langInterface) {
            case PL:
                choiceBoxLang.setValue("Polski");
                break;
            case EN:
                choiceBoxLang.setValue("English");
                break;
            case DE:
                choiceBoxLang.setValue("Deutsch");
                break;
            default:
                choiceBoxLang.setValue("Polski");
                break;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    public void onButtonReturn(ActionEvent e) {
        AppManager.getAppInstance().switchToMain();
    }

    // -----------------------------------------------------------------------------------------------------------------------------

    @FXML
    public void onUpdateCheckboxEvent(ActionEvent e) {
        AppManager.getAppInstance().getSettings().updatesEnabled = chbSettings.isSelected();
    }
}
