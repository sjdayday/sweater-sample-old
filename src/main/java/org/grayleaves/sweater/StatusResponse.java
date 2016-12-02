package org.grayleaves.sweater;

import org.grayleaves.utility.Clock;

class StatusResponse {
		private static final String NAME = "sweater-sample"; 
		protected static int DELAY = 0;
		protected static boolean HANG = false; 
		
		public static void forceDelay(int delay) {
			DELAY = delay; 
		}
		public static void hang(boolean hang) {
			HANG  = hang; 
		}


		private int delay;
		private long elapsedTime;
		private Clock clock;
		
		public StatusResponse() {
//			delay = 0; 
			clock = new Clock(); 
			clock.start(); 
		}
		public void delay() {
			if (HANG) {
				Clock.sleep(Integer.MAX_VALUE); 
			}
			else if (DELAY > 0) {
				Clock.sleep(DELAY); 
			}
			clock.stop();
			setElapsedTime(clock.getElapsedTime()); 
		}
		public String getName() {
			return NAME;
		}
		/**
		 * MOXy apparently requires Javabean accessor methods  
		 * @param name (unused)
		 */
		public void setName(String name) {
		}
		public int getDelay() {
			return DELAY; 
//			return delay;
		}
		public void setDelay(int delay) {
//			this.delay = delay;
		}
		public long getElapsedTime() {
			return elapsedTime;
		}
		public void setElapsedTime(long milliseconds) {
			elapsedTime = milliseconds; 
		}
	}
