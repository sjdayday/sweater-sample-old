package org.grayleaves.sweater;

import static org.junit.Assert.*;

import org.grayleaves.utility.Clock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatusResponseTest {

	private StatusResponse status;

	@Before
	public void setUp()
    {
        Clock.resetClock();
    }
	@Test
	public void defaultsToNameWithNoDelay() {
		status = new StatusResponse(); 
		assertEquals(0, status.getDelay());
		assertEquals("sweater-sample", status.getName());
	}
	@Test
	public void calculatesElapsedTime() throws Exception {
        Clock.setDateForTesting("10/15/2005 12:00:14 PM");
		status = new StatusResponse(); 
		Clock.sleep(1); 
		status.delay();
		assertEquals(1, status.getElapsedTime()); 
	}
	@Test
	public void responseDelaysByDelayAmount() throws Exception {
		StatusResponse.forceDelay(20); 
		Clock.setDateForTesting("10/15/2005 12:00:14 PM");
		status = new StatusResponse(); 
		status.delay();
		assertEquals(20, status.getElapsedTime()); 
	}
	@After
	public void tearDown()
	{
		Clock.resetClock();
	}
}
