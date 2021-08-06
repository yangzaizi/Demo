package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	
	public CustomerService(CustomerRepository rep) {
		this.repo = rep;
	}
	public Iterable<CustomerSource> findAll(){
		return repo.findAll();
	}
	
}
