import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;


public class Frame extends JFrame{
	
	MyCheckBox cb1;
	MyCheckBox cb2;
	MyTextField ta;
	MyButton okButton;
	
	public Frame(){
		this.setSize(new Dimension(200, 125));
		cb1 = new MyCheckBox(this);
		cb2 = new MyCheckBox(this);
		ta = new MyTextField(this);
		okButton = new MyButton(this);
		this.add(cb1);
		this.add(cb2);
		this.add(ta);
		this.add(okButton);
		cb1.setText("Ç¢Ç¢ÇÀ");
		cb2.setText("ÉRÉÅÉìÉg");
		okButton.setText("OK");
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		changed();
	}
	
	public void changed(){
		if(!cb1.isSelected() && !cb2.isSelected()){
			okButton.setEnabled(false);
		}else{
			okButton.setEnabled(true);
		}
		if(cb2.isSelected()){
			if(ta.getText().equals("")){
				okButton.setEnabled(false);
			}else{
				okButton.setEnabled(true);
			}
			ta.setEnabled(true);
		}else{
			ta.setEnabled(false);
		}
	}

}
