package at.tugraz.ist.agileRecommender.lucene.app;

public class App  {
	
	public String title;
	//public String content;
	public String href;
	
	
	public App(String title){
		this.title = title;
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
