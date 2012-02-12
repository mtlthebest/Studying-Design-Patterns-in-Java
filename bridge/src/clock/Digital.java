package clock;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


class Digital implements Display {
	
	private JLabel timeLabel;
	
	Digital(){
		JFrame frame = new JFrame("デジタル時計");
		frame.setSize(300, 200);
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Aerial", 0, 50));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.add(timeLabel);
		frame.setVisible(true);
	}

	@Override
	public void setTime(Long time) {
		long hour = time /( 3600 * 1000);
		time -= (3600 * 1000)* hour;
		long minute = time / (60 * 1000);
		time -= (60 * 1000) * minute;
		long second = time / 1000;
		timeLabel.setText(hour+":"+minute+":"+second);
	}

}
