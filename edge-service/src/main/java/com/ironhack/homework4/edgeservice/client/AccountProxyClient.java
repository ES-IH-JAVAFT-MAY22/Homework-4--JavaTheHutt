package com.ironhack.homework4.edgeservice.client;

import com.ironhack.homework4.edgeservice.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("proxy-account-service")
public interface AccountProxyClient {

    @PostMapping("/accounts")
    Account creatingAccount(@RequestBody Account account);

    @GetMapping("/avgEmployeeCount")
    double AvgEmployeeCount();

    @GetMapping("/medEmployeeCount")
    List<Integer> MedEmployeeCount_firstStep();

    @GetMapping("/maxEmployeeCount")
    int MaxEmployeeCount();
    @GetMapping("/minEmployeeCount")
    int MinEmployeeCount();
}
