import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller class for booking a ticket
 * @author Aron Saengchan
 *
 */
public class BookTicketController implements ActionListener {
	
	/**
	 * Theatre service that connects to the database
	 */
	private TheatreService theatreService;
	
	/**
	 * 	Sub-views for the book ticket view
	 */
	private SearchMoviesView searchMoviesView;
	
	private SeatAvailabilityView seatAvailabilityView;
	
	private ConfirmReservationView confirmReservationView;
	
	private EnterInfoView enterInfoView;
	
	/**
	 * 	User-selected options
	 */
	private Movie selectedMovie;
	
	private Theatre selectedTheatre;
	
	private Showtime selectedShowtime;
	
	private Seat selectedSeat;
	
	/**
	 * Constructor to initialize the book ticket controller
	 */
	public BookTicketController(TheatreService theatreService) {
		
		this.theatreService = theatreService;
		// Load the movies onto the search movie page
		this.searchMoviesView = new SearchMoviesView();
		ArrayList<Movie> movies = this.getMovies();
		
		for (int i = 0; i < movies.size(); i++) {
			this.searchMoviesView.getMovieComboBox().addItem(movies.get(i).getName());
		}
		
		this.searchMoviesView.addActionListeners(this);	
	}
	


	/**
	 * Performs the appropriate action to an action event
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Re-organize the sequence
		
		if (e.getSource() == this.searchMoviesView.getContinueButton()) {
			
			for (Showtime showtime: this.getShowtimes()) {
				if(showtime.getShowtime().equals(this.searchMoviesView.getShowtimeComboBox().getSelectedItem())) {
					this.selectedShowtime = showtime;
				}
			}

			this.seatAvailabilityView = new SeatAvailabilityView(this.getSeats());
			this.seatAvailabilityView.addActionListeners(this);
			
			this.searchMoviesView.deactivate();
			this.seatAvailabilityView.activate();
		
		} else if (this.confirmReservationView != null && e.getSource() == this.confirmReservationView.getContinueButton()) {
			this.confirmReservationView.deactivate();
			
			this.enterInfoView = new EnterInfoView();
			this.enterInfoView.addActionListeners(this);
			this.enterInfoView.activate();
			
		} else if (e.getSource() == this.searchMoviesView.getMovieComboBox()) {
			this.searchMoviesView.getTheatreComboBox().removeAllItems();
			this.searchMoviesView.getShowtimeComboBox().removeAllItems();
			this.searchMoviesView.getTheatreComboBox().setEnabled(true);
			ArrayList<Theatre> theatres = this.getTheatres();
			this.selectedMovie = this.getMovies().get(this.searchMoviesView.getMovieComboBox().getSelectedIndex());
			
			for (int i = 0; i < theatres.size(); i++) {
				if (selectedMovie.getTheatreId() == theatres.get(i).getTheatreId()) {
					this.searchMoviesView.getTheatreComboBox().addItem(theatres.get(i).getTheatreName());
				}
			}
		} else if (e.getSource() == this.searchMoviesView.getTheatreComboBox()) {
			this.searchMoviesView.getShowtimeComboBox().removeAllItems();
			this.searchMoviesView.getShowtimeComboBox().setEnabled(true);
			this.searchMoviesView.getContinueButton().setEnabled(true);
			ArrayList<Showtime> showtimes = this.getShowtimes();
			
			for (Theatre theatre: this.getTheatres()) {
				if(theatre.getTheatreName().equals(this.searchMoviesView.getTheatreComboBox().getSelectedItem())) {
					this.selectedTheatre = theatre;
				}
			}
			
			for (int i = 0; i < showtimes.size(); i++) {
				if (this.selectedMovie.getMovieId() == showtimes.get(i).getMovieId() && this.selectedTheatre.getTheatreId() == showtimes.get(i).getTheatreId()) {
					this.searchMoviesView.getShowtimeComboBox().addItem(showtimes.get(i).getShowtime());
				}
			}
			
		} else if (this.seatAvailabilityView != null && this.enterInfoView == null) {
			for (int i = 0; i < this.seatAvailabilityView.getSeatButtons().size(); i++) {
				if (e.getSource() == this.seatAvailabilityView.getSeatButtons().get(i)) {
					this.selectedSeat = this.getSeats().get(i);
					this.seatAvailabilityView.deactivate();
					
					this.confirmReservationView = new ConfirmReservationView(this.selectedMovie, this.selectedTheatre, this.selectedShowtime, this.selectedSeat);
					this.confirmReservationView.addActionListeners(this);
					this.confirmReservationView.activate();
				}
			}
			
		} else if (this.enterInfoView != null && e.getSource() == this.enterInfoView.getContinueButton()) {
			this.createTicket();
			this.enterInfoView.deactivate();
		}

	}
	
	/**
	 * Database access methods
	 */
	public ArrayList<Movie> getMovies() {
		theatreService.initializeConnection();
		return this.theatreService.getMovies();
	}
	
	public ArrayList<Theatre> getTheatres() {
		theatreService.initializeConnection();
		return this.theatreService.getTheatres();
	}
	
	public ArrayList<Showtime> getShowtimes() {
		theatreService.initializeConnection();
		return this.theatreService.getShowtimes();
	}
	
	public ArrayList<Seat> getSeats() {
		theatreService.initializeConnection();
		return this.theatreService.getSeats(this.selectedMovie.getAuditorium(), this.selectedTheatre.getTheatreId());
	}
	
	/**
	 * Creates a movie ticket
	 * @return a ticket containing the user's movie reservation
	 */
	public Ticket createTicket() {
		return new Ticket(this.selectedSeat.getSeatNum(), this.selectedMovie.getAuditorium(), this.selectedMovie.getName(), this.selectedTheatre.getTheatreName(),
				this.selectedShowtime.getShowtime().toString(), this.enterInfoView.getEmailTextField().getText(), "available");
	}
	
	
	public void displaySearchMoviesView() {
		this.searchMoviesView.activate();
	}
//	// Remove this once integrated
//	public static void main(String[] args) {
//		new BookTicketController();
//	}
}