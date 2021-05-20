package com.gabriel.labengenharia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = new UserDetailsImpl();
        User user = userRepository.findUserByUsername(userName);
        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        return userDetails;
    }
}
