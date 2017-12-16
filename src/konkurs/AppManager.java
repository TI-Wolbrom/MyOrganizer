package konkurs;

import konkurs.taskmodules.impl.TaskManager;

public class AppManager {

	// --------------------------------------------------------------------------------------------------------------------
	
	public static final String VERSION = "0.2.0";
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
		
		// Zamykamy
		AppManager.getAppInstance().getMainStage().close();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static Main getAppInstance() {
		return appInstance;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
}
