package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import konkurs.AppManager;
import konkurs.Main;

public class AboutController {

	// --------------------------------------------------------------------------------------------------------------------
	
    @FXML
    private Button btnOk;
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    private WebView webView;
    
	// --------------------------------------------------------------------------------------------------------------------
    
    @FXML
    public void initialize() {
    	webView.getEngine().load(Main.class.getResource("/resources/html/About.html").toString());
    
	}
    
    @FXML
    public void onButtonOkAction(ActionEvent e) {
    	AppManager.getAppInstance().switchToMain();
    }
    
	// --------------------------------------------------------------------------------------------------------------------
    
}
