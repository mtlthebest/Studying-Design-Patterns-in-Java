package exporter.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;

public class TextPage implements Page {

	private StringWriter stringWriter = new StringWriter();

	public TextPage(String pageTitle) {
		PrintWriter printWriter = new PrintWriter(stringWriter);
		printWriter.println(pageTitle);
	}

	@Override
	public void addFieldGroup(FieldGroup fieldGroup) {
		if (!(fieldGroup instanceof TextFieldGroup))
			throw new IllegalArgumentException();
		stringWriter.append(((TextFieldGroup) fieldGroup).getText());

	}

	@Override
	public void addGrid(Grid grid) {
		if (!(grid instanceof TextGrid))
			throw new IllegalArgumentException();
		stringWriter.append(((TextGrid) grid).getText());

	}

	@Override
	public void outPut() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"html_page.html"));
			bw.write(stringWriter.getBuffer().toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
