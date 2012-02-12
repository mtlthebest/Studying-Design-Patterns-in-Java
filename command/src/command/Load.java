package command;

import entity.Emp;
import my.Main;

public class Load extends Command{
	
	int id;
	Main main;
	Emp before;
	
	
	public Load(Emp before, int enpno, Main main){
		id = enpno;
		this.main = main;
		this.before = before;
	}

	@Override
	public void execute() {
		System.out.println("Load:"+id);
		Emp emp = dbAccess.load(id);
		System.out.println(emp);
		main.update(emp);
	}

	@Override
	public void undo() {
		main.update(before);
	}

}
