import clock.*;



public class Main {
	
	public static void main(String[] args){
		//Clock clock = new H12Clock(Clock.DisplayMode.DIGITAL);
		//Clock clock = new H24Clock(Clock.DisplayMode.DIGITAL);
		//Clock clock = new H12Clock(Clock.DisplayMode.ANALOG);
		//Clock clock = new Timer(Clock.DisplayMode.DIGITAL);
		Clock clock = new StopWatch(Clock.DisplayMode.DIGITAL);
	}

}
