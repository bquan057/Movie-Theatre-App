
public class Seat {
	
	private int seatNum;
	
	private int auditorium;
	
	private boolean availability;
	
	private int theatreId;

	public Seat(int seatNum, int auditorium, boolean availability, int theatreId) {
		super();
		this.seatNum = seatNum;
		this.auditorium = auditorium;
		this.availability = availability;
		this.theatreId = theatreId;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public int getAuditorium() {
		return auditorium;
	}

	public boolean isAvailable() {
		return availability;
	}

	public int getTheatreId() {
		return theatreId;
	}

}
