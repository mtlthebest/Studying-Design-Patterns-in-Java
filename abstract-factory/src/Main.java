import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;
import exporter.PageFactory;


public class Main {
	
	public static void main(String[] args) {
		
		PageFactory pageFactory = new PageFactory(args);
		Page testPage = pageFactory.createPage("Test Page");
		
		FieldGroup fullNameFieldGroup = pageFactory.createFieldGroup("Full Name");
		fullNameFieldGroup.addField("First Name", "Shintaro");
		fullNameFieldGroup.addField("Last Name", "Kimura");
		testPage.addFieldGroup(fullNameFieldGroup);
		
		Grid grid = pageFactory.createGrid("Storage Usage", "Capacity", "Used", "Rate");
		grid.addRow("2048", "1024", "50");
		testPage.addGrid(grid);
		
		testPage.outPut();
		
	}
}