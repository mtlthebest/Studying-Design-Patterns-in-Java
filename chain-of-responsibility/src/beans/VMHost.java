package beans;

import java.util.List;

public class VMHost {
	
	String ipaddress;
	String hbaWwpn;
	List<VMGuest> vmGuests;
	
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getHbaWwpn() {
		return hbaWwpn;
	}
	public void setHbaWwpn(String hbaWwpn) {
		this.hbaWwpn = hbaWwpn;
	}
	public List<VMGuest> getVmGuests() {
		return vmGuests;
	}
	public void setVmGuests(List<VMGuest> vmGuests) {
		this.vmGuests = vmGuests;
	}
	@Override
	public String toString() {
		return "VMHost [ipaddress=" + ipaddress + ", hbaWwpn=" + hbaWwpn
				+ ", vmGuests=" + vmGuests + "]";
	}
	

}
