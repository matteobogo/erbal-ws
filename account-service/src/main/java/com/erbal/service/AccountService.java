package com.erbal.service;

import com.erbal.domain.Account;
import com.erbal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService extends BaseService<Account, String> {

    @Autowired
    protected AccountService(AccountRepository repository) {
        super(repository);
    }
}