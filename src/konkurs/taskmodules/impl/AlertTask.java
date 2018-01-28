package konkurs.taskmodules.impl;

import java.time.LocalDateTime;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertTask extends Task {

	// --------------------------------------------------------------------------------------------------------------------
	
	private static final long serialVersionUID = -5491458457163363827L;
	private String message;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public AlertTask(String taskName, String taskDescription, String message, LocalDateTime taskDate) {
		super(taskName, taskDescription, taskDate);
		this.setMessage(message);
	}
	
	// --------------------------------------------------------------------------------------------------------------------

	@Override
	public void onTaskComplete() {
		javafx.application.Platform.runLater(new Runnable() {	
			@Override
			public void run() {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("MyOrganizer -- Wydarzenia");
				alert.setHeaderText("Informacja!");
				alert.setContentText(message);
				alert.showAndWait();
			}
		});
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onTaskAdd() {
		
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	@Override
	public void onTaskRemove() {
		
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public String getMessage() {
		return message;
	}
	
	// --------------------------------------------------------------------------------------------------------------------

	public void setMessage(String message) {
		this.message = message;
	}

	// --------------------------------------------------------------------------------------------------------------------

	@Override
	public Task copy() {
		return new AlertTask(getTaskName(), getTaskDescription(), getMessage(), getTaskDate());
	}

	// --------------------------------------------------------------------------------------------------------------------
}
