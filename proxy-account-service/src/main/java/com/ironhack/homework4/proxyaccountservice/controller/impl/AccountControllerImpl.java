package com.ironhack.homework4.proxyaccountservice.controller.impl;

import com.ironhack.homework4.proxyaccountservice.Repository.AccountRepository;
import com.ironhack.homework4.proxyaccountservice.controller.interfaces.AccountController;
import com.ironhack.homework4.proxyaccountservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountControllerImpl implements AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account creatingAccount(@RequestBody Account account) {
        accountRepository.save(account);
        return account;
    }
    @GetMapping("/avgEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public double AvgEmployeeCount() {
        return accountRepository.AvgEmployeeCount();
    }

    @GetMapping("/medEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> MedEmployeeCount_firstStep() {
        return accountRepository.MedEmployeeCount_firstStep();
    }

    @GetMapping("/maxEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public int MaxEmployeeCount() {
        return accountRepository.MaxEmployeeCount();
    }

    @GetMapping("/minEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public int MinEmployeeCount() {
        return accountRepository.MinEmployeeCount();
    }

}
