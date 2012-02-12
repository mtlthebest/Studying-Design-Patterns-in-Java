package wbs;

import java.util.List;

public abstract class Task{

	public String name;
	public List<Task> subTasks;
	public Task superTask;
	
	public Task(String name, Task superTask){
		this.name = name;
		this.superTask = superTask;
	}
	
	abstract public Long getTimeRequired();
	
}
