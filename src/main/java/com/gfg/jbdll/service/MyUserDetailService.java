package com.gfg.jbdll.service;

import com.gfg.jbdll.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailService implements UserDetailsService {

    Map<String, MyUser> userMap =  new HashMap<>();

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userMap.containsKey(username))
            return userMap.get(username);
        else
            throw new UsernameNotFoundException("No User with username exists");
    }

    public void addUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMap.put(user.getUsername(), user);
    }
}
