import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * A class used as the interface to the theatre database using JDBC.
 * @author Brandon Quan, Rohinesh Ram
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
		}catch(Exception e) {
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
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return recentNews;
	}
	
	public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/*
	 * A prepared query used to verify that a ticket is in the database
	 */
	public Ticket validateTicket(String email, int id) {
		
		Ticket ticket = new Ticket();
		String query = "SELECT *"
				+ "FROM (TICKET as T, MOVIE as M, THEATRE as TH)"
				+ "WHERE (T.Tid = TH.Tid AND T.Mid = M.Mid AND ticketId=?);";
		
		try {
			PreparedStatement statement = dbConnect.prepareStatement(query);
			statement.setInt(1,id);
			
			results = statement.executeQuery();
			
			// ticket not in db
			if(!results.next()) {
				return null;
			}
			
			// ticket found, build ticket
			ticket.setTicketId(results.getInt("TicketId"));
			ticket.setSeatNumber(results.getInt("seatNumber"));
			ticket.setMovie(results.getString("MName"));
			ticket.setTheatre(results.getString("TName"));
			ticket.setShowtime(results.getString("showtime"));
			ticket.setEmail(results.getString("Email"));
			ticket.setStatus(results.getString("Tstatus"));
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ticket;
	}
	
	/*
	 * Used to check if a showtime is valid
	 */
	public boolean checkShowtime(String showtime) {
		
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime show = LocalDateTime.parse(showtime);
		
		return current.isBefore(show.plusDays(3));
	}

	public void updateSeatAvailability(Ticket ticket) {
		
		int id = ticket.getTicketId();
		int theatreId = 0;
		int seatNumber = 0;
		int auditorium = 0;
		
		// get TheatreId, seatNumber, auditorium from ticket table
		String query = "SELECT TId, seatNumber, auditorim FROM TICKET WHERE ticketId = ?;";
		
		try {
			PreparedStatement statement = dbConnect.prepareStatement(query);
			statement.setInt(1, id);
			results = statement.executeQuery();
			
			// move cursor
			results.next();
			theatreId = results.getInt("TId");
			seatNumber = results.getInt("seatNumber");
			auditorium = results.getInt("aduitorium");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// update seat table
		query = "UPDATE SEAT SET availability=? WHERE theatreId=? AND"
				+ " seatNumber=? AND TId = ?;";
		
		try {
			PreparedStatement statement = dbConnect.prepareStatement(query);
			statement.setBoolean(1, true);
			statement.setInt(2, theatreId);
			statement.setInt(3, seatNumber);
			statement.setInt(4, auditorium);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * A prepared statement to add a new credit entry to the credit table
	 */
	public void addCredit(Credit newCredit) {
		String query = "INSERT INTO CREDIT (email, amount) VALUE(?, ?)";
		
		try {
			PreparedStatement statement = dbConnect.prepareStatement(query);
			statement.setString(1, newCredit.getEmail());
			statement.setDouble(2, newCredit.getAmount());
			
			statement.executeUpdate();
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * A prepared statement to update the status of a ticket
	 */
	public void updateTicketStatus(Ticket ticket) {
		String query = "UPDATE TICKET SET Tstatus=? WHERE ticketId=?;";
		
		try {
			PreparedStatement statement = dbConnect.prepareStatement(query);
			statement.setString(1, ticket.getStatus());
			statement.setInt(2, ticket.getTicketId());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
