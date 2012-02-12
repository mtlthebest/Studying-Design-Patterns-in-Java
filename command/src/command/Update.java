package command;

import my.Main;
import entity.Emp;

public class Update extends Command{
	
	Emp before;
	Emp after;
	Main main;
	
	public Update(Emp before, Emp after, Main main){
		this.before = before;
		this.after = after;
		this.main = main;
	}
	
	@Override
	public void execute() {
		dbAccess.update(after);
	}

	@Override
	public void undo() {
		dbAccess.update(before);
	}
	
	
	
}
