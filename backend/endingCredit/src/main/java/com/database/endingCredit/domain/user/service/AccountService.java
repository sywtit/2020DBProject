package com.database.endingCredit.domain.user.service;

import java.util.Optional;

import com.database.endingCredit.domain.user.dto.SignUpDTO;
import com.database.endingCredit.domain.user.dto.UserIdDTO;
import com.database.endingCredit.domain.user.entity.Customers;
import com.database.endingCredit.domain.user.mapper.CustomerMapper;
import com.database.endingCredit.domain.user.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    public SignUpDTO getinfo(UserIdDTO userIdDTO) {

        Optional<Customers> customers = customerRepository.findById(userIdDTO.getCustomerId());
        SignUpDTO signUpDTO = CustomerMapper.Instance.toSignUpDTO(customers);
		return signUpDTO;
	}

    
}
