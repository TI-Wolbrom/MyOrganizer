//
// Created by Patryk Tyliba [2017]
//

package konkurs.taskmodules.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TaskManager {
	private static LinkedHashMap<LocalDateTime, Task> tasks = new LinkedHashMap<>();
	private static Thread tasksThread = null;
	private static boolean doTasksUpdate = false;
	
	public static void initialize() {
		doTasksUpdate = true;
		
		tasksThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(doTasksUpdate) {
					try {
						updateTasks();
						
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		tasksThread.start();
	}
	
	public static void shutdown() {
		doTasksUpdate = false;
		clearTasks();
	}
	
	private static void updateTasks() {
		System.out.println("TaskManager.updateTasks()");
		
		Iterator<Map.Entry<LocalDateTime, Task>> it = tasks.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<LocalDateTime, Task> entry = it.next();

			LocalDateTime now = LocalDateTime.now();
			LocalDateTime ldt = entry.getKey();
			
			Task task = entry.getValue();
			
			if(now.isAfter(ldt)) {
				task.onTaskComplete();
				task.onTaskRemove();
				it.remove();
			}
		}
	}
	
	public static void exportTaskToFile(Task task) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("task-" + task.getTaskDescription().length() + 1 + "-" + task.getTaskName().length() + 4 + "_" + task.getTaskDate().getNano()));
			oos.writeObject(task);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTask(Task task) {
		System.out.println("Creating task: \"" + task.getTaskName() + "\" with date: {" + task.getTaskDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "}");
		task.onTaskAdd();
		tasks.put(task.getTaskDate(), task);
	}
	
	public static void clearTasks() {
		tasks.clear();
	}
}

