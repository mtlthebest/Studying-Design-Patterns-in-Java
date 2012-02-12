package report;

import java.io.PrintStream;
import java.util.List;

public class HTMLFormatter implements Formatter {

	@Override
	public void outPut(String title, List<String> paragraphs) {
		PrintStream stdout = System.out;
		stdout.println("<html>");
		stdout.println("	<head>");
		stdout.println("		<title>"+title+"</title>");
		stdout.println("	</head>");
		stdout.println("	<body>");
		for(String paragraph : paragraphs){
			stdout.println("		<p>"+paragraph+"</p>");
		}
		stdout.println("	</body>");
		stdout.println("</html>");
	}

}
