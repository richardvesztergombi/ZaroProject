package com.example.services;

import com.example.dto.RegisterDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserLoginResponseDTO;
import com.example.dto.UserRegistrationResponseDTO;
import com.example.entities.User;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User userByEmail = userRepository.findByEmail(email);
        if (userByEmail == null) throw new UsernameNotFoundException(email);
        return new org.springframework.security.core.userdetails.User(userByEmail.getEmail(), userByEmail.getEncryptedPassword(), new ArrayList<>());
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

    public UserRegistrationResponseDTO userRegistration(RegisterDTO newUser) {
        User userbyEmail = null;
        userbyEmail = userRepository.findByEmail(newUser.getEmail());
        if(userbyEmail != null){
            return null;
        }

        UserRegistrationResponseDTO responseDTO = new UserRegistrationResponseDTO();

        User userAfterSaving = mappingFromDTOtoEntity(newUser);
        responseDTO = mappingFromStoredUserToResponseDTO(userAfterSaving);

        LOGGER.warn(">>>> User registration successfully");
        return responseDTO;
    }

    private UserRegistrationResponseDTO mappingFromStoredUserToResponseDTO(User userAfterSaving) {
        UserRegistrationResponseDTO returnDTO = new UserRegistrationResponseDTO();

        returnDTO.setUserName(userAfterSaving.getUserName());
        returnDTO.setEmail(userAfterSaving.getEmail());

        return returnDTO;
    }

    private User mappingFromDTOtoEntity(RegisterDTO newUser) {
        User user = new User();

        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        User storedUser = userRepository.save(user);

        return storedUser;
    }

    public UserLoginResponseDTO getUserByUserName(String username) {
        UserLoginResponseDTO returnValue = new UserLoginResponseDTO();
        User userByEmail = userRepository.findByEmail(username);
        returnValue.setUserName(userByEmail.getUserName());
        returnValue.setEmail(userByEmail.getEmail());
        return returnValue;
    }
}
