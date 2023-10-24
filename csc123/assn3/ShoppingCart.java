import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingCart {
	String name;
	String vendor = "N/A";
	String author;
	String pMonth;
	int pageNum;
	String sellby;
	String useby;
	double price;
	double cost;
	double weight;
	final double taxRate = 1.0725;
	final double tax = 7.25;
	double total;
	public ShoppingCart(String name, String vendor, double price, double cost, double weight) {
		this.name = name;
		this.vendor = vendor;
		this.price = price;
		this.cost = cost;
		this.weight = weight;
		total = this.price * taxRate;
		total = Math.floor(total*100)/100;
	}
	public ShoppingCart(String name, String vendor, String author, String pMonth, int pageNum, double price, double cost, double weight) {
		this.name = name;
		this.vendor = vendor;
		this.author = author;
		this.pMonth = pMonth;
		this.pageNum = pageNum;
		this.price = price;
		this.cost = cost;
		this.weight = weight;
		total = this.price * taxRate;
		total = Math.floor(total*100)/100;
		
	}
	public ShoppingCart(String name, String vendor, Date sellBy, Date useBy, double price, double cost, double weight) {
		this.name = name;
		this.vendor = vendor;
		this.price = price;
		this.cost = cost;
		this.weight = weight;
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy");
		this.sellby = df.format(sellBy);
		this.useby = df.format(useBy);
		total = this.price * taxRate;
		total = Math.floor(total*100)/100;
	}
	double getTotal() {
		return total;
	}
	@Override
	public String toString() {
		return "Name: " + name + " - Price: " + price + "$ - Tax: " + tax + "% - Total item price: " + total + "$";
	}
}

