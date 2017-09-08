package com.binarymeat.authservice.security;

import com.binarymeat.authservice.domain.User;
import com.binarymeat.authservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by rob on 12/5/16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("param username="+username);
        User user = repository.findOne(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        log.info("username="+user.getUsername());
        log.info("pass="+user.getPassword());

        return user;
    }
}
