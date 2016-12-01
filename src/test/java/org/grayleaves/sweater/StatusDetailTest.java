package org.grayleaves.sweater;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusDetailTest {

	private StatusDetail status;

	@Test
	public void defaultsToNameWithNoDelay() {
		status = new StatusDetail(); 
		assertEquals(0, status.getDelay());
		assertEquals("sweater-sample", status.getName());
	}
	@Test
	public void testName() throws Exception {
		//clock.getCurrentTime
		// buildResponse
		//
	}
}
