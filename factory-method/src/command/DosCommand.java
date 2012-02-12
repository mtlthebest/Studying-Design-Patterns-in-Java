package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import command.utils.CommandError;

import static command.utils.CommandUtils.*;

public class DosCommand implements CommandInterface {

	@Override
	public void copyFile(String source, String destination) {
		List<String> commandLine = new ArrayList<String>();
		commandLine.add("copy");
		commandLine.add(source);
		commandLine.add(destination);
		try {
			execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
	}

	@Override
	public void moveFile(String source, String destination) {
		List<String> commandLine = new ArrayList<String>();
		commandLine.add("move");
		commandLine.add(source);
		commandLine.add(destination);
		try {
			execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> listFileNames() {
		List<String> filesList = new ArrayList<String>();
		try {
			List<String> commandLine = new ArrayList<String>();
			commandLine.add("dir");
			String stdout = execCommand(commandLine);
			filesList = Arrays.asList(stdout.split(System.getProperty("line.separator")));
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return filesList;
	}

	@Override
	public String getDate() {
		String time = new String();
		try {
			List<String> commandLine = new ArrayList<String>();
			commandLine.add("date");
			time = execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public String getTime() {
		String time = new String();
		try {
			List<String> commandLine = new ArrayList<String>();
			commandLine.add("time");
			time = execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return time;
	}

	@Override
	public void createDirectory(String directoryName) {
		List<String> commandLine = new ArrayList<String>();
		commandLine.add("mkdir");
		commandLine.add(directoryName);
		try {
			execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getWorkingDirectory() {
		String workingDirectoryName = new String();
		try {
			List<String> commandLine = new ArrayList<String>();
			commandLine.add("chdir");
			workingDirectoryName = execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return workingDirectoryName;
	}

}
