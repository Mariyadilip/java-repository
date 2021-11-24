package com.zoho.entity;

public class Product {

	private int productId;
	private String productName;
	private double productPrice;
	private int totalKg;
	
	private double profit;
	private int soldKg;
	
	public static double totalProfit;
	
	public static double getTotalProfit() {
		return totalProfit;
	}
	public static void setTotalProfit(double totalProfit) {
		Product.totalProfit = totalProfit;
	}
	public int getSoldKg() {
		return soldKg;
	}
	public void setSoldKg(int soldKg) {
		this.soldKg = soldKg;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getTotalKg() {
		return totalKg;
	}
	public void setTotalKg(int totalKg) {
		this.totalKg = totalKg;
	}
	
}
