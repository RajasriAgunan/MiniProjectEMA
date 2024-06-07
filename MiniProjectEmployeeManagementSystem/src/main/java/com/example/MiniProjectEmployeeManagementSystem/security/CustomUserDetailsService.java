package com.example.MiniProjectEmployeeManagementSystem.security;

import com.example.MiniProjectEmployeeManagementSystem.entity.User;
import com.example.MiniProjectEmployeeManagementSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

           private UserRepository userRepository;
   public UserDetails loadUserByUsername (String usernameorEmail)
           throws UsernameNotFoundException{
       User user=userRepository.findByUsernameOrEmail(usernameorEmail,usernameorEmail).get();

       Set<GrantedAuthority> authorities=user.getRoles().stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toSet());
      
       return new org.springframework.security.core.userdetails.User
               (usernameorEmail,
                       user.getPassword(),
                       authorities
                      );
   }
}
