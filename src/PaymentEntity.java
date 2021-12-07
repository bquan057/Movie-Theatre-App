
public class PaymentEntity {
	
	private double price;
	private String items;
	private String email;
	private String fname;
	private String lName;
	private int ticketID;
	private String status = "unprocessed";
	
	public PaymentEntity() {}
	
	public PaymentEntity(double price, String items, String email, String fname, String lName, int ticketID,
			String status) {
		this.price = price;
		this.items = items;
		this.email = email;
		this.fname = fname;
		this.lName = lName;
		this.ticketID = ticketID;
		this.status = status;
	}

	public PaymentEntity(double price, String items, String status) {
		this.price = price;
		this.items = items;
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}	
	
	
}
