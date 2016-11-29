package org.grayleaves.sweater;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;


	@ApplicationPath("/api/v1")
	public class ApiV1App extends ResourceConfig {
	    public ApiV1App() {
	        packages("org.grayleaves.sweater");
	    }
}
