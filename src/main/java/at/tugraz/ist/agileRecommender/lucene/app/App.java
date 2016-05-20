package at.tugraz.ist.agileRecommender.lucene.app;


public class App  {
	
	
	private String title;
	//public String content;
	private String href;
	
	
	public App(){
		
	}
	
	public App(String title, String href){
		this.title = title;
		this.href = href;
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
