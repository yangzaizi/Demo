package com.example.demo;

import lombok.AllArgsConstructor;

public class Customer {

	private long customerId;
	private String customerName;
	private String customerAddress;
	
	public void setCustomerId(long id){
		this.customerId = id;
	}
	
	public void setCustomerNamer(String name) {
		this.customerName = name;
	}
	
	public void setCustomerAddress(String address) {
		this.customerAddress = address;
	}
	
	public long getCustomerId(){
		return this.customerId;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public String getCustomerAddress() {
		return this.customerAddress;
	}

}
