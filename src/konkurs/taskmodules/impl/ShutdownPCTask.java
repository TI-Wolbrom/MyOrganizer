package konkurs.taskmodules.impl;

import java.io.IOException;
import java.time.LocalDateTime;

import konkurs.AppManager;

public class ShutdownPCTask extends Task {

	// --------------------------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = -302969787102664059L;

	// --------------------------------------------------------------------------------------------------------------------

	public ShutdownPCTask(String taskName, String taskDesc, LocalDateTime dateTime) {
		super(taskName, taskDesc, dateTime);
	}

	// --------------------------------------------------------------------------------------------------------------------

	@Override
	public void onTaskComplete() {
		// Sprawdzamy system operacyjny
		if (AppManager.OS_NAME.indexOf("win") >= 0) {
			try {
				// Dla Windows
				Runtime.getRuntime().exec("shutdown -s");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (AppManager.OS_NAME.indexOf("nix") >= 0 || AppManager.OS_NAME.indexOf("nux") >= 0
				|| AppManager.OS_NAME.indexOf("aix") > 0) {
			try {
				// Dla Linux
				Runtime.getRuntime().exec("shutdown -h now");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
