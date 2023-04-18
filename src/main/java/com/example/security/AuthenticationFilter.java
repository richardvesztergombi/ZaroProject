package com.example.security;

import com.example.SpringApplicationContext;
import com.example.dto.UserLoginRequestDTO;
import com.example.dto.UserLoginResponseDTO;
import com.example.dto.UserRegistrationResponseDTO;
import com.example.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            UserLoginRequestDTO loginDTO = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginRequestDTO.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        User user = ((User) authResult.getPrincipal());

        UserService userService = (UserService) SpringApplicationContext.getBean("userService");

        UserLoginResponseDTO storedUser = userService.getUserByUserName(user.getUsername());

        response.setContentType(APPLICATION_JSON_VALUE);

        Map<String, String> employeeDetails = new HashMap<>();
        employeeDetails.put("username", storedUser.getUserName());
        employeeDetails.put("email", storedUser.getEmail());
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), employeeDetails);

        LOGGER.warn(">>> Login was successfully with this USER: [ userName: {}, email: {}]", storedUser.getUserName(),storedUser.getEmail());

    }
}
