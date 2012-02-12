import java.awt.FlowLayout;

import javax.swing.JFrame;


public class Main {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		ClonableJLabel clonableJLabel  = new ClonableJLabel("hoge");
		frame.setLayout(new FlowLayout());
		frame.add(clonableJLabel);
		clonableJLabel = clonableJLabel.clone();
		clonableJLabel.setText("fuga");
		frame.add(clonableJLabel);
		frame.setVisible(true);
	}
	
}
