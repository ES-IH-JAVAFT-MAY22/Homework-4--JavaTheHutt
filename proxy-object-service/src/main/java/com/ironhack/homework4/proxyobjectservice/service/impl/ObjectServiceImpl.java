package com.ironhack.homework4.proxyobjectservice.service.impl;

import com.ironhack.homework4.proxyobjectservice.Repository.ContactRepository;
import com.ironhack.homework4.proxyobjectservice.Repository.LeadRepository;
import com.ironhack.homework4.proxyobjectservice.Repository.SalesRepRepository;
import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Contact;
import com.ironhack.homework4.proxyobjectservice.model.Lead;
import com.ironhack.homework4.proxyobjectservice.model.SalesRep;
import com.ironhack.homework4.proxyobjectservice.service.interfaces.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;

    public Lead creatingLead(Lead lead, long salesRepId) {
        lead.setSalesRep(getSalesRep(salesRepId));
        return leadRepository.save(lead);
    }


    public Contact creatingContact(Lead lead, Account account) {
        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(),
                lead.getEmail(), lead.getCompanyName(),account);
        contactRepository.save(contact);
        System.out.println("New CONTACT created with id " + contact.getId());
        return contact;
    }


    public SalesRep creatingSalesRep(String name) {
        SalesRep salesRep = new SalesRep(name);
        for (SalesRep salesRep1 : salesRepRepository.findAll()) {
            if (salesRep1.equals(salesRep)) {
                System.out.println("This SALESREP has been created before");
            }
        }
        System.out.println("New SALESREP created with id " + salesRep.getId());
        return salesRepRepository.save(salesRep);

    }


    public SalesRep getSalesRep(long id) {
        Optional<SalesRep> optionalSalesRep = salesRepRepository.findById(id);
        return optionalSalesRep.get();
    }

}
