package p1;

import java.sql.Date;
import java.util.ArrayList;

public class Order {

	private int OrderID;
	private String name;
	private String cardNumber;
	private float total;
	private Date timeStamp;
	private String status;
	private String log;
	private static final String CSV_REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

	
	Order(int OrderID, String name, String cardNumber, float total, Date timeStamp, String status, String log) {
		this.OrderID = OrderID;
		this.name = name;
		this.cardNumber = cardNumber;
		this.total = total;
		this.timeStamp = timeStamp;
		this.status = status;
		this.log = log;
	}
	
	public int getOrderID() {
		return OrderID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	public float getTotal() {
		return total;
	}
	
	public boolean isClosed() {
		return status.equals("Closed");
	
	}
	
	public boolean isOpen() {
		return status.equals("Open");
	}
	
	public ArrayList<String> getLog() {
		String[] tokens = this.log.split(CSV_REGEX);
		ArrayList<String> transactions = new ArrayList<>();
		for(String token: tokens) {
			transactions.add(token);
		}
		
		return transactions;
	}

}
