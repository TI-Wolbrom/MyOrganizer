package konkurs;

import javafx.application.Platform;

public class AppManager {

	private static Main appInstance;
	
	public static void applyMain(Main m) {
		appInstance = m;
	}
	
	public static void closeApp() {
		// Moze byc przyczyna problemow
		// na razie zostawiamy jednak tak
		Platform.exit();
	}
}
