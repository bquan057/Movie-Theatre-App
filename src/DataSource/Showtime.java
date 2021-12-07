package DataSource;
import java.time.LocalDateTime;

/**
 * Class that represents a showtime object
 * @author Aron Saengchan
 */
public class Showtime {
	
	private int movieId;
	
	private int theatreId;
	
	private int auditorium;
	
	private LocalDateTime showtime;

	public Showtime(int movieId, int theatreId, int auditorium, LocalDateTime showtime) {
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.auditorium = auditorium;
		this.showtime = showtime;
	}

	public int getMovieId() {
		return movieId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public int getAuditorium() {
		return auditorium;
	}

	public LocalDateTime getShowtime() {
		return showtime;
	}
	
	
	
	
	
	

}
