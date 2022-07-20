package com.ironhack.homework4.edgeservice.controller.interfaces;

import com.ironhack.homework4.edgeservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Lead;
import com.ironhack.homework4.edgeservice.model.SalesRep;

import java.util.List;

public interface EdgeObjectController {

    void creatingLead(String name, String phoneNumber, String email, String companyName, long salesRepId);
    void creatingContact(ObjectDTO objectDTO);
    void creatingSalesRep(String name);

    SalesRep getSalesRep(long id);
   List<Object[]> findLeadsBySalesRep();
}
