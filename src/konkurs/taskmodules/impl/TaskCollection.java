package konkurs.taskmodules.impl;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class TaskCollection implements Serializable {

	private static final long serialVersionUID = 4346421462029044676L;
	private LinkedHashMap<LocalDateTime, Task> tasks;
	
	public TaskCollection() {
		tasks = new LinkedHashMap<>();
	}
	
	public void setTasks(LinkedHashMap<LocalDateTime, Task> tasks) {
		this.tasks = tasks;
	}
	
	public LinkedHashMap<LocalDateTime, Task> getTasks() {
		return tasks;
	}
	
	public Task getTaskByTaskName(String taskName) {
		for(Entry<LocalDateTime, Task> e : tasks.entrySet())
			if(e.getValue().getTaskName().equalsIgnoreCase(taskName))
				return e.getValue();
		
		return null;
	}
}
