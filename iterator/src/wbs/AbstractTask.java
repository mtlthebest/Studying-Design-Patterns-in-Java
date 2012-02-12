package wbs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractTask extends Task implements Iterable<Task>{

	public AbstractTask(String name, Task superTask) {
		super(name, superTask);
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


	@Override
	public Iterator<Task> iterator() {
		return new TaskIterator(this.subTasks);
	}
	
}
