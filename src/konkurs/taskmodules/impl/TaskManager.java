//
// Created by Patryk Tyliba [2017]
//

package konkurs.taskmodules.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import konkurs.fx.dialogs.DialogHelper;

public class TaskManager {
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static TaskCollection taskCollection = new TaskCollection();
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static Thread tasksThread = null;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static boolean doTasksUpdate = false;
	
	// --------------------------------------------------------------------------------------------------------------------
	
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
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void shutdown() {
		doTasksUpdate = false;
		clearTasks();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static void updateTasks() {
		Iterator<Map.Entry<LocalDateTime, Task>> it = taskCollection.getTasks().entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<LocalDateTime, Task> entry = it.next();

			LocalDateTime now = LocalDateTime.now();
			LocalDateTime ldt = entry.getKey();
			
			Task task = entry.getValue();
			
			if(now.isAfter(ldt) && task.isTaskEnabled()) {				
				try {
					task.onTaskComplete();
					task.onTaskRemove();
						
					task.setTaskEnabled(false); // wylaczamy wydarzenie
					
					saveToFile();					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static boolean createTask(Task task) {
		if(!hasTask(task)) {
			taskCollection.getTasks().put(task.getTaskDate(), task);
			task.onTaskAdd();
			return true;
		}
		return false;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static boolean removeTask(Task task) {
		if(hasTask(task)) {
			taskCollection.getTasks().remove(task.getTaskDate());
			return true;
		}
		return false;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void updateTask(Task t) {
		if(taskCollection.getTasks().containsKey(t.getTaskDate())) {
			System.out.println("Updating task...");
			taskCollection.getTasks().put(t.getTaskDate(), t);
			System.out.println("UPDATED size=" + taskCollection.getTasks().size());
		}
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public static boolean hasTask(Task task) { return taskCollection.getTasks().containsKey(task.getTaskDate()); }
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void saveToFile() throws FileNotFoundException, IOException {
		if(Files.isDirectory(Paths.get("data"))) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/data_0.dat"));
			oos.writeObject(taskCollection);
			oos.close();
		} else {
			try {
				Files.createDirectory(Paths.get("data"));
			} catch (IOException e) {
				System.err.println("saveToFile() IOException :: Files.createDirectory :: data");
			}
		}
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void loadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Loading events...");
		long start = System.currentTimeMillis();
		
		Files.createDirectories(Paths.get("data"));
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/data_0.dat"));
		taskCollection = (TaskCollection) ois.readObject();
		ois.close();
		
		long end = System.currentTimeMillis() - start;
		
		System.out.println("Total events: " + getTaskCollection().getTasks().size());
		System.out.println("Done in " + end + " ms!");
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public static TaskCollection getTaskCollection() {
		return taskCollection;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void convert(Task oldT, Task newT) {
		Task task = getTaskCollection().getTaskByTaskName(oldT.getTaskName());
		
		if(task != null) oldT = newT;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void clearTasks() { taskCollection.getTasks().clear(); }
}

