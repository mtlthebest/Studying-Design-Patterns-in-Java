package command;

import entity.Emp;

public class Delete extends Command{

	Emp before;
	int id;

	public Delete(Emp emp, int id){
		before = emp;
		this.id = id;
	}
	
	@Override
	public void execute() {
		dbAccess.delete(id);
		
	}

	@Override
	public void undo() {
		dbAccess.insert(before);
	}

}
