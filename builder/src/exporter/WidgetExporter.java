package exporter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class WidgetExporter extends PageBuilder {

	private JFrame page;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	private int nextGridY = 0;
	
	public WidgetExporter(String pageTitle) {
		super(pageTitle);
		page = new JFrame(this.pageTitle);
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		page.setLayout(layout);
	}
	
	@Override
	public void addFieldGroupName(String title){
		constraints.gridx = 0;
		constraints.gridy = nextGridY++;
		constraints.gridwidth = 2;
		JLabel label = new JLabel(title, SwingConstants.LEFT);
		page.add(label, constraints);
	}
	
	@Override
	public void addNameValuePair(String name, String value){
		JLabel nameLabel = new JLabel(name+":  ", SwingConstants.LEFT);
		JLabel valueLabel = new JLabel(value, SwingConstants.LEFT);
		constraints.gridx = 0;
		constraints.gridy = nextGridY++;
		constraints.gridwidth = 1;
		page.add(nameLabel, constraints);
		constraints.gridx = 1;
		page.add(valueLabel, constraints);
	}

	
	
	public JFrame getWidget(){
		page.setSize(300, 200);
		return page;
	}

}
