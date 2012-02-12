import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageIconProxy extends ImageIcon implements Runnable {

	static final ImageIcon ABSENT = new ImageIcon(ClassLoader.getSystemResource("images/absent.png"));
	static final ImageIcon LOADING = new ImageIcon(ClassLoader.getSystemResource("images/loading.png"));
	ImageIcon current = ABSENT;
	protected String filename;
	protected JFrame callbackFrame;

	public ImageIconProxy(String filename) {
		super(ABSENT.getImage());
		this.filename = filename;
	}

	public void load(JFrame callbackFrame) {
		this.callbackFrame = callbackFrame;
		current = LOADING;
		callbackFrame.repaint();
		new Thread(this).start();
	}

	public void run() {
		current = new ImageIcon(ClassLoader.getSystemResource(filename));
		callbackFrame.pack();
	}

	public int getIconHeight() { 
		return current.getIconHeight();
	}

	public int getIconWidth() {
		return current.getIconWidth();
	}

	public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
		current.paintIcon(c, g, x, y);
	}
}
