import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Aron Saengchan
 * @version 1.0
 * @since December 1, 2021
 */
public class BookTicketController implements ActionListener {
	
	private SearchMoviesView searchMoviesView;
	
	private SeatAvailabilityView seatAvailabilityView;
	
	private ConfirmReservationView confirmReservationView;
	
	private EnterInfoView enterInfoView;
	
	public BookTicketController() {
		this.searchMoviesView = new SearchMoviesView();
		this.searchMoviesView.addActionListeners(this);
//		searchMoviesView.getMovieComboBox().addActionListener(this);
//		searchMoviesView.getTheatreComboBox().addActionListener(this);
//		searchMoviesView.getShowtimeComboBox().addActionListener(this);
//		searchMoviesView.getContinueButton().addActionListener(this);
		
		this.seatAvailabilityView = new SeatAvailabilityView();
		this.seatAvailabilityView.addActionListeners(this);
		
		
		this.confirmReservationView = new ConfirmReservationView();
		this.confirmReservationView.addActionListeners(this);
		// Add action listeners
		
		this.enterInfoView = new EnterInfoView();
		this.enterInfoView.addActionListeners(this);
		
		
		
		this.searchMoviesView.activate();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Refresh ComboBoxes in searchMoviesView
		
		if (e.getSource() == this.searchMoviesView.getContinueButton()) {
			this.searchMoviesView.deactivate();
			this.seatAvailabilityView.activate();
		} else if (e.getSource() == this.confirmReservationView.getContinueButton()) {
			this.confirmReservationView.deactivate();
			this.enterInfoView.activate();
		} else {
			for (int i = 0; i < this.seatAvailabilityView.getSeats().length; i++) {
				if (e.getSource() == this.seatAvailabilityView.getSeats()[i]) {
					this.seatAvailabilityView.deactivate();
					this.confirmReservationView.activate();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new BookTicketController();
	}
}
