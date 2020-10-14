public class Device {

	String deviceSku;
	String deviceName;
	boolean deviceAvailability;

	// constructors for device. defaults to deviceAvailability being true
	// (available)
	public Device() {

		this.deviceAvailability = true;
	}

	public Device(String deviceSku, String deviceName) {

		this.deviceSku = deviceSku;
		this.deviceName = deviceName;
		this.deviceAvailability = true;
	}

	public Device(String deviceSku, String deviceName, boolean deviceAvailability) {

		this.deviceSku = deviceSku;
		this.deviceName = deviceName;
		this.deviceAvailability = deviceAvailability;
	}

	// getters and setters
	public String getDeviceSku() {

		return deviceSku;
	}

	public void setDeviceSku(String deviceSku) {

		this.deviceSku = deviceSku;
	}

	public String getDeviceName() {

		return deviceName;
	}

	public void setDeviceName(String deviceName) {

		this.deviceName = deviceName;
	}

	// if boolean value for deviceAvailability is true, returns String "Available",
	// else returns String "Checked out"
	public String getDeviceAvailability() {

		String dA;

		if (deviceAvailability == true) {
			dA = "Available";
		} else {
			dA = "Checked out";
		}

		return dA;
	}

	public void setDeviceAvailability(boolean deviceAvailability) {

		this.deviceAvailability = deviceAvailability;
	}

}
