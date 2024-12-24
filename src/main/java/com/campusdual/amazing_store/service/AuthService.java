package com.campusdual.amazing_store.service;

import com.campusdual.amazing_store.auth.JwtUtils;
import com.campusdual.amazing_store.model.User;
import com.campusdual.amazing_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    public String authenticate(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user != null && passwordEncoder.matches(password, user.getPassword())){
            return jwtUtils.generateToken(username);
        }else {
            throw new BadCredentialsException("Credenciales inválidas");
        }
    }

}
