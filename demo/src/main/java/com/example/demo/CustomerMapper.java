package com.example.demo;

import org.mapstruct.Mapper;


@Mapper(uses = { CustomerMapperImpl.class }, componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerSource source);
}
