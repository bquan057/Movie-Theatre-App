package DataSource;
/**
 * Class representing a movie object
 * @author Aron Saengchan
 *
 */
public class Movie {
	
	private int theatreId;
	
	private int movieId;
	
	private String name;
	
	private int auditorium;
	
	public Movie(int theatreId, int movieId, String name, int auditorium) {
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.name = name;
		this.auditorium = auditorium;
	}

	// Getter methods
	public int getTheatreId() {
		return theatreId;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getName() {
		return name;
	}

	public int getAuditorium() {
		return auditorium;
	}
	
	
	

}
