package org.grayleaves.sweater;

public class ControlResponse {

	private String command = ""; 
	private int globalDelay;
	private boolean hang; 
	
	public ControlResponse() {
	}
	
	public void setGlobalDelay(int delay) {
		StatusResponse.forceDelay(delay); 
		setCommand("setGlobalDelay");
		globalDelay = delay; 
	}
	public int getGlobalDelay() {
		return StatusResponse.DELAY;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public void setHang(boolean hang) {
		StatusResponse.hang(hang);
		if (hang) {
			setCommand("setHang");
		} else {
			StatusResponse.forceDelay(globalDelay); 
		}
		this.hang = hang;
	}
	public boolean isHang() {
		return StatusResponse.HANG; 
	}
}
