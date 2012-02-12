package xmlparser;

import org.dom4j.Element;

public interface DocumentHandler {
	
	public Object parse(Element element);

}
