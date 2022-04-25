package com.letscode.banco.response;

import com.letscode.banco.model.Account;
import com.letscode.banco.model.AccountType;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountResponse {
    private Integer id;
    private Integer number;
    private Integer agency;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private BigDecimal balance;
    private AccountType accountType;


    public AccountResponse(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.agency = account.getAgency();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        this.createDate = account.getCreateDate();
        this.updateDate = account.getUpdateDate();
    }
}
