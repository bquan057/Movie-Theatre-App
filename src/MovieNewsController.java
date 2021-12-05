import java.util.ArrayList;

/**
 * A control class used to call the TheatreService's getMovieNews() function.
 * @author Brandon Quan
 *
 */
public class MovieNewsController{

	private TheatreService theatreService;
	
	public MovieNewsController(TheatreService theatreService) {
		this.theatreService = theatreService;
	}
	
	public ArrayList<MovieNews> getMovieNews() {
		theatreService.initializeConnection();
		ArrayList<MovieNews> recentNews = theatreService.getMovieNews();
		theatreService.close();
		return recentNews;
	}
	

}
