package beans;

import java.util.List;

public class VMGuest {
	
	String ipaddress;
	String OS;
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	@Override
	public String toString() {
		return "VMGuest [ipaddress=" + ipaddress + ", OS=" + OS + "]";
	}
	
}
