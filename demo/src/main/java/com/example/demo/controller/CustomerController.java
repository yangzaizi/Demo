package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerSource;
import com.example.demo.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerMapper impl;
	

	public CustomerController(CustomerService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@GetMapping("/customers")
	public Iterable<Customer> list(@RequestParam(required=false) Long id ){
		Iterable<CustomerSource> sources = service.findAll();
		
		List<Customer> c = new ArrayList<Customer>();
		
		if(id != null) {
			
			try {
				Long.parseLong(""+id);
			}catch(Exception e) {
				throw new BadException();
			}
			for(CustomerSource src : sources) {
				if(src.getCustomerId() == id) {
					c.add(impl.toCustomer(src));
					break;
				}
			}
		}else {
			int count = 0;
			
			for(CustomerSource src : sources) {
				c.add(impl.toCustomer(src));
				count ++;
				
				if(count == 10) {
					break;
				}
			}
			
		}
		
		
		return c;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public static class BadException extends RuntimeException {
	    public BadException() {
	        super("More than 1 id is passed in!");
	    }
	}

}
