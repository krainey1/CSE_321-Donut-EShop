package p1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OrdersList {
	public ArrayList<Order> list;
	private static final int WEEK_TO_DAYS = 7;
	private static final int MONTH_TO_DAYS = 28;
	private static final int YEAR_TO_DAYS = 365;

	public OrdersList() {
		this.list = new ArrayList<>();
		
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/donutdb",
	                                            "root", /*password here */);
	       Statement sql_stmt = conn.createStatement();
	        ResultSet records = sql_stmt.executeQuery("SELECT * FROM doughnut_orders");
	        while (records.next()) {
	          int OrderID = records.getInt("OrderID");
	          String name = records.getString("name");
	          String cardNum = records.getString("CardNumber");
	          float total = records.getFloat("Total");
	          Date date = records.getDate("Timestamp");
	          String status = records.getString("Status");
	          String log = records.getString("TransactionLog");
	          Order order = new Order(OrderID, name, cardNum, total, date, status,log);
	          list.add(order);
	        }

	      } catch (Exception e) {
	        e.printStackTrace();
	      }
		
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	

	public float weeklyTotal() {
		// get current time of whatever computer is running the JVM
		long currentTime = System.currentTimeMillis();
		// create before and after windows spaning a week
		// Date window = new Date(System.currentTimeMillis());
		
		Date beforeWindow = new Date(currentTime - TimeUnit.DAYS.toMillis(WEEK_TO_DAYS));
		Date afterWindow = new Date(currentTime + TimeUnit.DAYS.toMillis(WEEK_TO_DAYS));
		float total = 0;
		for (Order o : list) {
			Date date = o.getTimeStamp();
			if(!date.after(afterWindow) && !date.before(beforeWindow)) {
				total += o.getTotal();
				
			}
		}
		return total;
	}
	
	public float monthlyTotal() {
		// get current time of whatever computer is running the JVM
		long currentTime = System.currentTimeMillis();
		// create before and after windows spaning a week
		// Date window = new Date(System.currentTimeMillis());
		
		Date beforeWindow = new Date(currentTime - TimeUnit.DAYS.toMillis(MONTH_TO_DAYS));
		Date afterWindow = new Date(currentTime + TimeUnit.DAYS.toMillis(MONTH_TO_DAYS));
		float total = 0;
		for (Order o : list) {
			Date date = o.getTimeStamp();
			if(!date.after(afterWindow) && !date.before(beforeWindow)) {
				total += o.getTotal();
				
			}
		}
		return total;
	}
	
	public float yearlyTotal() {
		// get current time of whatever computer is running the JVM
		long currentTime = System.currentTimeMillis();
		// create before and after windows spaning a week
		// Date window = new Date(System.currentTimeMillis());
		
		Date beforeWindow = new Date(currentTime - TimeUnit.DAYS.toMillis(YEAR_TO_DAYS));
		Date afterWindow = new Date(currentTime + TimeUnit.DAYS.toMillis(YEAR_TO_DAYS));
		float total = 0;
		for (Order o : list) {
			Date date = o.getTimeStamp();
			if(!date.after(afterWindow) && !date.before(beforeWindow)) {
				total += o.getTotal();
				
			}
		}
		return total;
	}
	
	
}
