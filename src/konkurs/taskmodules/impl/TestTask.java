package konkurs.taskmodules.impl;

import java.time.LocalDateTime;

public class TestTask extends Task {

	public TestTask(LocalDateTime taskDate) {
		super("Test Task", "Testowe zadanie", taskDate);
	}

	@Override
	public void onTaskComplete() {
		System.out.println("Test task! Done!");
	}

	@Override
	public void onTaskAdd() {
		System.out.println("TestTask.onTaskAdd()");
	}

	@Override
	public void onTaskRemove() {
		System.out.println("TestTask.onTaskRemove()");
	}

}
