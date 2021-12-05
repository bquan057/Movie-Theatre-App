
public class PaymentEntity {
	
	private double price;
	private String items;
	private String status;
	
	public PaymentEntity() {}
	
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
	
	
	
}
