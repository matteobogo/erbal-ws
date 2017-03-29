package com.erbal.service;

import com.erbal.domain.Account;
import com.erbal.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account, String> {

    @Autowired
    public AccountService(AccountRepository repository) {
        super(repository);
    }
}