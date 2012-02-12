import chemical.Element;
import chemical.ElementFactory;


public class Main {
	
	public static void main(String[] args){
		Element hydrogen = ElementFactory.getElement("Hydrogen", "H", 1);
		Element lithium = ElementFactory.getElement("lithium", "Li", 3);
		
		System.out.println(hydrogen);
		System.out.println(lithium);
		
	}

}
