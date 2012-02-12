package exporter.html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;

public class HTMLPage implements Page {

	private StringWriter stringWriter = new StringWriter();
	
	public HTMLPage(String pageTitle) {
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println("<h1>" + pageTitle + "</h1>");
	}

	@Override
	public void addFieldGroup(FieldGroup fieldGroup) {
		if(!(fieldGroup instanceof HTMLFieldGroup)) throw new IllegalArgumentException();
		stringWriter.append(((HTMLFieldGroup)fieldGroup).getHTML());
	}

	@Override
	public void addGrid(Grid grid) {
		if(!(grid instanceof HTMLGrid)) throw new IllegalArgumentException();
		stringWriter.append(((HTMLGrid)grid).getHTML());
	}

	@Override
	public void outPut() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("html_page.html"));
			bw.write(stringWriter.getBuffer().toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
