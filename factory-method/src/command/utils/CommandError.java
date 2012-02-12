package command.utils;

public class CommandError extends Exception {
	private int extiCode;
	
	public CommandError(int exitCode, String errorMessage){
		super(errorMessage);
		this.extiCode = exitCode;
	}
	
	public CommandError(Exception e) {
		super(e);
	}

	public int getExitCode(){
		return this.extiCode;
	}

}
