import java.util.ArrayList;

public class TheatreService implements NewsSubject{

	private ArrayList <NewsObserver> observers;
	private MovieNews recentNews;
	
	public TheatreService(MovieNews recentNews) {
		observers = new ArrayList<NewsObserver>();
		this.recentNews = getMovieNews();
		notifyObserver();
	}
	
	@Override
	public void register(NewsObserver o) {
		observers.add(o);
		o.update(recentNews);
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < observers.size(); i++) {
		NewsObserver o = observers.get(i);
		o.update(recentNews);
		}
	}
	
	public MovieNews getMovieNews() {
		// TO-DO: implement JDBC and return last element of movie news table.
		MovieNews recentNews = new MovieNews("Temporary Heading", "Temporary Content");
		return recentNews;
	}

}
