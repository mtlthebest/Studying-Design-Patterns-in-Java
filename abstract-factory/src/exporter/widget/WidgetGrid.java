package exporter.widget;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exporter.Grid;

public class WidgetGrid implements Grid {

	private JPanel panel;
	private JTable table;
	private DefaultTableModel defaultTableModel;

	public WidgetGrid(String title, String... header) {
		panel = new JPanel();
		JLabel label = new JLabel(title);
		panel.add(label);
		defaultTableModel = new DefaultTableModel(header, header.length);
		table = new JTable(defaultTableModel);
		panel.add(table);
	}

	@Override
	public void addRow(String... data) {
		defaultTableModel.addRow(data);
	}
	
	public Component getWidget(){
		return panel;
	}

}
