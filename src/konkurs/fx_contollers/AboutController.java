package konkurs.fx_contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import konkurs.AppManager;
import konkurs.Main;
import konkurs.Settings;

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
    	WebEngine wEngine = webView.getEngine();
    	Settings settings = AppManager.getAppInstance().getSettings();
    	
    	// Wczytuje strone o autorach zgodnie z wybranym jezykiem
    	switch(settings.langInterface) {
	    	case PL: wEngine.load(Main.class.getResource("/resources/html/About.html").toString());    break;
	    	case EN: wEngine.load(Main.class.getResource("/resources/html/About_en.html").toString()); break;
	    	case DE: wEngine.load(Main.class.getResource("/resources/html/About_de.html").toString()); break;
	    	default: wEngine.load(Main.class.getResource("/resources/html/About.html").toString());    break;
    	}
	}
    
    @FXML
    public void onButtonOkAction(ActionEvent e) {
    	AppManager.getAppInstance().switchToMain();
    }
    
	// --------------------------------------------------------------------------------------------------------------------
    
}
