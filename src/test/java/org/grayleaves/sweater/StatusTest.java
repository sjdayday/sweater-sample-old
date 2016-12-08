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
		Clock.setDateForTesting("10/15/2005 12:00:14 PM");
		StatusResponse.forceDelay(0); 
		StatusResponse.hang(false); 
	}
	
	@Test
	public void statusReturnsDefaultStatusResponse() {
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals("sweater-sample", statusResponse.getName()); 
		assertEquals(0, statusResponse.getDelay()); 
		assertEquals(0, statusResponse.getElapsedTime()); 
	}
	@Test
	public void delayCausesStatusToReturnAfterSetDelay() {
		ControlResponse controlResponse = target("delay/3").request().get(ControlResponse.class);  
		assertEquals("setGlobalDelay", controlResponse.getCommand()); 
		assertEquals(3, controlResponse.getGlobalDelay()); 
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals(3, statusResponse.getDelay()); 
		assertEquals(3, statusResponse.getElapsedTime()); 

		controlResponse = target("delay/0").request().get(ControlResponse.class);  
		assertEquals(0, controlResponse.getGlobalDelay()); 
		statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals(0, statusResponse.getDelay()); 
		assertEquals(0, statusResponse.getElapsedTime()); 
	}
	@Test
	public void hangCausesStatusToReturnAfterMaxValueTime() {
		ControlResponse controlResponse = target("hang").request().get(ControlResponse.class);  
		assertEquals("setHang", controlResponse.getCommand()); 
		assertEquals(Integer.MAX_VALUE, controlResponse.getGlobalDelay()); 
		assertTrue(controlResponse.isHang()); 
		StatusResponse statusResponse = target("status").request().get(StatusResponse.class);  
		assertEquals(Integer.MAX_VALUE, statusResponse.getDelay()); 
		assertEquals(Integer.MAX_VALUE, statusResponse.getElapsedTime()); 
	}
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		Clock.reset(); 
		StatusResponse.forceDelay(0); 
		StatusResponse.hang(false); 
	}
	
	
}
