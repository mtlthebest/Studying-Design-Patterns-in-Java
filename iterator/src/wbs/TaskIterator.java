package wbs;

import java.util.Iterator;
import java.util.List;

public class TaskIterator implements Iterator<Task>{
	
	
	Iterator<Task> listIterator;
	Iterator<Task> taskIterator;
	Task next;

	public TaskIterator(List<Task> tasks){
		listIterator = tasks.iterator();
		next = listIterator.next();
		if(next instanceof AbstractTask){
			taskIterator = ((AbstractTask) next).iterator();
			next = taskIterator.next();
		}
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Task next() {
		Task oldNext = next;
		if(taskIterator != null && taskIterator.hasNext()){
			next = taskIterator.next();
		}else{
			if(listIterator.hasNext()){
				next = listIterator.next();
				if(next instanceof AbstractTask){
					taskIterator = ((AbstractTask) next).iterator();
					next = taskIterator.next();
				}
			}else{
				next = null;
			}
		}
		return oldNext;
	}

	@Override
	public void remove() {
		if(next == null) return;
		next.superTask.subTasks.remove(next);
	}
	
}
