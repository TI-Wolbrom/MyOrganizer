// Patryk Tyliba

package konkurs;

import java.net.URL;

import javafx.fxml.FXMLLoader;

// W razie problemow z tym loaderem
// zamienic na zwyklego FXMLLoadera
public class CustomFXMLLoader extends FXMLLoader {

	// --------------------------------------------------------------------------------------------------------------------
	
	public CustomFXMLLoader() {
		super();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void setLocation(URL location) {
		resetStuffs();
		
		super.setLocation(location);
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public void resetStuffs() {
		if(getRoot() != null)
			setRoot(null);
		if(getController() != null)
			setController(null);
	}

	// --------------------------------------------------------------------------------------------------------------------
}
