package org.grayleaves.sweater;

class StatusDetail {
		private static final String NAME = "sweater-sample"; 
		private int delay;
		public StatusDetail() {
			delay = 0; 
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
			return delay;
		}
		public void setDelay(int delay) {
			this.delay = delay;
		}
	}
