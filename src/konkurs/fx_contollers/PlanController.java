package konkurs.fx_contollers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import konkurs.AppManager;
import konkurs.RecordPlan;

public class PlanController {

	// --------------------------------------------------------------------------------------------------------------------
	
	ObservableList<RecordPlan> recordsFromFile = FXCollections.observableArrayList();
	ObservableList<RecordPlan> allRecords;
	File save = new File("data/dataP.bin");
	
	// --------------------------------------------------------------------------------------------------------------------	
	
    public void PlanControler(){
    }


    @FXML
    private TableView<RecordPlan> tableView;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn1;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn2;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn3;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn4;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn5;

    @FXML
    private TableColumn<RecordPlan, String> tabColumn6;
    
    @FXML
    private ContextMenu PlanContextMenu;

    @FXML
    private MenuItem cmItemSaveChanges;

    @FXML
    private MenuItem cmItemUndo;

    @FXML
    private MenuItem cmItemRedo;

    @FXML
    private MenuItem cmItemAddRow;

    @FXML
    private MenuItem cmItemDeleteRow;

    @FXML
    private MenuItem cmItemReturn;
    
    @FXML
    private Button btnReturn;

    @FXML
    private Button btnSaveChanges;

    @FXML
    private Button btnReverseChanges;
    
    // --------------------------------------------------------------------------------------------------------------------

    // KOMBINACJE KLAWISZY

    KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCodeCombination.SHORTCUT_DOWN);
    KeyCombination ctrlY = new KeyCodeCombination(KeyCode.Y, KeyCodeCombination.SHORTCUT_DOWN);
    KeyCombination ctrlN = new KeyCodeCombination(KeyCode.N, KeyCodeCombination.SHORTCUT_DOWN);
    KeyCombination ctrlS = new KeyCodeCombination(KeyCode.S, KeyCodeCombination.SHORTCUT_DOWN);
    KeyCombination delete = new KeyCodeCombination(KeyCode.DELETE);
    KeyCombination esc = new KeyCodeCombination(KeyCode.BACK_SPACE);
    
    // --------------------------------------------------------------------------------------------------------------------

	// EDYTOWANIE KOLUMN NA PODW�JNYM KLIKNI�CIU :D
	
	public void changeHourCellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setHour(editedCell.getNewValue().toString());
	}
	
	public void changeValueD1CellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setValueD1(editedCell.getNewValue().toString());
	}

	public void changeValueD2CellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setValueD2(editedCell.getNewValue().toString());
	}

	public void changeValueD3CellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setValueD3(editedCell.getNewValue().toString());
	}

	public void changeValueD4CellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setValueD4(editedCell.getNewValue().toString());
	}

	public void changeValueD5CellEvent(CellEditEvent editedCell){
		RecordPlan recordSelected = tableView.getSelectionModel().getSelectedItem();
		recordSelected.setValueD5(editedCell.getNewValue().toString());
	}
    
    // --------------------------------------------------------------------------------------------------------------------
    
	@FXML
    void onBtnReturn(ActionEvent event) {
    	AppManager.getAppInstance().switchToMain();
    }

    @FXML
    void onBtnReverseChanges(ActionEvent event) {
    }

    @FXML
    void onBtnSaveChanges(ActionEvent event) {
    	savePlan("data/dataP.bin");
    }
    
	// DODAWANIE NOWEGO RZ�DU DO TABELI
    
	@FXML
	void onItemAddRow(){
		RecordPlan newRecordPlan = new RecordPlan();
		
		// DODAWANIE DO LISTY
		
		tableView.getItems().add(newRecordPlan);
	}
	
	// USUWANIE RZ�D�W
	
	@FXML
	void onItemDeleteRow(){
		ObservableList<RecordPlan> selectedRows;
		allRecords = tableView.getItems();
		
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		
		allRecords.removeAll(selectedRows);
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void initialize() {
		
		cmItemAddRow.setAccelerator(ctrlN);
		cmItemSaveChanges.setAccelerator(ctrlS);
		cmItemUndo.setAccelerator(ctrlZ);
		cmItemRedo.setAccelerator(ctrlY);
		cmItemReturn.setAccelerator(esc);
		cmItemDeleteRow.setAccelerator(delete);
		// USTAWIENIE KOLUMN :P
		
		tabColumn1.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("hour"));
		tabColumn2.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("valueD1"));
		tabColumn3.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("valueD2"));
		tabColumn4.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("valueD3"));
		tabColumn5.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("valueD4"));
		tabColumn6.setCellValueFactory(new PropertyValueFactory<RecordPlan, String>("valueD5"));
		
		// WCZYTYWANIE DO KOLUMN

		if(!save.exists()){
			try {
				save.createNewFile();
				RecordPlan newRecordPlan = new RecordPlan();
				tableView.getItems().add(newRecordPlan);
		    	savePlan("data/dataP.bin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			tableView.setItems(readPlan("data/dataP.bin"));
		}
		// UMO�LIWIENIE EDYTOWANIA
		
		tableView.setEditable(true);
		tabColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn3.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn4.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn5.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn6.setCellFactory(TextFieldTableCell.forTableColumn());
		
		// UMO�LIWIENIE PICKNI�CIA KILKU RZ�D�W NARAZ
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	// --------------------------------------------------------------------------------------------------------------------
		
	private void savePlan(String file){
		allRecords = tableView.getItems();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<RecordPlan>(allRecords));
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ObservableList<RecordPlan> readPlan(String file){
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<RecordPlan> list = (List<RecordPlan>) ois.readObject();
			ois.close();
			
			return FXCollections.observableList(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return FXCollections.emptyObservableList();
	}
}
