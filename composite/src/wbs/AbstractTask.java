package wbs;

import java.util.ArrayList;
import java.util.List;

public class AbstractTask extends Task{

	public List<Task> subTasks;
	
	public AbstractTask(String name) {
		super(name);
		this.subTasks = new ArrayList<Task>();
	}


	@Override
	public Long getTimeRequired() {
		Long totalTime = 0L;
		for(Task subTask : this.subTasks){
			totalTime += subTask.getTimeRequired();
		}
		return totalTime;
	}
	
}
