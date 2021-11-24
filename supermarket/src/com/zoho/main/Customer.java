package com.zoho.main;

public class Customer {
 private int custID;
 private String custName;
 private double totalAmount;
 private boolean premimumUser;
 
public int getCustID() {
	return custID;
}
public void setCustID(int custID) {
	this.custID = custID;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public boolean isPremimumUser() {
	return premimumUser;
}
public void setPremimumUser(boolean premimumUser) {
	this.premimumUser = premimumUser;
}
 
}
