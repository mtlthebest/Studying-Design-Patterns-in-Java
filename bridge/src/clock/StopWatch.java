package clock;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StopWatch extends Clock {
	
	enum State{Stop, Run};

	java.util.Timer timer = new Timer();
	long statTime;
	State status = State.Stop;


	public StopWatch(DisplayMode dieplayMode) {
		super(dieplayMode);
		JButton startButton = new JButton("Start/Stop");
		JButton resetButton = new JButton("Reset");
		JFrame frame = new JFrame("ÉRÉìÉgÉçÅ[Éâ");
		frame.setLayout(new FlowLayout());
		frame.setSize(new Dimension(100,100));
		frame.add(startButton);
		frame.add(resetButton);
		frame.setVisible(true);
		this.display.setTime(0L);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(status.equals(State.Stop)){
					TimerTask task = new TimerTask(){

						@Override
						public void run() {
							long time = new Date().getTime() - statTime;
							time %= 12 * 3600 * 1000;
							StopWatch.this.display.setTime(time);
						}
						
					};
					
					System.out.println("Start");
					StopWatch.this.statTime = new Date().getTime();
					StopWatch.this.timer = new Timer();
					StopWatch.this.timer.schedule(task, 0,1000 );
					StopWatch.this.status = State.Run;
				}else{
					System.out.println("Stop");
					StopWatch.this.timer.cancel();
					StopWatch.this.timer.purge();
					StopWatch.this.status = State.Stop;
				}
			}
			
		});
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				StopWatch.this.display.setTime(0L);
			}
		});
	
	}

}
