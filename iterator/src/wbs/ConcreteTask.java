package wbs;


public class ConcreteTask extends Task{
	
	Long timeRequired;

	public ConcreteTask(String name, Long timeRequired, Task superTask) {
		super(name, superTask);
		this.timeRequired = timeRequired;
	}

	public void setTimeRequired(Long timeRequired) {
		this.timeRequired = timeRequired;
	}

	@Override
	public Long getTimeRequired() {
		return this.timeRequired;
	}
	

}
