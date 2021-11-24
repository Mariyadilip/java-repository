package com.sort;

public class Product implements Comparable<Product>{

	private int id;
	private double price;
	private String name;
	
	public Product(int id, double price, String name) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Product o) {
		return (this.getName().compareTo(o.getName()));
	}
	
	
	
}
