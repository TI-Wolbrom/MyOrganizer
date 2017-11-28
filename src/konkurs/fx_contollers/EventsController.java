package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import konkurs.AppManager;

public class EventsController {

	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    private TreeView<String> trEvents;

    private TreeItem<String> trEventsRoot; // NOT FXML
    
    @FXML
    private TextField txtEventName;

    @FXML
    private TextField txtEventDescription;

    @FXML
    private TextField txtEventTime;

    @FXML
    private DatePicker txtEventDate;

    @FXML
    private CheckBox chbEventDisabled;

    @FXML
    private CheckBox chbShowMessage;

    @FXML
    private Button btnNewEvent;

    @FXML
    private Button btnEditEvent;

    @FXML
    private Button btnSaveAll;

    @FXML
    private Button btnReturn;
    
	// --------------------------------------------------------------------------------------------------------------------

    @FXML
	private void initialize() {
    	trEventsRoot = new TreeItem<>("Zaplanowane wydarzenia");
    	
    	trEvents.setRoot(trEventsRoot);
	}

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnEditEvent(ActionEvent event) {
    	
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnNewEvent(ActionEvent event) {
    	boolean isOK = txtEventName.getText().matches("^.{1,64}$") 
    			&& txtEventDescription.getText().matches("^.{1,64}$") 
    			&& txtEventTime.getText().matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
    			&& txtEventDate.getValue() != null;
    	
    	if(isOK) {
    		//TODO:
    		//LocalDate eDate = txtEventDate.getValue();
    		//LocalDateTime ldt = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
    		
    		trEventsRoot.getChildren().add(new TreeItem<String>(txtEventName.getText()));
    	}
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnSaveAll(ActionEvent event) {

    }

	// --------------------------------------------------------------------------------------------------------------------
    
}
