package clock;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class H24Clock extends Clock {
	
	java.util.Timer timer;

	public H24Clock(DisplayMode dieplayMode) {
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
				H24Clock.this.display.setTime(time);
			}
			
		};
		timer.schedule(task, 0,1000 );
	}
	
}