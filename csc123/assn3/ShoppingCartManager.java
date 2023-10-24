import java.text.*;
import java.util.*;
public class ShoppingCartManager {
	static ArrayList<ShoppingCart> itemList = new ArrayList<ShoppingCart>();
	public static void main(String[] args) throws ParseException {
		menu();
	}
	static void menu() throws ParseException {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		int amount = 0;
		String name;
		String vendor;
		double price;
		double cost;
		double weight;
		
		String author;
		String pMonth;
		int pageNum;
		
		Date sellBy = null;
		Date useBy = null;
		
		int choice = 0;
		do {
			System.out.print("1.) Add item\n2.) View items\n3.) Exit\nEnter choice: ");
			if(input.hasNextInt()) {
				choice = input.nextInt();
				if(choice > 0 && choice < 4) 
					break;
			}
			System.out.println("\nEnter a valid choice\n");
			input.nextLine();
		}while(true);
		switch(choice) {
		case 1:
			System.out.print("\nName: ");
			name = input.next();
			System.out.print("Vendor: ");
			vendor = input.next();
			System.out.print("Price: ");
			price = input.nextDouble();
			System.out.print("Cost: ");
			cost = input.nextDouble();
			System.out.print("Weight (lbs): ");
			weight = input.nextDouble();
			int newChoice = 0;
			do {
				System.out.print("\n1.) Publication\n2.) Food\n3.) General\nEnter choice: ");
				if(input.hasNextInt()) {
					newChoice = input.nextInt();
					if(newChoice > 0 && newChoice < 4) 
						break;
				}
				System.out.println("\nEnter a valid choice\n");
				input.nextLine();
			}while(true);
			switch(newChoice) {
			case 1: 
				System.out.print("\nAuthor: ");
				author = input.next();
				System.out.print("Publication month: ");
				pMonth = input.next();
				System.out.print("Number of pages: ");
				pageNum = input.nextInt();
				itemList.add(new ShoppingCart(name, vendor, author, pMonth, pageNum, price, cost, weight));
				break;
			case 2: 
				System.out.println("\nSell by (mm/dd/yyyy): ");
				sellBy = df.parse(input.next());
				System.out.println("Use by (mm/dd/yyyy): ");
				useBy = df.parse(input.next());
				itemList.add(new ShoppingCart(name, vendor, sellBy, useBy, price, cost, weight));
				break;
			case 3:
				itemList.add(new ShoppingCart(name, vendor, price, cost, weight));
				break;
			}
			amount++;
			System.out.println();
			menu();
			break;
		case 2: 
			double total = 0;
			System.out.println("\nAmount of items: " +amount);
			for(int i = 0; i < itemList.size(); i++) {
				System.out.println(itemList.get(i));
				total += itemList.get(i).getTotal();
			}
			total = Math.floor(total * 100) / 100;
			System.out.println("Total: "+total+"$\n");
			menu();
			break;
		case 3: 
			System.out.println("Thank you for using the program");
			input.close();
			break;
		}
	}
}