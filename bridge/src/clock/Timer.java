package clock;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Timer extends Clock {

	java.util.Timer timer;
	enum Status{Stop, Run};
	long time;
	long startTime;
	long initialTime;
	Status status = Status.Stop;
	
	public Timer(DisplayMode dieplayMode) {
		super(dieplayMode);
		
		JFrame frame = new JFrame("コントローラ");
		frame.setLayout(new FlowLayout());
		JButton startAndStopButton = new JButton("スタート／ストップ");
		JButton resetButton = new JButton("リセット");
		JButton hourButton = new JButton("時");
		JButton minuteButton = new JButton("分");
		JButton secondButton = new JButton("秒");
		frame.add(startAndStopButton);
		frame.add(resetButton);
		frame.add(hourButton);
		frame.add(minuteButton);
		frame.add(secondButton);
		startAndStopButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(status.equals(Status.Stop)){
					startTime = Calendar.getInstance().getTimeInMillis();
					Timer.this.status = Status.Run;
				}else{
					Timer.this.status = Status.Stop;
				}
				
			}
		});
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Timer.this.initialTime = 0L;
			}
		});
		hourButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer.this.initialTime += 3600*1000;
				Timer.this.time += 3600*1000;
				display.setTime(time);
			}
		});
		minuteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer.this.initialTime += 60*1000;
				Timer.this.time += 60*1000;
				display.setTime(time);				
			}
		});
		secondButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Timer.this.initialTime += 1000;
				Timer.this.time += 1000;
				display.setTime(time);				
			}
		});
		frame.setSize(100,100);
		frame.setVisible(true);
		
		
		timer = new java.util.Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				long passedTime = Calendar.getInstance().getTimeInMillis() - startTime;
				long viewTime = initialTime - passedTime;
				if(viewTime <= 0){
					time = 0;
				}else
					time = viewTime;
				Timer.this.display.setTime(time);
			}
			
		};
		timer.schedule(task, 0,1000 );
	}

}
