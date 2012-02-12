package wbs;

public class ConcreteTask extends Task{
	
	private Long timeRequired;
	

	public ConcreteTask(String name, Long timeRequired) {
		super(name);
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
