package com.letscode.banco.service.impl;

import com.letscode.banco.repository.AccountRepository;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserService userService;
}
