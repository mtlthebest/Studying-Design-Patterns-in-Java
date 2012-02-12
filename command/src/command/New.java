package command;

import my.Main;
import entity.Emp;

public class New extends Command{
	
	Emp emp;
	Main main;
	
	public New(Emp emp, Main main){
		this.emp = emp;
		this.main = main;
	}
	
	@Override
	public void execute() {
		dbAccess.insert(emp);
	}

	@Override
	public void undo() {
		dbAccess.delete(emp.getEmpno());
	}
	
}
