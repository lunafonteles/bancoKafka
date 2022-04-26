package com.letscode.banco.service.impl;

import com.letscode.banco.client.GetCpfValidator;
import com.letscode.banco.client.ValidatorInfo;
import com.letscode.banco.jms.AccountJms;
import com.letscode.banco.jms.CreateAcountProducer;
import com.letscode.banco.model.Account;
import com.letscode.banco.model.User;
import com.letscode.banco.repository.AccountRepository;
import com.letscode.banco.request.AccountRequest;
import com.letscode.banco.service.AccountService;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserService userService;
    @Autowired
    GetCpfValidator getCpfValidator;
    @Autowired
    CreateAcountProducer createAccountProducer;

    @Override
    public Account create(AccountRequest accountRequest) {
        Account account = new Account();
        account.setAccountType(accountRequest.getAccountType());
        account.setAgency(accountRequest.getAgency());
        User user = userService.findById(accountRequest.getUserId()).get();
        account.setUser(user);

        ValidatorInfo validator = getCpfValidator.execute();

        if(validator.isWinner()) {
            AccountJms accountJms = new AccountJms();
            accountJms.setCpf(user.getCpf());
            accountJms.setName(user.getName());
            createAccountProducer.send(accountJms);
        }
        accountRepository.save(account);
        return account;
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.empty();
    }
}
