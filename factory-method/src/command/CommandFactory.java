package command;

public class CommandFactory {
	
	public CommandInterface createCommand() throws Exception{
		String osName = System.getProperty("os.name");
		if(osName == null) {
			throw new Exception("Unsupported OS");
		}else if(osName.startsWith("Windows")){
			return new DosCommand();
		}else if(osName.equals("Linux")){
			return new GNUCommand();
		}else if(osName.equals("Mac OS X")){
			return new GNUCommand();
		}else{
			throw new Exception("Unsupported OS");
		}
	}

}
