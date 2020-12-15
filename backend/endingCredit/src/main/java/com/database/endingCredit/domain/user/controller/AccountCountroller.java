package com.database.endingCredit.domain.user.controller;

import com.database.endingCredit.domain.user.dto.SignUpDTO;
import com.database.endingCredit.domain.user.dto.UserIdDTO;
import com.database.endingCredit.domain.user.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountCountroller {
    
    @Autowired
    private AccountService service;
    //get account info
    @CrossOrigin(origins = "*")
    @PostMapping("/info")
    @ResponseStatus(value = HttpStatus.OK)
    public SignUpDTO getUserInfo(@RequestBody UserIdDTO userIdDTO) {
        return service.getinfo(userIdDTO);
    }
}
