package konkurs;

import javafx.application.Platform;
import konkurs.taskmodules.impl.TaskManager;

public class AppManager {

	// --------------------------------------------------------------------------------------------------------------------
	
	public static final String VERSION = "0.1.8a";
	public static String OS_NAME = System.getProperty("os.name").toLowerCase();
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static Main appInstance;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void applyMain(Main m) {
		appInstance = m;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void closeApp() {
		// Wylaczajac nasz program nie zapominajmy
		// o zamknieciu naszego TaskManagera
		TaskManager.shutdown();
		
		// Moze byc przyczyna problemow
		// na razie zostawiamy jednak tak
		Platform.exit();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static Main getAppInstance() {
		return appInstance;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
}
