import java.util.List;

import command.CommandFactory;
import command.CommandInterface;


public class Main {
	public static void main(String[] args) throws Exception{
		
		CommandInterface commandInterface = new CommandFactory().createCommand(); 
		String time = commandInterface.getTime();
		System.out.println(time);
		String currentDir = commandInterface.getWorkingDirectory();
		System.out.println(currentDir);
		List<String> files = commandInterface.listFileNames();
		System.out.println(files);
	}

}
