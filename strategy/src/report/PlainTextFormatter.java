package report;

import java.io.PrintStream;
import java.util.List;

public class PlainTextFormatter implements Formatter {

	@Override
	public void outPut(String title, List<String> paragraphs) {
		PrintStream stdout = System.out;
		stdout.println("*****"+title+"*****");
		for(String paragraph : paragraphs){
			stdout.println(" "+ paragraph);
		}
	}

}
