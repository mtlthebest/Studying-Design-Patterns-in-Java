import java.util.Scanner;
import report.HTMLReport;
import report.PlainTextReport;
import report.Report;


public class Main {
	
	public static void main(String[] args){
		System.out.print("形式を選択したください。（1:text, 2:html）>");
		Scanner scan = new Scanner(System.in);
	    String str = scan.next();
	    Report report = null;
	    if(str.equals("1")){
	    	report = new PlainTextReport();
	    }else if(str.equals("2")){
	    	report = new HTMLReport();
	    }else{
	    	System.exit(0);
	    }
	    report.setTitle("月次報告");
	    report.addParagraph("順調です。");
	    report.addParagraph("最高の調子です。");
	    report.output();
	}

}
