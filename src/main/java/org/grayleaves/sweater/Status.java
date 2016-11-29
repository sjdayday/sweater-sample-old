package org.grayleaves.sweater;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/status")
public class Status {

	@GET
	public String message() {
		return "Sweater sample"; 
	}
	
}
