package com.example.services;

import com.example.dto.UserDTO;
import com.example.entities.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userByEmail = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(userByEmail.getEmail(), userByEmail.getPassword(), new ArrayList<>());
    }

    public String updateUserDetails(UserDTO userForUpdate) {

        return "success User update";
    }

    public String getOneUser(Long id) {
        return "Get one User successfull";
    }

    public String deleteOneUser(Long id) {
        return "delete one User successfull";
    }
}
