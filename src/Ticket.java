import java.time.LocalDateTime;

/**
 * @author Aron Saengchan
 * @version 1.0
 * @since December 4, 2021
 */
public class Ticket {
	
	private int seatNumber;
	
	private int ticketId;
	
	private String movie;
	
	private String theatre;
	
	private LocalDateTime showtime;
	
	private String email;
	
	private String status;
	
	public Ticket(int seatNumber, int ticketId, String movie, String theatre, LocalDateTime showtime, String email, String status) {
		this.seatNumber = seatNumber;
		this.ticketId = ticketId;
		this.movie = movie;
		this.theatre = theatre;
		this.showtime = showtime;
		this.email = email;
		this.status = status;
	}

	// Getters and setters
	public int getSeatNumber() {
		return seatNumber;
	}

	public int getTicketId() {
		return ticketId;
	}

	public String getMovie() {
		return movie;
	}

	public String getTheatre() {
		return theatre;
	}

	public LocalDateTime getShowtime() {
		return showtime;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
