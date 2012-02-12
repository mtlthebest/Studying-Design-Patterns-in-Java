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
		System.out.print("形式を選択したください。（1:text, 2:html）>");
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
	    report.setTitle("月次報告");
	    report.addParagraph("順調です。");
	    report.addParagraph("最高の調子です。");
	    report.output();
	    
	}
	
	
	
}
