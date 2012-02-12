package exporter.text;

import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.Grid;

public class TextGrid implements Grid {


	protected StringWriter stringWriter = new StringWriter();
	
	public TextGrid(String title, String... headers) {
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println();
		printWriter.println("++"+title+"++");
		printWriter.println("< not supported>");
	}

	@Override
	public void addRow(String... data) {
		
	}

	public String getText() {
		return stringWriter.getBuffer().toString();
	}

}
