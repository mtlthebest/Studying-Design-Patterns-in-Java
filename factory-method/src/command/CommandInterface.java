package command;

import java.util.List;

public interface CommandInterface {
	/**
	 * Copy file.
	 * @param source copy source file.
	 * @param destintion copy destination file.
	 */
	public void copyFile(String source, String destination);
	
	/**
	 * Move file.
	 * @param source
	 * @param destination
	 */
	public void moveFile(String source, String destination);
	
	/**
	 * List files.
	 * @return Listed file names.
	 */
	public List<String> listFileNames();
	
	/**
	 * Get today's date in string.
	 * @return date in string.
	 */
	public String getDate();
	
	/**
	 * Get current time in string.
	 * @return time in string.
	 */
	public String getTime();
	
	/**
	 * Create  a directory.
	 * @param directoryName Name of directory to create.
	 */
	public void createDirectory(String directoryName);
	
	/**
	 * Get current directory path.
	 * @return current directoryt path.
	 */
	public String getWorkingDirectory();
	
}


