/**
 * 
 */
package com.liferay.cloud.aws.console.impl;

import java.io.IOException;
import java.util.List;

import jline.ConsoleReader;

import com.liferay.cloud.aws.console.Shell;

/**
 * @author migue
 * 
 */
public class JLineShell implements Shell {

	public JLineShell() throws IOException {
		this.consoleReader = new ConsoleReader();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.cloud.aws.console.Shell#execute(java.lang.String)
	 * 
	 * @Override public void execute(String command) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * /* (non-Javadoc)
	 * 
	 * @see com.liferay.cloud.aws.console.Shell#getCompletions(java.lang.String)
	 */
	@Override
	public List<String> getCompletions(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.cloud.aws.console.Shell#prompt()
	 */
	@Override
	public String prompt() {
		// TODO Auto-generated method stub
		return null;
	}

	protected ConsoleReader consoleReader;

	@Override
	public void execute(String command) {
		// TODO Auto-generated method stub

	}
}
