package konkurs.fx_contollers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import konkurs.Main;

public class ExceptionDialogController {
	
	// ----------------------------------------------------------------------------------------------------------
	
    @FXML
    public Label messageLabel;

    @FXML
    public TextArea exceptionTextArea;

    @FXML
    private HBox actionParent;

    @FXML
    private HBox okParent;

    @FXML
    private Button okButton;

    @FXML
    private ImageView imgIcon;
    
    // ----------------------------------------------------------------------------------------------------------
    
    private Image errorImg;
    
    // ----------------------------------------------------------------------------------------------------------
    
    @FXML
    private void initialize() {				
    	errorImg = new Image(Main.class.getResource("/resources/fxml/other_icons/error.png").toExternalForm());
    	imgIcon.setImage(errorImg);
    }
    
    // ----------------------------------------------------------------------------------------------------------
    
    @FXML
    public void onOkClicked(MouseEvent event) {
    	Stage stage = (Stage) okButton.getScene().getWindow();
    	stage.close();
    }
}
