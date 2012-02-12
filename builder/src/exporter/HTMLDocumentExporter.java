package exporter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class HTMLDocumentExporter extends PageBuilder {

	private StringWriter stringWriter = new StringWriter(); 
	
	public HTMLDocumentExporter(String pageTitle) {
		super(pageTitle);
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println("<h1>" + pageTitle + "</h1>");
		printWriter.println("<table border=\"3\">");
	}
	
	@Override
	public void addFieldGroupName(String title){
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.print("\t<tr><td colspan=2>");
		printWriter.print(title);
		printWriter.println("</td></tr>");
		
	}
	
	@Override
	public void addNameValuePair(String name, String value){
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.print("\t<tr><td>");
		printWriter.print(name);
		printWriter.print("</td><td>");
		printWriter.print(value);
		printWriter.println("</td></tr>");
	}
	
	public String getHTMLDocument(){
		stringWriter.append("</table>");
		return stringWriter.getBuffer().toString();
	}
	
	
	
	
}
