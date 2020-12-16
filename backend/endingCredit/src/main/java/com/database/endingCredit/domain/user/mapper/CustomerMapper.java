package com.database.endingCredit.domain.user.mapper;


import java.util.Optional;

import com.database.endingCredit.domain.user.dto.SignUpDTO;
import com.database.endingCredit.domain.user.entity.Customers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import lombok.Value;

@Mapper
public interface CustomerMapper {
    
    CustomerMapper Instance = Mappers.getMapper(CustomerMapper.class);

    Customers toCustomerEntity(SignUpDTO signUpDTO, String customerId);

    SignUpDTO toSignUpDTO(Customers customers);
}
