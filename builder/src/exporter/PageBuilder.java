package exporter;

public class PageBuilder {

	protected String pageTitle;
	
	public PageBuilder(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	/**
	 * フィールドのタイトルを追記
	 * @param title　フィールドのタイトル
	 */
	public void addFieldGroupName(String title){}
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void addNameValuePair(String name, String value){}
	
		
}
