package com.example.demo;

import org.mapstruct.Mapper;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerSource;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerSource source);
}
