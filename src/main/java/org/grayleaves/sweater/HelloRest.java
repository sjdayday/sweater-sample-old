package org.grayleaves.sweater;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloRest {

	@GET
	public String message() {
		return "Hello, resting!!!"; 
	}
	
}
