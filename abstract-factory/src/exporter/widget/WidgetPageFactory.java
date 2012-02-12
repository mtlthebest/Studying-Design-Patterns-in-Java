package exporter.widget;

import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;
import exporter.PageFactory;

public class WidgetPageFactory extends PageFactory {
	@Override
	public FieldGroup createFieldGroup(String name) {
		return new WidgetFieldGroup(name);
	}

	@Override
	public Page createPage(String title) {
		return new WidgetPage(title);
	}

	@Override
	public Grid createGrid(String title, String... header) {
		return new WidgetGrid(title, header);
	}
}
