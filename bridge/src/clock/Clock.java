package clock;

public abstract class Clock {
	
	public enum DisplayMode{ ANALOG, DIGITAL };
	
	Display display;
	
	public Clock(DisplayMode dieplayMode){
		if(dieplayMode.equals(DisplayMode.ANALOG)){
			this.display = new Analog();
		}else{
			this.display = new Digital();
		}
	}

}
