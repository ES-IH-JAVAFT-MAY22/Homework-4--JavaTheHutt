package com.ironhack.homework4.edgeservice.controller.impl;

import com.ironhack.homework4.edgeservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.edgeservice.controller.interfaces.EdgeObjectController;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Lead;
import com.ironhack.homework4.edgeservice.model.SalesRep;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EdgeObjectControllerImpl implements EdgeObjectController {

    @Autowired
    private EdgeObjectService edgeObjectService;

    @PostMapping("/leads")
    @ResponseStatus(HttpStatus.OK)
    public void creatingLead(String name, String phoneNumber, String email, String companyName, long salesRepId) {
        edgeObjectService.creatingLead(name, phoneNumber, email, companyName, salesRepId);
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public void creatingContact(ObjectDTO objectDTO) {
        edgeObjectService.creatingContact(objectDTO);
    }

    @PostMapping("/salesReps")
    @ResponseStatus(HttpStatus.OK)
    public void creatingSalesRep(String name) {
        edgeObjectService.creatingSalesRep(name);
    }

    @GetMapping("/salesReps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep getSalesRep(long id) {
        return edgeObjectService.getSalesRep(id);
    }

    @GetMapping("/findLeadsBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findLeadsBySalesRep() {
        return edgeObjectService.findLeadsBySalesRep();
    }
}

