package com.zoho.controller;

import java.util.List;
import java.util.Scanner;

import com.zoho.entity.Owner;
import com.zoho.entity.Product;

public class Controller {

	private Owner owner;
	static Controller controller;
	static Scanner sc = new Scanner(System.in);
	
	private Controller() {
		this.owner = new Owner();
	}
	
	public void menu() {
		List<Product> products = owner.getProducts();
		
		System.out.println("\n---------------------------------\n");
		if(products.isEmpty())
			System.out.println("Currently no products is available!");
		
		else {
			System.out.println("Available products \n\n-------------------------------\n\n");
			for(Product p : products) {
				System.out.println("Name          : "+p.getProductName());
				System.out.println("Price / kg    : "+p.getProductPrice());
				System.out.println("Quantity left : "+(p.getTotalKg() - p.getSoldKg()));
				System.out.println("------------------------------------------------");
			}
		}
	}
	
   public void addProduct() {
	   
	   
	   System.out.println("\n*******************************ADD PRODUCT****************************\n");
	   Product product = new Product();
	   
	   System.out.print("Enter product Id            : ");
	   product.setProductId(sc.nextInt());
	   
	   for(Product p : owner.getProducts())
		   if(p.getProductId() == product.getProductId())
		   {
			   System.out.println("\n --------You can't Add Product With same ID !----------\n ");
			   return;
		   }
		   
	 
	   System.out.print("Enter product Name          : ");
	   product.setProductName(sc.next());
	   System.out.print("Enter Total kg              : ");
	   product.setTotalKg(sc.nextInt()); 
	   System.out.print("Enter product price per kg  : ");
	   product.setProductPrice(sc.nextDouble());
	   owner.addProduct(product);
	   System.out.println("\n------------------------------");
	   System.out.println("Product Added");
	   System.out.println("------------------------------\n");

   }
   
   synchronized public static Controller getController() {
	   if(controller == null) {
		   controller = new Controller();
	   }	   
	   return controller;
   }
   
  public void updateProductCost(int code, double price, int quantity) {
	List<Product> products = owner.getProducts();
	
	for(Product p : products) 
		if(p.getProductId() == code) {
			p.setProfit(p.getProfit() + price);
			p.setSoldKg(p.getSoldKg() + quantity);
			
			Product product = new Product();
			product.setProductId(code);
			product.setProductName(p.getProductName());
			product.setProfit(p.getProfit());
			product.setSoldKg(p.getSoldKg());
			product.setProductPrice(p.getProductPrice());
			product.setTotalKg(p.getTotalKg());
			owner.setPersistentProduct(product);
		}

  }
  
   public Product validateProductCode(int code) {
	   
	   List<Product> products = owner.getProducts();
	   for(Product p : products) {
		   if(p.getProductId() == code)
			   return p;
	   }
	   return null;
   }
   
   public boolean verifyOwner(int pwd) {
	   if(pwd == owner.getOwnerId())
		   return true;
	   return false;
   }
   
   public void allowOwner() {
	   
	   boolean close = false;
	   System.out.println("\n-------------------------WELCOME--------------------------------");
	   System.out.println("Name   : "+owner.getOwnerName());
	   System.out.println("Shop   : "+owner.getShopName());
	   System.out.println("------------------------------------------------------------------");
	   
	  while(!close) {
		  System.out.println("\n1.) Update Product ");
		  System.out.println("2.) Add Product");
		  System.out.println("3.) See Invoice");
		  System.out.println("4.) Delete Produc");
		  System.out.println("5.) Exit");
		  
		  System.out.print("Enter your choice : ");
		  int ch = sc.nextInt();
		  
		  switch(ch) {
		  case 1 : update();
		  break;
		  case 2 : controller.addProduct();
		  break;
		  case 3 : 
			  controller.invoice();
			  break;
		  case 4:
			  controller.delete();
			  break;
		  case 5 :
			  close = true;
			  break;
			 default :
				 System.out.println("Invalid choice !");
		  }
	  }
   }
   
   private void delete() {
	
	   System.out.println("\n***************************DELETE PRODUCT**************************\n");
	   System.out.print("Enter product ID : ");
	   int id = sc.nextInt();
	   List<Product> products = owner.getProducts();
	   int index=-1;
	   
	   for(Product p : products) 
		   if(p.getProductId() == id) 
			   index = products.indexOf(p);
		   
	   
	     if(index == -1)
		   System.out.println("\n-----There is No Product with ID "+id+" ---------\n ");
	     else {
	    	 products.remove(index);
	    	 System.out.println("\n--------------Product Deleted-------------\n");
	     }
	    	 
   }
   
   private  void update() {
	   
	   if(owner.getProducts().isEmpty())
	   {
		   System.out.println("\n-------No products available-------\n");
		   return;
	   }
	   System.out.println("\n***************************UPDATE PRODUCT**************************\n");
	   System.out.println("|----------------------------------------|");
	   System.out.println("|PRODUCT NAME       |         PRODUCT  ID|");
	   System.out.println("|----------------------------------------|");
	   for(Product product : owner.getProducts())
		   System.out.println("|"+product.getProductName()+"             |                "+product.getProductId()+"|");
	   
	   System.out.print("\nEnter productID  : ");
	   int id = sc.nextInt();
	   
	
	   for(Product product : owner.getProducts()) {
		   if(product.getProductId() == id) {
			   
			   System.out.println("Available Quantity : "+(product.getTotalKg() - product.getSoldKg()));
			   System.out.print("Do you want to update Quantity ? (y/n) : ");
			   String ch = sc.next();
			   
			   if(ch.equalsIgnoreCase("y")) {
			    System.out.print("Enter product Quantity : ");
			    product.setTotalKg((product.getTotalKg() - product.getSoldKg() ) + (sc.nextInt()));
			   }
			   
			   System.out.println("Current price / kg : "+product.getProductPrice());
			   System.out.print("Do you want to update price ? (y/n) : ");
			    ch = sc.next();
			   
			    if(ch.equalsIgnoreCase("y")) {
			      System.out.println("Enter product Price  : ");
			      product.setProductPrice(sc.nextDouble());
			    }
		   }
	   }
	   
   }
   
   private  void invoice() {
	   
	   if(owner.getProducts().isEmpty())
		   System.out.println("\n-------No products available-------\n");
	   
	   else {
		   System.out.println("\n***************************INVOICE******************************\n");

		List<Product> products = null;
		if(owner.getPersistentProduct().isEmpty() && !owner.getProducts().isEmpty())
			products = owner.getProducts();
		else
			products = owner.getPersistentProduct();
		
		
		System.out.println("|----------------------------------------------------------------------------------------------|");
		System.out.println("|    ID     |        NAME         |     Total_Kg     |   sold    |   Remaining   |    profit   |");

	   for(Product p  : products) {
		System.out.println("|----------------------------------------------------------------------------------------------|");

	     System.out.println("|   "+p.getProductId()+"       |        "+p.getProductName()+"       |        "
	    		       +p.getTotalKg()+"        |      "+p.getSoldKg()+"    |       "+(p.getTotalKg() - p.getSoldKg())+"      |    "
	    		       +p.getProfit()+"   |");
	   	   }
	   
		System.out.println("|----------------------------------------------------------------------------------------------|");

	   System.out.println("---------------------------------------------------\n");
	   System.out.println("Total Profit    : "+Product.totalProfit);
	   System.out.println("\n---------------------------------------------------");
	   }
   }
}
