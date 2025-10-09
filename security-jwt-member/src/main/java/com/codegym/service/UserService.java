package com.codegym.service;

import com.codegym.model.User;
import com.codegym.model.UserPrinciple;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean add(User user) {
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        iUserRepository.save(user);
        return true;
    }

    public UserDetails loadUserByUsername(String username) {
        User user = iUserRepository.findByUsername(username).orElse(null);
        if (user != null) {
            return UserPrinciple.build(user);
        }
        return null;
    }
}