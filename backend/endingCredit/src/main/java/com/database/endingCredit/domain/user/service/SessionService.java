package com.database.endingCredit.domain.user.service;

import com.database.endingCredit.domain.user.dto.LoginDTO;
import com.database.endingCredit.domain.user.dto.SignUpDTO;
import com.database.endingCredit.domain.user.entity.Customers;
import com.database.endingCredit.domain.user.mapper.CustomerMapper;
import com.database.endingCredit.domain.user.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private CustomerRepository customerRepository;

	public void saveUser(SignUpDTO signUpDTO) {

        //get next CustomerId
        Customers customers = customerRepository.findRecentIdNumber();
        String customerId = customers.getCustomerId();
        String customerIdIndex = customerId.substring(0,1);

        int customerNum = Integer.parseInt(customerIdIndex);
        customerNum = customerNum +1;
        String newCustomerIdIndex = Integer.toString(customerNum);

        //generate newCustomerId
        String newCustomerId = newCustomerIdIndex+newCustomerIdIndex+newCustomerIdIndex+"-"
        +newCustomerIdIndex+newCustomerIdIndex+"-"+newCustomerIdIndex+newCustomerIdIndex+newCustomerIdIndex
        +newCustomerIdIndex;

        Customers customer = new Customers();
        // save to customers databse
        customer = CustomerMapper.Instance.toCustomerEntity(signUpDTO,newCustomerId);
        customerRepository.save(customers);

	}

	public String getUserId(LoginDTO loginDTO) {
        Customers customer = customerRepository.findByEmail(loginDTO.getEmail());
        return customer.getCustomerId();
	}
    
}
