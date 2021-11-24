package com.zoho.entity;

import java.util.ArrayList;
import java.util.List;

import com.zoho.main.Customer;

public class Owner {

	private final int ownerId = 101;
	private String ownerName = "Ravi";
	private String shopName = "New Super Market";
	
	private  List<Customer> customers = new ArrayList<>();
	private  List<Product> products = new ArrayList<>();
	private  List<Product> persistentProduct = new ArrayList<>();
	
	public  List<Product> getPersistentProduct() {
		return persistentProduct;
	}

	public  void setPersistentProduct(Product p) {
      persistentProduct.add(p);
	}

	public  int getOwnerId() {
		return ownerId;
	}

	public  String getOwnerName() {
		return ownerName;
	}

	public  String getShopName() {
		return shopName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	

}
