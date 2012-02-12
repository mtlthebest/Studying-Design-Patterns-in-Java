package report;
import java.util.ArrayList;
import java.util.List;


public abstract class Report {
	
	String title;
	List<String> paragraphs = new ArrayList<String>();
	
	public void setTitle(String title){
		this.title = title;  
	}
	
	public void addParagraph(String paragraph){
		this.paragraphs.add(paragraph);
	}
	
	public void output(){
		outputStart();
		outputHead();
		outputBodyStart();
		for(String paragraph : paragraphs){
			outputParagraph(paragraph);
		}
		outputBodyEnd();
		outputEnd();
	}
	
	protected abstract void outputStart();
	protected abstract void outputHead();
	protected abstract void outputBodyStart();
	protected abstract void outputParagraph(String paragraph);
	protected abstract void outputBodyEnd();
	protected abstract void outputEnd();

}
