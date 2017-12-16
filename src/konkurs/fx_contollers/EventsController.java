package konkurs.fx_contollers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;
import konkurs.taskmodules.impl.TaskManager;
import konkurs.taskmodules.impl.TestTask;

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
    	// Sprawdzamy czy wszystkie pola zostaly
    	// poprawnie wypelnione
    	boolean isOK = txtEventName.getText().matches("^.{1,64}$") 
    			&& txtEventDescription.getText().matches("^.{1,64}$") 
    			&& txtEventTime.getText().matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
    			&& txtEventDate.getValue() != null;
    	
    	// Jezeli zostaly poprawnie wypelnione
    	// to dodajemy je do listy wydarzen
    	if(isOK) {
    		// Pobieramy date z pola txtEventDate
    		LocalDate eDate = txtEventDate.getValue();
    		// Pobieramy czas z pola txtEventTime
    		LocalDateTime ldt = LocalDateTime.of(eDate, LocalTime.parse(txtEventTime.getText(), DateTimeFormatter.ISO_LOCAL_TIME));
    		
    		// Tworzymy nowe wydarzenie/zadanie (TestTask) za pomoca TaskManager.
    		// Jezeli nie uda nam sie utworzyc tego wydarzenia/zadania (bo np. juz istnieje)
    		// to wypisujemy blad, ze wydarzenie jest juz stworzone z ta data.
    		if(TaskManager.createTask(new TestTask(ldt))) {
        		// Dodajemy do drzewka z wydarzeniami
        		trEventsRoot.getChildren().add(new TreeItem<String>(txtEventName.getText()));
    		} else {
    			DialogHelper.showDefaultDialog("B³¹d!", "Wyst¹pi³ b³¹d!\nPrawdopodobnie wydarzenie z podan¹ dat¹ zosta³o ju¿ utworzone!\nStwórz nowe wydarzenie z inn¹ dat¹ aby dodaæ je listy.");
    		}
    	} else {
    		DialogHelper.showDefaultDialog("Uzupe³nij wszystkie pola!", "Prosimy uzupe³niæ wszystkie pola!");
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
