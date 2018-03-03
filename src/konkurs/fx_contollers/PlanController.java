package konkurs.fx_contollers;

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

	// EDYTOWANIE KOLUMN NA PODWÓJNYM KLIKNIÊCIU :D
	
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
    	savePlan("res/dataP.bin");
    }
    
	// DODAWANIE NOWEGO RZÊDU DO TABELI
    
	@FXML
	void onItemAddRow(){
		RecordPlan newRecordPlan = new RecordPlan();
		
		// DODAWANIE DO LISTY
		
		tableView.getItems().add(newRecordPlan);
	}
	
	// USUWANIE RZÊDÓW
	
	@FXML
	void onItemDeleteRow(){
		ObservableList<RecordPlan> selectedRows;
		allRecords = tableView.getItems();
		
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		
		allRecords.removeAll(selectedRows);
	}
	
	// --------------------------------------------------------------------------------------------------------------------

//	private void KeyListener(KeyEvent e){
//		if(e.getCode() == KeyCode.ESCAPE){
//	    	AppManager.getAppInstance().switchToMain();
//		}
//	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void initialize() {
		
//		try {
//			temp = Files.createTempFile("records", "res");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
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
		
		tableView.setItems(readPlan("res/dataP.bin"));

		// UMO¯LIWIENIE EDYTOWANIA
		
		tableView.setEditable(true);
		tabColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn2.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn3.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn4.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn5.setCellFactory(TextFieldTableCell.forTableColumn());
		tabColumn6.setCellFactory(TextFieldTableCell.forTableColumn());
		
		// UMO¯LIWIENIE PICKNIÊCIA KILKU RZÊDÓW NARAZ
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
//	public ObservableList<RecordPlan> getRecords(){
//		record.add(new RecordPlan("8:00 - 8:45", "PR", "AS", "ZE", "K", "<3"));
//		record.add(new RecordPlan("8:01 - 8:45", "PRa", "S", "ZE", "K", "<3"));
//		record.add(new RecordPlan("8:02 - 8:45", "PRas", "", "ZE", "K", "<3"));
//		record.add(new RecordPlan("8:03 - 8:45", "PRasz", "", "E", "K", "<3"));
//		record.add(new RecordPlan("8:04 - 8:45", "PRasze", "", "", "K", "<3"));
//		record.add(new RecordPlan("8:05 - 8:45", "PRaszek", "", "", "", "<3"));
//		record.add(new RecordPlan("8:06 - 8:45", "PRaszek<", "", "", "", "3"));
//		record.add(new RecordPlan("8:07 - 8:45", "PRaszek<3", "", "", "", ""));
//		
//		return record;
//	}
	
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
	
//	class EditingCell extends TableCell<RecordPlan, String>{
//		
//	}
	
}

