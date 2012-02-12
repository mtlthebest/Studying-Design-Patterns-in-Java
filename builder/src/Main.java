import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;



import exporter.HTMLDocumentExporter;
import exporter.PageBuilder;
import exporter.PlaneTextExporter;
import exporter.WidgetExporter;

public class Main {
	
	private static final String OPTION_plane = "-plane";
	private static final String OPTION_html = "-html";
	private static final String OPTION_widget = "-widget";
	
	public static void main(String[] args) {
		PageBuilder pageBuilder = null;
		if (args == null || args.length != 1) {
			printUsage();
			System.exit(1);
		}
		String pageTitle = getPageTitle();
		if (OPTION_plane.equals(args[0])) {
			pageBuilder = new PlaneTextExporter(pageTitle);
		} else if(OPTION_html.equals(args[0])) {
			pageBuilder = new HTMLDocumentExporter(pageTitle);
		} else if(OPTION_widget.equals(args[0])){
			pageBuilder = new WidgetExporter(pageTitle);
		} else {
			printUsage();
			System.exit(1);
		}
		InputType type = null;
		do {
			type = selectInputType();
			if (type.equals(InputType.FieldGroupName)) {
				pageBuilder.addFieldGroupName(getFieldGroupName());
			} else if (type.equals(InputType.NameValuePair)) {
				NameValuePair pair = getNameValuePair();
				pageBuilder.addNameValuePair(pair.name, pair.value);
			}
		}while(!type.equals(InputType.Quit));
		
		if (OPTION_plane.equals(args[0])) {
			System.out.println("Input file name.");
			System.out.print(">");
			String filename = getUserInput();
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
				bw.write(((PlaneTextExporter)pageBuilder).getPlaneText());
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OPTION_html.equals(args[0])) {
			System.out.println("Input file name.");
			System.out.print(">");
			String filename = getUserInput();
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
				bw.write(((HTMLDocumentExporter)pageBuilder).getHTMLDocument());
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OPTION_widget.equals(args[0])) {
			JFrame page = ((WidgetExporter)pageBuilder).getWidget();
			page.setVisible(true);
		} else {
			printUsage();
			System.exit(1);
		}
	}

	private enum InputType {
		FieldGroupName, NameValuePair, Quit
	};

	private static void printUsage() {
		String lineSeparator = System.getProperty("line.separator");
		StringBuilder usageBuilder = new StringBuilder();
		usageBuilder.append("Usage:").append(lineSeparator);
		usageBuilder.append("  -plane   : Make plane text.").append(
				lineSeparator);
		usageBuilder.append("  -html    : Make html document.").append(
				lineSeparator);
		usageBuilder.append("  -widget  : View widget.").append(lineSeparator);
		System.out.println(usageBuilder.toString());
	}

	private static String getPageTitle() {
		System.out.println("Input page title.");
		System.out.print(">");
		return getUserInput();
	}

	private static String getFieldGroupName() {
		System.out.println("Input field group name.");
		System.out.print(">");
		return getUserInput();
	}

	private static NameValuePair getNameValuePair() {
		NameValuePair pair = new NameValuePair();
		System.out.println("Input field name");
		System.out.print(">");
		pair.name = getUserInput();
		System.out.println("Input field value");
		System.out.print(">");
		pair.value = getUserInput();
		return pair;
	}

	private static InputType selectInputType() {
		InputType type = null;
		while (type == null) {
			try {
				System.out
						.println("Select type.(f:Field Group Name / n:Name Value Pair / q: Quit)");
				System.out.print(">");
				String userInput = getUserInput();
				if(userInput.equals("f")){
					type = InputType.FieldGroupName;
				}else if(userInput.equals("n")){
					type = InputType.NameValuePair;
				}else if(userInput.equals("q")){
					type = InputType.Quit;
				}else{
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Invalid value was inputted.");
			}
		}
		return type;
	}

	private static String getUserInput() {
		BufferedReader stdinReader = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput = null;
		try {
			userInput = stdinReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInput;
	}

}

class NameValuePair {
	public String name;
	public String value;
}
