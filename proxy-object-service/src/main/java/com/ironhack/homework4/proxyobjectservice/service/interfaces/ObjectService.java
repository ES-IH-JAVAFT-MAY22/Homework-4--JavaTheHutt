package com.ironhack.homework4.proxyobjectservice.service.interfaces;

import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Contact;
import com.ironhack.homework4.proxyobjectservice.model.Lead;
import com.ironhack.homework4.proxyobjectservice.model.SalesRep;

public interface ObjectService {
    Lead creatingLead(Lead lead, long salesRepId);
    Contact creatingContact(Lead lead, Account account);
    SalesRep creatingSalesRep(String name);

    //GET
    SalesRep getSalesRep(long id);
}
