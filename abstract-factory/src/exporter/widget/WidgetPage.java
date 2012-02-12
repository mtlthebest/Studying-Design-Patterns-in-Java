package exporter.widget;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import exporter.FieldGroup;
import exporter.Grid;
import exporter.Page;

public class WidgetPage implements Page {
	
	private JFrame frame;
	
	public WidgetPage(String name){
		frame = new JFrame(name);
		frame.setLayout(new FlowLayout());
	}
	
	@Override
	public void addFieldGroup(FieldGroup fieldGroup) {
		frame.add(((WidgetFieldGroup)fieldGroup).getWidget());
	}

	@Override
	public void addGrid(Grid grid) {
		frame.add(((WidgetGrid)grid).getWidget());
	}

	@Override
	public void outPut() {
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}
