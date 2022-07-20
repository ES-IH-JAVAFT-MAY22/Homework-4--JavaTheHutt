package com.ironhack.homework4.edgeservice.controller.interfaces;

import com.ironhack.homework4.edgeservice.model.Account;

import java.util.List;

public interface EdgeAccountController {
    Account creatingAccount(Account account);
    public double AvgEmployeeCount();
    public List<Integer> MedEmployeeCount_firstStep();
    public int MaxEmployeeCount();
    public int MinEmployeeCount();
}
