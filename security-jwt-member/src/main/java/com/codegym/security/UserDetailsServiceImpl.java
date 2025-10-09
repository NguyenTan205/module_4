package com.codegym.security;

import com.codegym.model.Role;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm user trong DB theo username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        // Chuyển roles -> GrantedAuthority cho Spring Security
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(Role::getName) // lấy tên role trong DB (VD: ROLE_MEMBER, ROLE_ADMIN)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        System.out.println(user.getPassword());
        // Trả về user cho Spring Security quản lý
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
