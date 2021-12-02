
public class MovieNews {

	private String newsHeading;
	private String newsContent;
	
	public MovieNews(String newsHeading, String newsContent) {
		this.newsHeading = newsHeading;
		this.newsContent = newsContent;
	}

	public String getNewsHeading() {
		return newsHeading;
	}

	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
}
