/**
 * Represents a ticket entity
 * @author roh_i
 *
 */
public class Ticket {
	
	private int seatNumber;
	private int auditorium;
	private String movie;
	private String theatre;
	private String showtime;
	private String email;
	private String status;
	
	
	
	public Ticket(int seatNumber, int auditorium, String movie, String theatre, String showtime, String email, String status) {
		this.seatNumber = seatNumber;
		this.auditorium = auditorium;
		this.movie = movie;
		this.theatre = theatre;
		this.showtime = showtime;
		this.email = email;
		this.status = status;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}
	
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public int getAuditorium() {
		return auditorium;
	}
	
	public void setAuditorium(int auditorium) {
		this.auditorium = auditorium;
	}
	
	public String getMovie() {
		return movie;
	}
	
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public String getTheatre() {
		return theatre;
	}
	
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	
	public String getShowtime() {
		return showtime;
	}
	
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}