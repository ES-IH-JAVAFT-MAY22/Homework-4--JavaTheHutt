package com.ironhack.homework4.edgeservice.service.interfaces;

import com.ironhack.homework4.edgeservice.model.Account;

import java.util.List;

public interface EdgeAccountService {
    Account creatingAccount(Account account);
    public double AvgEmployeeCount();
    public List<Integer> MedEmployeeCount_firstStep();
    public int MaxEmployeeCount();
    public int MinEmployeeCount();
}
