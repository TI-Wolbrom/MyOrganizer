package konkurs.taskmodules.impl;

import java.time.LocalDateTime;

// WORK IN PROGRESS

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
		// TODO: Wylacz komputer
		System.out.println("Shutting down PC...");
	}
	
}
