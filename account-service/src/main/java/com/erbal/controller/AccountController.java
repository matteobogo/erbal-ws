package com.erbal.controller;

import com.erbal.domain.Account;
import com.erbal.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/customer/account")
public class AccountController extends BaseController<Account, String> {

    @Autowired
    public AccountController(AccountService baseService) {
        super(baseService);
    }
}