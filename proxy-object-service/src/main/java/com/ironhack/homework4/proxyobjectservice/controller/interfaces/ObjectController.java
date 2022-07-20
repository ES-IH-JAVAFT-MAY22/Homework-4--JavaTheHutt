package com.ironhack.homework4.proxyobjectservice.controller.interfaces;

import com.ironhack.homework4.proxyobjectservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Contact;
import com.ironhack.homework4.proxyobjectservice.model.Lead;
import com.ironhack.homework4.proxyobjectservice.model.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ObjectController {
    //POST
    Lead creatingLead(Lead lead, long salesRepId);
    Contact creatingContact(ObjectDTO objectDTO);
    SalesRep creatingSalesRep(String name);

    //GET
    SalesRep getSalesRep(long id);
    List<Object[]> findLeadsBySalesRep();


}
