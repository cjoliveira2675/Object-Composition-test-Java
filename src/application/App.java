package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birthdate (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		
		Client client = new Client(name, email, date);
		System.out.println();
		System.out.println("Enter Order data");
		System.out.print("Status: ");
		OrderStatus os = OrderStatus.valueOf(sc.next());
		System.out.print("How many items to this order? ");
		int quant = sc.nextInt();
		
		Order order = new Order(new Date(), os, client);
		
		Product product;
		OrderItem oi;
		
		for (int i = 1 ; i <= quant ; i++) {
			sc.nextLine();
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			name = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			product = new Product(name, price);
			oi = new OrderItem(quantity, product.getPrice(), product);
			order.addItem(oi);
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
