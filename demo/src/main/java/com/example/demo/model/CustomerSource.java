package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class CustomerSource {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerName;
	private String customerAddress;
	
	
	public void setCustomerId(long id){
		this.customerId = id;
	}
	
	public void setCustomerName(String name) {
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
