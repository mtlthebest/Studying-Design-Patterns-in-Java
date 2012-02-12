package chemical;

import java.util.HashMap;
import java.util.Map;

public class ElementFactory {
	
	private ElementFactory(){};
	
	private static Map<String, Element> elements = new HashMap<String, Element>();
	
	static {
		elements.put("hydrogen", new Element("Hydrogen", "H", 1));
		elements.put("helium", new Element("Helium", "H", 2));
		elements.put("lithium", new Element("lithium", "H", 2));
		/* ‘±‚­ */
	}
	
	public static Element getElement(String name, String symbol, double atomicWeight){
		Element element = elements.get(name);
		if(element == null){
			Element newElement =  new Element(name, symbol, atomicWeight);
			elements.put(name, newElement);
			return newElement;
		}else{
			return element;
		}
	}
	
	public static Element getElement(String name){
		return elements.get("hydrogen");
	}
	
}
