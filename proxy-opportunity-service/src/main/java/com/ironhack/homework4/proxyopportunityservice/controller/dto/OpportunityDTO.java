package com.ironhack.homework4.proxyopportunityservice.controller.dto;
import com.ironhack.homework4.proxyopportunityservice.enums.Product;
import com.ironhack.homework4.proxyopportunityservice.model.Account;
import com.ironhack.homework4.proxyopportunityservice.model.Contact;
import com.ironhack.homework4.proxyopportunityservice.model.SalesRep;

public class OpportunityDTO {

    private Contact contact;
    private Account account;
    private SalesRep salesRep;

    private Product product;

    private int quantity;

    public OpportunityDTO() {
    }

    public OpportunityDTO(Contact contact, Account account, SalesRep salesRep, Product product, int quantity) {
        this.contact = contact;
        this.account = account;
        this.salesRep = salesRep;
        this.product = product;
        this.quantity = quantity;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
