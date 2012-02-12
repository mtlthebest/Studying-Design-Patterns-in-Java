import java.util.Scanner;
import report.HTMLReport;
import report.PlainTextReport;
import report.Report;


public class Main {
	
	public static void main(String[] args){
		System.out.print("�`����I���������������B�i1:text, 2:html�j>");
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
	    report.setTitle("������");
	    report.addParagraph("�����ł��B");
	    report.addParagraph("�ō��̒��q�ł��B");
	    report.output();
	}

}
