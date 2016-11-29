package org.grayleaves.sweater;

class DetailedStatus {
		private String service; 
		private String status;
		private int delay;
		public DetailedStatus() {
			service = "sweater-sample";
			status = "up";
			delay = 20; 
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getDelay() {
			return delay;
		}
		public void setDelay(int delay) {
			this.delay = delay;
		}
		
	}
//	@GET
//	public String message() {
//		return "Sweater sample"; 
//	}