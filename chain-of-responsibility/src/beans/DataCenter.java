package beans;

import java.util.List;

public class DataCenter {
	
	private String name;
	private List<VMHost> vmHosts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VMHost> getVmHosts() {
		return vmHosts;
	}
	public void setVmHosts(List<VMHost> vmHosts) {
		this.vmHosts = vmHosts;
	}
	@Override
	public String toString() {
		return "DataCenter [name=" + name + ", vmHosts=" + vmHosts + "]";
	}

}
