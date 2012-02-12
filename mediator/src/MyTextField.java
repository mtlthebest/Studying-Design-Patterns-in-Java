import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


@SuppressWarnings("serial")
public class MyTextField extends JTextField{

	Frame parent;
	
	public MyTextField(Frame parent){
		this.parent = parent;
		this.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				MyTextField.this.parent.changed();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				MyTextField.this.parent.changed();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				MyTextField.this.parent.changed();
			}
		});
	}

}
