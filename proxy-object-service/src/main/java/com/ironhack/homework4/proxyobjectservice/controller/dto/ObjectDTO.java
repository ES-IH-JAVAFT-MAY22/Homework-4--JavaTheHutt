package com.ironhack.homework4.proxyobjectservice.controller.dto;

import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Lead;

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
