package report;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Report {
	
	private Formatter formatter;
	private String title;
	private List<String> paragraphs = new ArrayList<String>();
	
	public Report(Formatter formatter){
		this.formatter = formatter;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void addParagraph(String paragraph){
		this.paragraphs.add(paragraph);
	}
	
	public void setFormatter(Formatter formatter){
		this.formatter = formatter;
	}
	
	public void output(){
		formatter.outPut(title, paragraphs);
	}
	
	public static void main(String[] args){
		System.out.print("�`����I���������������B�i1:text, 2:html�j>");
		Scanner scan = new Scanner(System.in);
	    String str = scan.next();
	    Report report = null;
	    if(str.equals("1")){
	    	report = new Report(new PlainTextFormatter());
	    }else if(str.equals("2")){
	    	report = new Report(new HTMLFormatter());
	    }else{
	    	System.exit(0);
	    }
	    report.setTitle("������");
	    report.addParagraph("�����ł��B");
	    report.addParagraph("�ō��̒��q�ł��B");
	    report.output();
	    
	}
	
	
	
}
