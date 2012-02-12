package command;

import static command.utils.CommandUtils.execCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import command.utils.CommandError;

public class GNUCommand implements CommandInterface {

	@Override
	public void copyFile(String source, String destination) {
		List<String> commandLine = new ArrayList<String>();
		commandLine.add("cp");
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
		commandLine.add("mv");
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
			commandLine.add("ls");
			String stdout = execCommand(commandLine);
			filesList = Arrays.asList(stdout.split(System.getProperty("line.separator")));
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return filesList;
	}

	@Override
	public String getDate() {
		String date = new String();
		try {
			List<String> commandLine = new ArrayList<String>();
			commandLine.add("date");
			date = execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String getTime() {
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
			commandLine.add("pwd");
			workingDirectoryName = execCommand(commandLine);
		} catch (CommandError e) {
			e.printStackTrace();
		}
		return workingDirectoryName;
	}

}
