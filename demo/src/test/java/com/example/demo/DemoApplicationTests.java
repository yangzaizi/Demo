package com.example.demo;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private MockMvc mockMvc;

	private CustomerService service;
	
	private CustomerController controller;

	@MockBean
	private CustomerRepository repo;
	
	String exampleJson = "[{\"customerId\":1,\"customerName\":\"abc\",\"customerAddress\":\"cde\"}]";

	@Before
    public void setup(){
        // init mocks
      service = new CustomerService(repo);
      controller = new CustomerController(service);
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	@Test
	public void testService() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<CustomerSource>> typeReference = new TypeReference<List<CustomerSource>>() {};
		List<CustomerSource> sources = mapper.readValue(exampleJson, typeReference);

		Mockito.when(repo.findAll()).thenReturn(sources);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/customers").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(exampleJson, result.getResponse()
				.getContentAsString(), false);
	}
	



}
