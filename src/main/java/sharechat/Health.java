package sharechat;

public class Health {
	/*
	 * Health Metrics Platform 
	 * Customer
	 * 
	 * Register new Device
	 * Device should be able to
	 * push data to Platform
	 * User should be able to see metrics across all devices
	 * (aggregated over week/daily/monthly etc)
	 *  
	 *  Admin
	 *  Should be able to add new
	 * Metrics types (ex. Height , Weight, BP etc)
	 */
	
	
	void Registeration(Customer cus) {
		 new Customer();
		
	}
	
	void registerDevice(long customerId, DeviceType type) {
		 // create new device
		//add to customer
		//return deviceId
		
	}
	
	void fetch(String deviceType) {
		
		DeviceType.valueOf(deviceType).aggregate();
	}
	
	void pushMetric(Metrics metric, String reading, long customerId, long DeviceId) {
		
		//create entry in activity
		
		
	}
}
