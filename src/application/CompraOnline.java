package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class CompraOnline {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.printf("Insira as informações do cliente:\n");
		System.out.printf("Name: ");
		String name = sc.nextLine();
		System.out.printf("Email: ");
		String email = sc.nextLine();
		System.out.printf("Data de aniversário (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.printf("Digite o dado do pedido:\n");
		System.out.printf("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine());
		Order pedido = new Order(new Date(), status, new Client(name, email, birthDate));
		OrderItem produto = null;
		
		System.out.printf("Quantos produtos irá pedir? ");
		byte n = sc.nextByte();
		sc.nextLine();
		for (byte i=0; i<n; i++) {
			System.out.printf("Insira as informações do item #%d:\n", i+1);
			System.out.printf("Nome do produto: ");
			String productName = sc.nextLine();
			System.out.printf("Preço do produto: ");
			Double productPrice = sc.nextDouble();
			System.out.printf("Quantidade: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			produto = new OrderItem(quantity, productPrice, new Product(productName, productPrice));
			pedido.addItem(produto);
		}
		
		System.out.println("");
		System.out.print(pedido);
	
		sc.close();

	}
}
