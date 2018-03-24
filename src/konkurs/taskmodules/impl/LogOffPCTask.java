package konkurs.taskmodules.impl;

import java.io.IOException;
import java.time.LocalDateTime;

import konkurs.AppManager;

public class LogOffPCTask extends Task {

	// --------------------------------------------------------------------------------------------------------------------

	private static final long serialVersionUID = -6722081341475391315L;

	// --------------------------------------------------------------------------------------------------------------------

	public LogOffPCTask(String taskName, String taskDesc, LocalDateTime dateTime) {
		super(taskName, taskDesc, dateTime);
	}

	// --------------------------------------------------------------------------------------------------------------------

	@Override
	public void onTaskComplete() {
		// Sprawdzamy system operacyjny
		if (AppManager.OS_NAME.indexOf("win") >= 0) {
			try {
				// Dla Windows
				Runtime.getRuntime().exec("shutdown -l");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (AppManager.OS_NAME.indexOf("nix") >= 0 || AppManager.OS_NAME.indexOf("nux") >= 0
				|| AppManager.OS_NAME.indexOf("aix") > 0) {
			try {
				// Dla Linux
				Runtime.getRuntime().exec("kill -9 -1");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

}
