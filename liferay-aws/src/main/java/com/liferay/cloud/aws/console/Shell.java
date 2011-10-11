package com.liferay.cloud.aws.console;

import java.util.List;

/**
 * Basic interface for a console
 * 
 * @author migue
 * 
 */
public interface Shell {

	/**
	 * Executes the command
	 * 
	 * @param command
	 *            Command to be executed in the console
	 */
	public void execute(String command);

	public List<String> getCompletions(String prefix);

	public String prompt();
}
