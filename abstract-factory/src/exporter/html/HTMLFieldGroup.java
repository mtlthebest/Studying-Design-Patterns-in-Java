package exporter.html;

import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.FieldGroup;

public class HTMLFieldGroup implements FieldGroup {

	protected StringWriter stringWriter = new StringWriter();
	
	public HTMLFieldGroup(String name) {
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println("<table border=\"3\">");
		printWriter.print("\t<tr><td colspan=2>" + name +"</td></tr>");
	}

	@Override
	public void addField(String name, String value) {
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println("\t<tr>");
		printWriter.println("\t\t<td>" + name + "</td>");
		printWriter.println("\t\t<td>" + value + "</td>");
		printWriter.println("\t</tr>");
	}

	public String getHTML(){
		stringWriter.append("</table>");
		return stringWriter.getBuffer().toString();
	}
	

}
