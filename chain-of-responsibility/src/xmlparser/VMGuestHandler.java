package xmlparser;


import org.dom4j.Element;

import beans.VMGuest;

public class VMGuestHandler implements DocumentHandler{
	private VMGuest vmGuest;
	public VMGuestHandler(){
		vmGuest = new VMGuest();
	}
	
	@Override
	public VMGuest parse(Element element) {
		if ("VMGuest".equals(element.getName())) {
			vmGuest.setIpaddress(element.attributeValue("ipaddress"));
			vmGuest.setOS(element.attributeValue("os"));
		}
		return vmGuest;
	}
}
