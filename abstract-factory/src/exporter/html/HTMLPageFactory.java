package exporter.html;


import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;
import exporter.PageFactory;

public class HTMLPageFactory extends PageFactory {

	
	@Override
	public FieldGroup createFieldGroup(String name) {
		return new HTMLFieldGroup(name);
	}

	@Override
	public Page createPage(String title) {
		return new HTMLPage(title);
	}

	@Override
	public Grid createGrid(String title, String... header) {
		return new HTMLGrid(title, header);
	}
}
