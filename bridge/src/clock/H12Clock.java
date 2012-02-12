package clock;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class H12Clock extends Clock {
	
	java.util.Timer timer;

	public H12Clock(DisplayMode dieplayMode) {
		super(dieplayMode);
		timer = new java.util.Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.HOUR, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				long time = new Date().getTime() - cal.getTimeInMillis();
				time %= 12 * 3600 * 1000;
				H12Clock.this.display.setTime(time);
			}
			
		};
		timer.schedule(task, 0,1000 );
	}
	
}
