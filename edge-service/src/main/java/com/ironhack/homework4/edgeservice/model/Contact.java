package com.ironhack.homework4.edgeservice.model;



public class Contact{

//    private static int contactIdCounter = 100000;
    private long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    //relation Many TO One

//    @JsonIgnore

    private Account accountC;

    private Opportunity opportunity;
    //constructors: void and with all the variables
    public Contact() {
    }

    public Contact(String name, String phoneNumber, String email, String companyName, Account accountC) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.accountC = accountC;
    }

    //getters and setters needed
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Account getAccountC() {
        return accountC;
    }

    public void setAccountC(Account accountC) {
        this.accountC = accountC;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    //Strings to Print
    public String showContact() {
        return ("id: " + id + " -> name: " + getName());
    }

    @Override
    public String toString() {
        return "=== Contact " + id + " ===\n"+
                "- name: " + getName() + "\n"+
                "- phone number: " + getPhoneNumber() + "\n"+
                "- email: " + getEmail() + "\n"+
                "- company name: " + getCompanyName() + "\n";
    }

    public String printDecisionMaker() {
        return  " CONTACT " + id + "\n"+
                "   - name: " + getName() + "\n"+
                "   - phone number: " + getPhoneNumber() + "\n"+
                "   - email: " + getEmail() + "\n"+
                "   - company name: " + getCompanyName() + "\n";
    }

}