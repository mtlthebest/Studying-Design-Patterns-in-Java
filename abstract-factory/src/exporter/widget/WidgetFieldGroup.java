package exporter.widget;


import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import exporter.FieldGroup;

public class WidgetFieldGroup implements FieldGroup {

	
	private JPanel panel;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	private int nextGridY = 0;
	
	public WidgetFieldGroup(String name) {
		panel = new JPanel();
		layout = new GridBagLayout();
		constraints = new GridBagConstraints();
		panel.setLayout(layout);
		constraints.gridx = 0;
		constraints.gridy = nextGridY++;
		constraints.gridwidth = 2;
		JLabel label = new JLabel(name, SwingConstants.LEFT);
		panel.add(label, constraints);
		
	}

	@Override
	public void addField(String name, String value) {
		JLabel nameLabel = new JLabel(name+":  ", SwingConstants.LEFT);
		JLabel valueLabel = new JLabel(value, SwingConstants.LEFT);
		constraints.gridx = 0;
		constraints.gridy = nextGridY++;
		constraints.gridwidth = 1;
		panel.add(nameLabel, constraints);
		constraints.gridx = 1;
		panel.add(valueLabel, constraints);
	}
	
	public Component getWidget(){
		return panel;
	}

}
