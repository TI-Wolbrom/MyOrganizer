//
// Created by Patryk Tyliba [2017]
//

package konkurs.taskmodules.impl;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import konkurs.fx.dialogs.DialogHelper;

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
					} catch (Exception e) {
						DialogHelper.showExceptionDialog(e);
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
		} catch (Exception e) {
			e.printStackTrace();
			DialogHelper.showExceptionDialog(e);
		}
	}
	
	public static boolean createTask(Task task) {
		if(!tasks.containsKey(task.getTaskDate())) {
			System.out.println("Creating task: \"" + task.getTaskName() + "\" with date: {" + task.getTaskDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "}");
			
			tasks.put(task.getTaskDate(), task);
			task.onTaskAdd();
			
			return true;
		}
		
		return false;
	}
	
	public static void clearTasks() {
		tasks.clear();
	}
}

