package com.ironhack.homework4.edgeservice.client;

import com.ironhack.homework4.edgeservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Lead;
import com.ironhack.homework4.edgeservice.model.SalesRep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("proxy-object-service")
public interface ObjectProxyClient {

    @PostMapping("/leads/{id}")
    public void creatingLead(@RequestParam String name, @RequestParam String phoneNumber, @RequestParam String email,
                             @RequestParam String companyName, @PathVariable long salesRepId);

    @PostMapping("/contacts")
    public void creatingContact(@RequestBody ObjectDTO objectDTO);

    @PostMapping("/salesReps")
    public void creatingSalesRep(@RequestParam String name);

    @GetMapping("/salesReps/{id}")
    public SalesRep getSalesRep(@PathVariable long id);
    @GetMapping("/findLeadsBySalesRep")
    public List<Object[]> findLeadsBySalesRep();
}
