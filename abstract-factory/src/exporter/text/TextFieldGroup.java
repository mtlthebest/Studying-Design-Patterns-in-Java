package exporter.text;

import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.FieldGroup;

public class TextFieldGroup implements FieldGroup{

	protected StringWriter stringWriter = new StringWriter();
	
	public TextFieldGroup(String name){
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println();
		printWriter.println("++"+name+"++");
	}
	
	@Override
	public void addField(String name, String value) {
		stringWriter.append("   " + name + ":");
		int sizeOfName = name.length();
		for(int i=0; i<15-sizeOfName; i++){
			stringWriter.append(" ");
		}
		stringWriter.append(value);
		stringWriter.append(System.getProperty("line.separator"));
	}

	public String getText() {
		return stringWriter.getBuffer().toString();
	}


}
