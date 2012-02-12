package exporter.html;

import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.Grid;

public class HTMLGrid implements Grid {

	private StringWriter stringWriter = new StringWriter(); 
	private int colmnNum;
	
	public HTMLGrid(String title, String... headers) {
		this.colmnNum = headers.length;
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println("<h2>" + title + "<h2>");
		printWriter.println("<table border=\"3\">");
		printWriter.println("\t<tr>");
		for(String header : headers){
			printWriter.println("\t\t<th>" + header +"</th>");
		}
		printWriter.println("\t</tr>");
	}

	@Override
	public void addRow(String... datas) {
		if(datas.length != colmnNum) throw new IllegalAccessError();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		for(String data : datas){
			printWriter.println("\t\t<th>" + data +"</th>");
		}
	}
	
	public String getHTML(){
		stringWriter.append("</table>");
		return stringWriter.getBuffer().toString();
	}

}
