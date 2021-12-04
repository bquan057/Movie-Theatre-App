
/**
 * An entity class representing a news item from the database.
 * @author Brandon Quan
 *
 */
public class MovieNews {

	private String newMovieName;
	private String news;
	
	public MovieNews() {
		
	}

	public String getNewMovieName() {
		return newMovieName;
	}

	public void setNewMovieName(String newMovieName) {
		this.newMovieName = newMovieName;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
	
}
