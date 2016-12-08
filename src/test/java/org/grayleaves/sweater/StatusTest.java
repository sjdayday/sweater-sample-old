package org.grayleaves.sweater;

import static org.junit.Assert.*;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.grayleaves.utility.Clock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatusTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ApiV1App();
	}
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		StatusResponse.DELAY = 0; 
		Clock.setDateForTesting("10/15/2005 12:00:14 PM");
	}
	
	@Test
	public void statusReturnsDefaultStatusResponse() {
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals("sweater-sample", statusResponse.getName()); 
		assertEquals(0, statusResponse.getDelay()); 
		assertEquals(0, statusResponse.getElapsedTime()); 
	}
	@Test
	public void statusReturnsAfterDelay() {
		StatusResponse.forceDelay(3); 
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals(3, statusResponse.getDelay()); 
		assertEquals(3, statusResponse.getElapsedTime()); 
	}
	@Test
	public void hangReturnsAfterMaxValueTime() {
		StatusResponse.hang(true); 
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals(Integer.MAX_VALUE, statusResponse.getDelay()); 
		assertEquals(Integer.MAX_VALUE, statusResponse.getElapsedTime()); 
	}
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		Clock.reset(); 
	}
	
	
}
