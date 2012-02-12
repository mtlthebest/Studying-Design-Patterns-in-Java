import javax.swing.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		ImageIconProxy imageIcon = new ImageIconProxy("images/img.JPG");
		JLabel label = new JLabel(imageIcon);
		JFrame frame = new JFrame();
		frame.add(label);
		frame.setVisible(true);
		Thread.sleep(4000L);
		imageIcon.load(frame);
	}
}
