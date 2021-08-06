package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerSource;
import com.example.demo.repository.CustomerRepository;


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
