package com.example.controllers;

import com.example.dto.RegisterDTO;
import com.example.dto.UserRegistrationResponseDTO;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class UserRegistration {
    @Autowired
    UserService userService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRegistrationResponseDTO userRegistration(@RequestBody RegisterDTO userRegistrationRequestDTO){
        return userService.userRegistration(userRegistrationRequestDTO);
    }
}
