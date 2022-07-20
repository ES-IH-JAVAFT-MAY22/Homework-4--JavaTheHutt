package com.ironhack.homework4.proxyobjectservice.controller.impl;

import com.ironhack.homework4.proxyobjectservice.Repository.LeadRepository;
import com.ironhack.homework4.proxyobjectservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.proxyobjectservice.controller.interfaces.ObjectController;
import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Contact;
import com.ironhack.homework4.proxyobjectservice.model.Lead;
import com.ironhack.homework4.proxyobjectservice.model.SalesRep;
import com.ironhack.homework4.proxyobjectservice.service.impl.ObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectControllerImpl implements ObjectController {

    @Autowired
    private ObjectServiceImpl objectService;
    @Autowired
    private LeadRepository leadRepository;

    @PostMapping("/leads/{salesRepId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Lead creatingLead(@RequestBody Lead lead, @PathVariable long salesRepId) {
       return objectService.creatingLead(lead,salesRepId);
    }

    @PostMapping("/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact creatingContact(@RequestBody ObjectDTO objectDTO) {
        return objectService.creatingContact(objectDTO.getLead(),objectDTO.getAccount());
    }

    @PostMapping("/salesReps")
    @ResponseStatus(HttpStatus.CREATED)
    public SalesRep creatingSalesRep(@RequestParam String name) {
        return objectService.creatingSalesRep(name);
    }

    @GetMapping("/salesReps/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SalesRep getSalesRep(@PathVariable long id) {
        return objectService.getSalesRep(id);
    }

    @GetMapping("/findLeadsBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findLeadsBySalesRep() {
        return leadRepository.findLeadsBySalesRep();
    }
}
