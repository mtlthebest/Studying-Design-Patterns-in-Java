package exporter;

public class PlaneTextExporter extends PageBuilder{

	public PlaneTextExporter(String pageTitle) {
		super(pageTitle);
		stringBuilder = new StringBuilder(this.pageTitle);
		stringBuilder.append(System.getProperty("line.separator"));
		
	}

	private StringBuilder stringBuilder;
	
	@Override
	public void addFieldGroupName(String title){
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(title+ System.getProperty("line.separator"));
	}
	
	@Override
	public void addNameValuePair(String name, String value){
		stringBuilder.append("   " + name + ":");
		int sizeOfName = name.length();
		for(int i=0; i<15-sizeOfName; i++){
			stringBuilder.append(" ");
		}
		stringBuilder.append(value);
		stringBuilder.append(System.getProperty("line.separator"));
	}
	
	public String getPlaneText(){
		return stringBuilder.toString();
	}
	
}
