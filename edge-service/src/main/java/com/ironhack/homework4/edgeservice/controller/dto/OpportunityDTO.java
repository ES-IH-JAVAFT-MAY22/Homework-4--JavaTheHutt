package com.ironhack.homework4.edgeservice.controller.dto;

import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.enums.Status;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Contact;
import com.ironhack.homework4.edgeservice.model.SalesRep;

public class OpportunityDTO {

    private Contact contact;
    private Account account;
    private SalesRep salesRep;

    public OpportunityDTO() {
    }

    public OpportunityDTO(Contact contact, Account account, SalesRep salesRep) {
        this.contact = contact;
        this.account = account;
        this.salesRep = salesRep;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
