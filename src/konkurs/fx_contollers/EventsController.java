package konkurs.fx_contollers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import konkurs.AppManager;
import konkurs.fx.dialogs.DialogHelper;
import konkurs.taskmodules.impl.AlertTask;
import konkurs.taskmodules.impl.Task;
import konkurs.taskmodules.impl.TaskManager;

public class EventsController {

	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    private TreeView<String> trEvents;

    // --------------------------------------------------------------------------------------------------------------------

    private TreeItem<String> trEventsRoot; // NOT FXML

    // --------------------------------------------------------------------------------------------------------------------

    private boolean editMode;

    // --------------------------------------------------------------------------------------------------------------------

    private Task taskInEdit = null;
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private TextField txtEventName;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField txtEventDescription;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextField txtEventTime;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private DatePicker txtEventDate;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private CheckBox chbEventDisabled;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private CheckBox chbShowMessage;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private TextArea txtMessageToShow;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnNewEvent;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnEditEvent;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnSaveAll;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnRemoveEvent;

    // --------------------------------------------------------------------------------------------------------------------

    @FXML
    private Button btnReturn;
    
	// --------------------------------------------------------------------------------------------------------------------

    @FXML
	private void initialize() {
    	setEditMode(false);
    	
    	trEventsRoot = new TreeItem<>("Zaplanowane wydarzenia");
    	trEvents.setRoot(trEventsRoot);
    	
		updateEventsVisual();
	}

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnEditEvent(ActionEvent event) {
    	if(taskInEdit == null) {
	    	Task selectedTask = TaskManager.getTaskCollection().getTaskByTaskName(trEvents.getSelectionModel().getSelectedItem().getValue());

	    	setTaskInEdit(selectedTask);
	    	applyFor(selectedTask);
	    	
	    	btnNewEvent.setText("Zastosuj");
	    	
	    	setEditMode(true);
	    	btnEditEvent.setDisable(true);
    	}
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnNewEvent(ActionEvent event) {
    	// Sprawdzamy czy wszystkie pola zostaly
    	// poprawnie wypelnione
    	boolean isOK = txtEventName.getText().matches("^.{1,64}$") 
    			&& txtEventDescription.getText().matches("^.{1,64}$") 
    			&& txtEventTime.getText().matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") || txtEventTime.getText().matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$")
    			&& txtEventDate.getValue() != null;
    	
    	// Jezeli zostaly poprawnie wypelnione
    	// to dodajemy je do listy wydarzen
    	if(isOK) {
    		// Pobieramy date z pola txtEventDate
    		LocalDate eDate = txtEventDate.getValue();
    		// Pobieramy czas z pola txtEventTime
    		LocalDateTime ldt = LocalDateTime.of(eDate, LocalTime.parse(txtEventTime.getText(), DateTimeFormatter.ISO_LOCAL_TIME));
    		
    		// Sprawdzamy teraz czy uzytkownik nie ma wlaczonego trybu EditMode
    		// czyli czy nie edytuje istniejacego juz wydarzenia
    		if(isEditMode()) {
    			Task nowTaskCp = taskInEdit.copy();
    			saveTaskFromFields();

    			updateEventsVisual();
    			clearFields();

    			/*btnNewEvent.setText("Nowe wydarzenie");
    			setEditMode(false);
    			setTaskInEdit(null);*/

    			boolean same = taskInEdit.getTaskName().equalsIgnoreCase(nowTaskCp.getTaskName());
    			if(same) {  			
    				TaskManager.updateTask(taskInEdit);
					
    				updateEventsVisual();
    				clearFields();
    				
    				onBtnSaveAll(null);
    				
        			btnNewEvent.setText("Nowe wydarzenie");
        			setEditMode(false);
        			setTaskInEdit(null);
    			} else {   				
    				if(TaskManager.getTaskCollection().getTaskByTaskName(taskInEdit.getTaskName()) != null) {			
    					TaskManager.updateTask(taskInEdit);
    					
    					updateEventsVisual();
    					clearFields();

        				onBtnSaveAll(null);
    					
            			btnNewEvent.setText("Nowe wydarzenie");
            			setEditMode(false);			
            			setTaskInEdit(null);
    				} else {
    					btnNewEvent.setText("Nowe wydarzenie");
    					setEditMode(false);
    					setTaskInEdit(null);
    					System.out.println("Not possible");
    				}
    			}

    			btnEditEvent.setDisable(false);
    		} else {	
	    		// Tworzymy nowe wydarzenie/zadanie za pomoca TaskManager.
	    		// Jezeli nie uda nam sie utworzyc tego wydarzenia/zadania (bo np. juz istnieje)
	    		// to wypisujemy blad, ze wydarzenie jest juz stworzone z ta data.
	    		boolean result = false;

	    		if(chbShowMessage.isSelected())
					result = TaskManager.createTask(new AlertTask(txtEventName.getText(), txtEventDescription.getText(), txtMessageToShow.getText(), ldt));
	    		else
					result = TaskManager.createTask(new Task(txtEventName.getText(), txtEventDescription.getText(), ldt));
	    		
	    		if(result) {
	        		// Dodajemy do drzewka z wydarzeniami
	        		trEventsRoot.getChildren().add(new TreeItem<String>(txtEventName.getText()));
	        		
	        		// Zapisujemy do pliku
	        		onBtnSaveAll(null);
	    		} else {
	    			DialogHelper.showDefaultDialog("Błąd!", "Wystąpił błąd!\nPrawdopodobnie podobne wydarzenie zostało już utworzone!\nStwórz inne wydarzenie aby dodać je do listy.");
	    		}
    		}
    	} else {
    		DialogHelper.showDefaultDialog("Uzupełnij wszystkie pola według schematu!", "Prosimy uzupełnić wszystkie pola według schematu!");
    	}
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnRemoveEvent(ActionEvent event) {
    	Task t = TaskManager.getTaskCollection().getTaskByTaskName(trEvents.getSelectionModel().getSelectedItem().getValue());
    	
    	if(TaskManager.removeTask(t)) {
    		updateEventsVisual();
    		onBtnSaveAll(null);
    	}
    }
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onBtnSaveAll(ActionEvent event) {
    	try {
    		System.out.println("Saving events...");
    		long start = System.currentTimeMillis();
			TaskManager.saveToFile();
			long end = System.currentTimeMillis() - start;
			System.out.println("Total events: " + TaskManager.getTaskCollection().getTasks().size());
			System.out.println("Done in " + end + " ms!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	// --------------------------------------------------------------------------------------------------------------------
    
    private void updateEventsVisual() {
    	trEventsRoot.getChildren().clear();
    	
		for(Entry<LocalDateTime, Task> t : TaskManager.getTaskCollection().getTasks().entrySet())
	    	trEventsRoot.getChildren().add(new TreeItem<String>(t.getValue().getTaskName()));
    }
    
    // --------------------------------------------------------------------------------------------------------------------
    
    private void applyFor(Task t) {
    	if(t != null) {
    		txtEventName.setText(t.getTaskName());
    		txtEventDescription.setText(t.getTaskDescription());
    		txtEventTime.setText(t.getTaskDate().format(DateTimeFormatter.ISO_TIME));
    		txtEventDate.setValue(t.getTaskDate().toLocalDate());
    		chbEventDisabled.setSelected(!t.isTaskEnabled());	
    		if (t instanceof AlertTask) {
				AlertTask at = (AlertTask) t;
	    		txtMessageToShow.setText(at.getMessage());
				chbShowMessage.setSelected(true);
			} else {
				chbShowMessage.setSelected(false);
				txtMessageToShow.setText("");
			}
    	}
    }

    // --------------------------------------------------------------------------------------------------------------------

    private void saveTaskFromFields() {
    	taskInEdit.setTaskName(txtEventName.getText());
    	taskInEdit.setTaskDescription(txtEventDescription.getText());
    	taskInEdit.setTaskEnabled(!chbEventDisabled.isSelected());
    	taskInEdit.setTaskDate(LocalDateTime.of(txtEventDate.getValue(), LocalTime.parse(txtEventTime.getText())));  	
    	if(taskInEdit instanceof AlertTask) {
    		AlertTask at = (AlertTask) taskInEdit;
    		at.setMessage(txtMessageToShow.getText());
    	}
    }

    // --------------------------------------------------------------------------------------------------------------------

    private void clearFields() {
    	txtEventName.setText("");
    	txtEventDescription.setText("");
    	txtEventDate.setValue(null);
    	txtEventTime.setText("");
    	txtMessageToShow.setText("");
    	chbEventDisabled.setSelected(false);
    	chbShowMessage.setSelected(false);
    }

    // --------------------------------------------------------------------------------------------------------------------

	public boolean isEditMode() {
		return editMode;
	}

    // --------------------------------------------------------------------------------------------------------------------

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

    // --------------------------------------------------------------------------------------------------------------------

	public Task getTaskInEdit() {
		return taskInEdit;
	}

    // --------------------------------------------------------------------------------------------------------------------

	public void setTaskInEdit(Task taskInEdit) {
		this.taskInEdit = taskInEdit;
	}
    
	// --------------------------------------------------------------------------------------------------------------------
    
}
