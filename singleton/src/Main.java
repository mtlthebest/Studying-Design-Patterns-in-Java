
public class Main {
	
	public static void main(String[] args){
		ConfigurationVariable cv = ConfigurationVariable.getInstance();
		System.out.println("Configuration valiables:");
		System.out.println("    hostname: "+ cv.hostname);
		System.out.println("    port:     "+ cv.port);
		System.out.println("    interval: "+ cv.interval);
	}

}
