package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import konkurs.AppManager;

public class EventsController {

	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    private TreeView<String> trEvents;

    @FXML
    private Button btnNewEvent;

    @FXML
    private Button btnEditEvent;

    @FXML
    private Button btnSaveAll;

    @FXML
    private Button btnReturn;

    private TreeItem<String> trEventsRoot;
    
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
    	trEventsRoot.getChildren().add(new TreeItem<String>("Test"));
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
