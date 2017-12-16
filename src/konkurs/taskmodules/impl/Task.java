//
// Created by Patryk Tyliba [2017]
//

package konkurs.taskmodules.impl;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Task implements Serializable {

	// Nazwa zadania
	private String taskName;
	
	// Opis zadania
	private String taskDescription;
	
	// Data w ktorej zawarta jest informacja kiedy nasze zadanie
	// ma sie wykonac
	private LocalDateTime taskDate;
	
	// Czy wydarzenie jest wlaczone
	private boolean taskEnabled;
	
	public Task(String taskName, String taskDescription, LocalDateTime taskDate) {
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		
		setTaskDate(taskDate);
		setTaskEnabled(true);
	}
	
	public void onTaskComplete() {
		
	}
	
	public void onTaskAdd() {
		
	}
	
	public void onTaskRemove() {
		
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}

	public LocalDateTime getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDateTime taskDate) {
		this.taskDate = taskDate;
	}

	public boolean isTaskEnabled() {
		return taskEnabled;
	}

	public void setTaskEnabled(boolean taskEnabled) {
		this.taskEnabled = taskEnabled;
	}
	
}

