package com.ironhack.homework4.edgeservice.controller.impl;

import com.ironhack.homework4.edgeservice.controller.interfaces.EdgeAccountController;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeAccountService;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeAccountControllerImpl implements EdgeAccountController {
    @Autowired
    private EdgeAccountService edgeAccountService;
    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public Account creatingAccount(@RequestBody Account account) {
        edgeAccountService.creatingAccount(account);

        return account;

    }
    @GetMapping("/avgEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public double AvgEmployeeCount() {
        return edgeAccountService.AvgEmployeeCount();
    }

    @GetMapping("/medEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> MedEmployeeCount_firstStep() {
        return edgeAccountService.MedEmployeeCount_firstStep();
    }

    @GetMapping("/maxEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public int MaxEmployeeCount() {
        return edgeAccountService.MaxEmployeeCount();
    }

    @GetMapping("/minEmployeeCount")
    @ResponseStatus(HttpStatus.OK)
    public int MinEmployeeCount() {
        return edgeAccountService.MinEmployeeCount();
    }
}
