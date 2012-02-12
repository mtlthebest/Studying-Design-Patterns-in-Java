package exporter.text;

import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;
import exporter.PageFactory;

public class TextPageFactory extends PageFactory {
	
	@Override
	public FieldGroup createFieldGroup(String name) {
		return new TextFieldGroup(name);
	}

	@Override
	public Page createPage(String title) {
		return new TextPage(title);
	}

	@Override
	public Grid createGrid(String title, String... header) {
		return new TextGrid(title, header);
	}

}
