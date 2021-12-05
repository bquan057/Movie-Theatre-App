import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A class used as the interface to the theatre database using JDBC.
 * @author Brandon Quan, Aron Saengchan
 *
 */
public class TheatreService{
	
	private final String DBURL;
	private final String USERNAME;
	private final String PASSWORD;
	
	private Connection dbConnect;
	private ResultSet results;
	
	public TheatreService(String url, String username, String password) {
		this.DBURL = url;
		this.USERNAME = username;
		this.PASSWORD = password;	
	}
	
	/**
	 * Used to initialize the connection to the database.
	 */
	public void initializeConnection() {
		try {
			dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * A prepared query used to return the two most recent news items from the database.
	 * @return recentNews, an ArrayList of two movie news items.
	 */
	public ArrayList<MovieNews> getMovieNews() {
		
		// Creates an array list.
		ArrayList<MovieNews> recentNews = new ArrayList<MovieNews>();
		
		try {
			// Selects two most recent news items.
			String query = "SELECT * FROM NEW_MOVIE ORDER BY DatePosted DESC LIMIT 2";
			
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			results = myStmt.executeQuery();
			
			// Populates the array list with the news items.
			while(results.next()) {
				MovieNews newMovie = new MovieNews();
				newMovie.setNewMovieName(results.getString("NewMovieName"));
				newMovie.setNews(results.getString("News"));
				recentNews.add(newMovie);
			}
			
			myStmt.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return recentNews;
	}
	
	
	/**
	 * A prepared query used to return all movies from the database
	 * @return a list of movies
	 */
    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        
        try {     
            // Execute SQL query
            PreparedStatement statement = dbConnect.prepareStatement("SELECT * FROM MOVIE;");
            results = statement.executeQuery();            
            
            // Process the results set
            while (results.next()) {
            	movies.add(new Movie(results.getInt("TId"), results.getInt("MId"), results.getString("MName"), results.getInt("auditorium")));
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return movies;
    }
    
	/**
	 * A prepared query used to return all theatres from the database
	 * @return a list of theatres
	 */
    public ArrayList<Theatre> getTheatres() {
        ArrayList<Theatre> theatres = new ArrayList<Theatre>();
        
        try {     
            // Execute SQL query
            PreparedStatement statement = dbConnect.prepareStatement("SELECT * FROM THEATRE;");
            results = statement.executeQuery();            
            
            // Process the results set
            while (results.next()) {
            	theatres.add(new Theatre(results.getInt("TId"), results.getString("TName")));
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return theatres;
    }
    
	/**
	 * A prepared query used to return all showtimes from the database
	 * @return a list of showtimes
	 */
    public ArrayList<Showtime> getShowtimes() {
        ArrayList<Showtime> showtimes = new ArrayList<Showtime>();
        
        try {     
            // Execute SQL query
            PreparedStatement statement = dbConnect.prepareStatement("SELECT * FROM SHOWTIME;");
            results = statement.executeQuery();            
            
            // Process the results set
            while (results.next()) {
            	String showtimeStr = results.getString("showtime");
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            	LocalDateTime showtime = LocalDateTime.parse(showtimeStr, formatter);
            	
            	showtimes.add(new Showtime(results.getInt("MId"), results.getInt("TId"), results.getInt("auditorium"), showtime));
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return showtimes;
    }
    
	/**
	 * A prepared query used to return seats for a movie
	 * @return a list of seats
	 */
    public ArrayList<Seat> getSeats(int auditorium, int theatreId) {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        
        try {     
            // Execute SQL query
            PreparedStatement statement = dbConnect.prepareStatement("SELECT * FROM SEAT WHERE Tid = " + theatreId + " AND auditorium = " + auditorium + ";");
            results = statement.executeQuery();            
            
            // Process the results set
            while (results.next()) {
            	seats.add(new Seat(results.getInt("seatNumber"), results.getInt("auditorium"), results.getBoolean("availability"), results.getInt("TId")));
            }
            
            statement.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return seats;
    }
}