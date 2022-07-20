package com.ironhack.homework4.edgeservice.model;


import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.enums.Status;


import java.util.Objects;


public class Opportunity {

    private long id;

    private Product product;
    private int quantity;

    private Contact decisionMaker;

    private Status status;
    //relation Many TO One

    private Account accountO;


    private SalesRep salesRep;

    //constructors

    public Opportunity() {
    }

    public Opportunity(Product product, int quantity, Contact decisionMaker, SalesRep salesRep, Status open, Account accountO) {
        this.product = product;
        this.quantity = quantity;
        this.decisionMaker = decisionMaker;
        this.status = Status.OPEN;
        this.salesRep = salesRep;
        this.accountO = accountO;
    }

    //getters and setters needed
    public long getId() {
        return id;
    }

    public void setId(long idOpportunity) {
        this.id = idOpportunity;
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

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Account getAccountO() {
        return accountO;
    }

    public void setAccountO(Account accountO) {
        this.accountO = accountO;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }

    //Strings to Print
    public String showOpportunity() {
        return ("id: " + id + " -> decision maker: " + decisionMaker.getName());
    }

    @Override
    public String toString() {
        return "=== Opportunity " + id + " ===\n"+
                "- product: " + product + "\n"+
                "- trucks quantity: " + quantity + "\n"+
                "- decision maker: " + decisionMaker.printDecisionMaker() +
                "- status: " + status + "\n"+
                "- salesRep id: " + salesRep.getId() +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return quantity == that.quantity && product == that.product && decisionMaker.equals(that.decisionMaker) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, decisionMaker, status);
    }
}
