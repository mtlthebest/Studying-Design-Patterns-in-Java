package exporter;

import java.util.List;

import exporter.html.HTMLPageFactory;
import exporter.text.TextPageFactory;
import exporter.widget.WidgetPageFactory;

public class PageFactory {
	
	private static final String OPTION_plane = "-plane";
	private static final String OPTION_html = "-html";
	private static final String OPTION_widget = "-widget";
	
	private PageFactory concreteFactory;
	
	protected PageFactory(){}
	
	public PageFactory(String[] args){
		if(args == null) throw new IllegalArgumentException();
		if(args.length != 1) throw new IllegalArgumentException();
		if(OPTION_plane.equals(args[0])){
			concreteFactory = new TextPageFactory();
		}else if(OPTION_html.equals(args[0])){
			concreteFactory = new HTMLPageFactory();
		}else if(OPTION_widget.equals(args[0])){
			concreteFactory = new WidgetPageFactory();
		}
	}
	
	public FieldGroup createFieldGroup(String name){
		return this.concreteFactory.createFieldGroup(name);
	}
	
	public Page createPage(String title){
		return this.concreteFactory.createPage(title);
	}
	
	public Grid createGrid(String title, String... header){
		return this.concreteFactory.createGrid(title, header); 
	}

}
