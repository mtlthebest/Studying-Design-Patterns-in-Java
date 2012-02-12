package xmlparser;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import beans.DataCenter;
import beans.VMHost;

public class DataCenterHandler implements DocumentHandler {

	private DataCenter dataCenter;

	public DataCenterHandler() {
		dataCenter = new DataCenter();
	}

	@Override
	public DataCenter parse(Element element) {
		if ("DataCenter".equals(element.getName())) {
			dataCenter.setName(element.attributeValue("name"));
			dataCenter.setVmHosts(new ArrayList<VMHost>());
			@SuppressWarnings("unchecked")
			List<Element> elements = element.elements();
			for(Element childElement : elements){
				VMHostHandler handler = new VMHostHandler();
				VMHost vmHost = handler.parse(childElement);
				dataCenter.getVmHosts().add(vmHost);
			}
		}
		return dataCenter;
	}

}
