package com.binarymeat.authservice.service.impl;

import com.binarymeat.authservice.domain.User;
import com.binarymeat.authservice.repository.UserRepository;
import com.binarymeat.authservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by rob on 12/5/16.
 */
@Service
public class UserServiceLocal implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {

        User existing = userRepository.findOne(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);

        log.info("new user has been created: {}", user.getUsername());
    }
}
