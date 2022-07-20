package com.ironhack.homework4.edgeservice.controller.dto;

import com.ironhack.homework4.edgeservice.enums.Industry;
import com.ironhack.homework4.edgeservice.model.*;

import java.util.List;

public class ObjectDTO {

 //object
    private Lead lead;

//account
    private Account account;

    public ObjectDTO() {
    }

    public ObjectDTO(Lead lead, Account account) {
        this.lead = lead;
        this.account = account;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
