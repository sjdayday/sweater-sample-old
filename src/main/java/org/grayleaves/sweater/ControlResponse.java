package org.grayleaves.sweater;

public class ControlResponse {

	private String command = ""; 
	private int globalDelay; 
	
	public ControlResponse() {
	}
	
	public void setGlobalDelay(int delay) {
		StatusResponse.forceDelay(delay); 
		setCommand("setGlobalDelay");
		globalDelay = delay; 
	}
	public int getGlobalDelay() {
		return globalDelay;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
