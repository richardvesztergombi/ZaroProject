package com.example.controllers;

import com.example.dto.UserDTO;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping
    public String updateUser(@RequestBody UserDTO userForUpdate){
        return  userService.updateUserDetails(userForUpdate);
    }

    @GetMapping
    public String getOneUser(@PathVariable Long id){
        return userService.getOneUser(id);
    }

    @DeleteMapping
    public String deleteOneUser(@PathVariable Long id){
        return userService.deleteOneUser(id);
    }

}
