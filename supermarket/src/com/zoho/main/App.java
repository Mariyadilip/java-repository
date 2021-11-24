package com.zoho.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.zoho.controller.Controller;
import com.zoho.entity.Product;


public class App {

	static Scanner sc = new Scanner(System.in);
	static Controller controller = Controller.getController();
     
	public static void main(String[] args) {

		while (true) {
			System.out.println("\n----------------Super Market-------------------");
			System.out.println("1.)Owner ".toUpperCase());
			System.out.println("2.)Calculate bill ".toUpperCase());
			System.out.println("3.)Display All Products ".toUpperCase());
			System.out.println("4.)Exit".toUpperCase());
			System.out.println("------------------------------------\n");
			System.out.print("Enter your choice : ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				login();
				break;
			case 2:
				calculateBill();
				break;
			case 3:
				controller.menu();
				break;
			case 4:
				System.exit(1);
			default:
				System.out.println("Invaild choice!!");
			}
		}
	}

	private static void calculateBill() {

		double total = 0;
		List<Product> customerProduct = new ArrayList<>();
		
		while (true) {
			Product product = null;
			System.out.print("\nEnter product Code : ");
			int code = sc.nextInt();
			product = controller.validateProductCode(code);

			if (product != null) {
				System.out.print("Enter quantity : ");
				int q = sc.nextInt();
				int quantity =  (product.getTotalKg() - product.getSoldKg());
				if(q > quantity)
				{
					System.out.println("\n\nplease enter sufficient quantity ! "+product.getProductName());
					System.out.println("Available Quantity "+quantity+" \n\n");
					break;
				}
				
				double price = q * product.getProductPrice();
				total += price;
				
				Product prod = new Product();
				prod.setProductName(product.getProductName());
				prod.setProductPrice(price);
				prod.setTotalKg(q);
				
				customerProduct.add(prod);
				controller.updateProductCost(code, price, q);
				Product.totalProfit += total;
			}

			else
				System.out.println("\n Invalid code !");
			
			System.out.print("Want to add product's (y/n) : ");
			String ch = sc.next();
			
			if(ch.equalsIgnoreCase("n"))
				break;
		}
		
		generateBill(customerProduct, total);
	}
   
	private static void generateBill(List<Product> p, double total) {
	  
		System.out.println("\nItems you Bought \n");
		
		for(Product product : p) {
			System.out.println("**************************************");
			System.out.println("Name      : "+product.getProductName());
			System.out.println("Quantity  : "+product.getTotalKg()+" kg");
			System.out.println("Price     : "+product.getProductPrice());
		}
		System.out.println("\n------------------------------------------------\n");
		System.out.println("Total Amount  : "+total);
		System.out.println("\n----------------------------------------------\n");
	}
	
	private static void login() {

		System.out.print("Enter password : ");
		int pwd = sc.nextInt();
		if(controller.verifyOwner(pwd))
		  controller.allowOwner();
		else
			System.out.println("Wrong password");
	}

}
