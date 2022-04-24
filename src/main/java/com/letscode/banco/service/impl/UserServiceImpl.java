package com.letscode.banco.service.impl;

import com.letscode.banco.repository.UserRepository;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
}
