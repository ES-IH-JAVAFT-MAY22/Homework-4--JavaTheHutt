package com.ironhack.homework4.proxyaccountservice.controller.interfaces;

import com.ironhack.homework4.proxyaccountservice.model.Account;

import java.util.List;

public interface AccountController {
    Account creatingAccount(Account account);
    public double AvgEmployeeCount();
    public List<Integer> MedEmployeeCount_firstStep();
    public int MaxEmployeeCount();
    public int MinEmployeeCount();

}
