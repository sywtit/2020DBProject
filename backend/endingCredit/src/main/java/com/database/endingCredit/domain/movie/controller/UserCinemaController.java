package com.database.endingCredit.domain.movie.controller;

import com.database.endingCredit.domain.movie.dto.UserCinemaDTO;
import com.database.endingCredit.domain.movie.service.UserCinemaService;
import com.database.endingCredit.domain.user.dto.UserIdDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserCinemaController {
    
    @Autowired
    private UserCinemaService service;

    @CrossOrigin(origins = "*")
    @PostMapping("/cinema")
    @ResponseStatus(value = HttpStatus.OK)
    public UserCinemaDTO getWholeCinemaList(@RequestBody UserIdDTO userIdDTO) {
        System.out.println(userIdDTO.getCustomerId());
        return service.getInfoList(userIdDTO);
    }
}
