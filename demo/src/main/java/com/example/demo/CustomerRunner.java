package com.example.demo;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomerRunner implements CommandLineRunner{

	@Autowired
	public CustomerRepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<CustomerSource>> typeReference = new TypeReference<List<CustomerSource>>() {};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/customer.json");
		List<CustomerSource> sources = mapper.readValue(inputStream, typeReference);
		for(CustomerSource src : sources) {
			repo.save(src);
		}
		
	}

	
	
}
