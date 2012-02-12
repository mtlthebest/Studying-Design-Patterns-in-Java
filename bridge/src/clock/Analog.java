package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JComponent;
import javax.swing.JFrame;


class Analog implements Display {
	
	ClockComponent comp;

	Analog(){
		JFrame win = new JFrame("アナログ時計");
		this.comp = new ClockComponent();
		this.comp.setPreferredSize(new Dimension(500, 500));
		win.add(this.comp);
		win.pack();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

	}

	@Override
	public void setTime(Long time) {
		comp.hour = time /( 3600 * 1000);
		time -= (3600 * 1000)* comp.hour;
		comp.minute = time / (60 * 1000);
		time -= (60 * 1000) * comp.minute;
		comp.second = time / 1000;
		comp.repaint();
		
	}
}


class ClockComponent extends JComponent {
	
	
	long hour, minute, second;
	
	@Override
	public void paintComponent(Graphics g){
		int width = getWidth();
		int height = getHeight();
		double hourX ;
		double hourY ;
		double minX ;
		double minY ;
		double secX ;
		double secY ;

		int centerX = width/2 ;
		int centerY = height/2;

		g.setColor(getBackground());

		Calendar cal = Calendar.getInstance();

		secX = (Math.sin(Math.toRadians(second * 6))) * 220;
		secY = -(Math.cos(Math.toRadians(second * 6))) * 220;
		minX = (Math.sin(Math.toRadians(minute * 6 + (second * 6 / 60)))) * 180;
		minY = -(Math.cos(Math.toRadians(minute * 6 + (second * 6 / 60)))) * 180;
		hourX = (Math.sin(Math.toRadians(hour * 30 + (minute * 6 / 60)
				+ (second * 6 / 3600)))) * 110;
		hourY = -(Math.cos(Math.toRadians(hour * 30 + (minute * 6 / 60)
				+ (second * 6 / 3600)))) * 110;

		System.out.print("cenX:" + centerX);
		System.out.print(" cenY=" + centerY);
		System.out.print("hour:" + hour);
		System.out.print(" X=" + (int) hourX);
		System.out.print(" Y=" + (int) hourY);
		System.out.print(" minute:" + minute);
		System.out.print(" X=" + (int) minX);
		System.out.print(" Y=" + (int) minY);
		System.out.print(" second:" + second);
		System.out.print(" X=" + (int) secX);
		System.out.println(" Y=" + (int) secY);
		// g.fillRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.drawLine(centerX, centerY, centerX + (int) hourX, centerY+ (int) hourY);
		g.setColor(Color.BLUE);
		g.drawLine(centerX, centerY, centerX + (int) minX, centerY+ (int) minY);
		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, centerX + (int) secX, centerY+ (int) secY);
		//repaint();
	}
}
