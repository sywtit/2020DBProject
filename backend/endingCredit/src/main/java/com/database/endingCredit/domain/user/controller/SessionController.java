package com.database.endingCredit.domain.user.controller;

import com.database.endingCredit.domain.user.dto.SignUpDTO;
import com.database.endingCredit.domain.user.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class SessionController {
    
    @Autowired
    private SessionService service;


    @CrossOrigin(origins = "*")
    @PostMapping("/account/signup")
    @ResponseStatus(value = HttpStatus.OK)
    public void addUser(@RequestBody SignUpDTO signUpDTO) {
        service.saveUser(signUpDTO);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/account/auth")
    @ResponseStatus(value = HttpStatus.OK)
    public String giveUserId(@RequestBody SignUpDTO signUpDTO) {
        service.saveUser(signUpDTO);
        return null;
    }
}
