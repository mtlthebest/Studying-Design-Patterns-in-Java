package xmlparser;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import beans.VMGuest;
import beans.VMHost;

public class VMHostHandler implements DocumentHandler{

	private VMHost vmHost;
	public VMHostHandler(){
		vmHost = new VMHost();
	}
	
	@Override
	public VMHost parse(Element element) {
		if ("VMHost".equals(element.getName())) {
			vmHost.setIpaddress(element.attributeValue("ipaddress"));
			vmHost.setHbaWwpn(element.attributeValue("hbawwpn"));
			vmHost.setVmGuests(new ArrayList<VMGuest>());
			@SuppressWarnings("unchecked")
			List<Element> elements = element.elements();
			for(Element childElement : elements){
				VMGuestHandler handler = new VMGuestHandler();
				VMGuest vmGuest = handler.parse(childElement);
				vmHost.getVmGuests().add(vmGuest);
			}
		}
		return vmHost;
	}

}
