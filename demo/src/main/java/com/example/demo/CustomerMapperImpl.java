package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl {
	
	public Customer toCustomer(CustomerSource source){
	       Customer c = new Customer();
	       c.setCustomerId(source.getCustomerId());
	       c.setCustomerNamer(source.getCustomerName());
	       c.setCustomerAddress(source.getCustomerAddress());
	       return c;
	       
	    }
	

	

}
