package konkurs;

import konkurs.fx.dialogs.DialogHelper;
import konkurs.taskmodules.impl.TaskManager;

public class AppManager {

	// --------------------------------------------------------------------------------------------------------------------
	
	public static final String VERSION = "0.5.0b";
	public static String OS_NAME = System.getProperty("os.name").toLowerCase();
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static Main appInstance;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void applyMain(Main m) {
		appInstance = m;
	}
	
	// --------------------------------------------------------------------------------------------------------------------

	// Tylko ta metoda powinna byc uzywana, gdy chcemy zamknac nasz program
	// jest ona najbezpieczniejsza
	public static void closeApp() {
		// Wylaczajac nasz program nie zapominajmy
		// o zamknieciu naszego TaskManagera
		TaskManager.shutdown();

		// Zapisujemy ustawienia
		try {
			Main.processSettings("save");
		} catch(Exception ex) {
			ex.printStackTrace();
			DialogHelper.showExceptionDialog(ex);
		}

		// Zamykamy
		AppManager.getAppInstance().getMainStage().close();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static Main getAppInstance() {
		return appInstance;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
}
