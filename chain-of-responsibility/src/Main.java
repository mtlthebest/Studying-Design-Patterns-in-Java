import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import beans.DataCenter;

import xmlparser.DataCenterHandler;



public class Main {

	public static void main(String[] args) throws Exception{
		SAXReader reader = new SAXReader(); 
		Document doc = reader.read(new File("sample.xml"));
		DataCenterHandler handler = new DataCenterHandler();
		DataCenter dataCenter = handler.parse(doc.getRootElement());
		
		System.out.println(dataCenter);

	}

}