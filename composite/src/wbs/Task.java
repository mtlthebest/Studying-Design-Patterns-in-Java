package wbs;

public abstract class Task {

	public String name;
	
	public Task(String name){
		this.name = name;
	}
	
	abstract public Long getTimeRequired();
	
	public String getName(){
		return name;
	}
	
}
