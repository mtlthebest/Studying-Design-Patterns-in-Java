package command;

public abstract class Command {
	
	DBAccess dbAccess = DBAccess.getInstance();
	
	abstract public void execute();
	
	abstract public void undo();
	
}
