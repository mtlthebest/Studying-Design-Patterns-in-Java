import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;


@SuppressWarnings("serial")
public class MyCheckBox extends JCheckBox{

	Frame parent;
	public MyCheckBox(Frame parent){
		this.parent = parent;
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyCheckBox.this.parent.changed();
			}
			
		});
	}
}
	