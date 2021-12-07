package DataSource;
/**
 * Class that represents a theatre object
 * @author Aron Saengchan
 */
public class Theatre {
	
	private int theatreId;
	
	private String theatreName;

	public Theatre(int theatreId, String theatreName) {
		this.theatreId = theatreId;
		this.theatreName = theatreName;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}
	
	

}
