package konkurs.fx_contollers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import konkurs.Main;

public class NormalDialogController {
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private Stage stage;
	
	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    public Label detailsLabel;

    @FXML
    private HBox okParent;

    @FXML
    private Button okButton;
    
    @FXML
    private ImageView imgIcon;
    
	// --------------------------------------------------------------------------------------------------------------------
    
    private Image alertImg;
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private void initialize() {
    	Platform.runLater(new Runnable() {
			@Override
			public void run() {
				stage = (Stage) okButton.getScene().getWindow();

		    	stage.getIcons().add(alertImg);
			}
		});
    	
    	alertImg = new Image(Main.class.getResource("/resources/fxml/other_icons/alert.png").toExternalForm());
    	imgIcon.setImage(alertImg);
    }
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onOkClick(MouseEvent event) {
    	stage.close();
    }
}
