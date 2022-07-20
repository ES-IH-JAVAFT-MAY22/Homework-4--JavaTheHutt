package com.ironhack.homework4.edgeservice.service.impl;

import com.ironhack.homework4.edgeservice.client.AccountProxyClient;
import com.ironhack.homework4.edgeservice.client.OpportunityProxyClient;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeAccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeAccountServiceImpl implements EdgeAccountService {

    private final Logger logger = LoggerFactory.getLogger(EdgeAccountServiceImpl.class);

    @Autowired
    private AccountProxyClient accountProxyClient;

    public Account creatingAccount(Account account) {
        return accountProxyClient.creatingAccount(account);
    }

    @Override
    public double AvgEmployeeCount() {
        return accountProxyClient.AvgEmployeeCount();
    }

    @Override
    public List<Integer> MedEmployeeCount_firstStep() {
        return accountProxyClient.MedEmployeeCount_firstStep();
    }

    @Override
    public int MaxEmployeeCount() {
        return accountProxyClient.MaxEmployeeCount();
    }

    @Override
    public int MinEmployeeCount() {
        return accountProxyClient.MinEmployeeCount();
    }

    /* @CircuitBreaker(name = "creatingAccount", fallbackMethod = "creatingAccountFallback")
      public Account creatingAccount(Account account) {
      return accountProxyClient.creatingAccount(account);
    } */

    @CircuitBreaker(name = "creatingAccount", fallbackMethod = "creatingAccountFallback")

    public Account creatingAccountFallback(Account account, Exception e) {
        logger.error("The server is not available");
        return null;
    }
}
