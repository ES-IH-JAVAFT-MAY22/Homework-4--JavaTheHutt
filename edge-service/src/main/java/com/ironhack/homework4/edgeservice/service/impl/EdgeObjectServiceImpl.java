package com.ironhack.homework4.edgeservice.service.impl;

import com.ironhack.homework4.edgeservice.client.ObjectProxyClient;
import com.ironhack.homework4.edgeservice.client.OpportunityProxyClient;
import com.ironhack.homework4.edgeservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Lead;
import com.ironhack.homework4.edgeservice.model.SalesRep;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeObjectService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeObjectServiceImpl implements EdgeObjectService {

    private final Logger logger = LoggerFactory.getLogger(EdgeObjectServiceImpl.class);

    @Autowired
    private ObjectProxyClient objectProxyClient;

    @CircuitBreaker(name = "creatingLead", fallbackMethod = "creatingLeadFallback")
    public void creatingLead(String name, String phoneNumber, String email, String companyName, long salesRepId) {
        objectProxyClient.creatingLead(name, phoneNumber, email, companyName, salesRepId);
    }

    public void creatingLeadFallback(String name, String phoneNumber, String email, String companyName, long salesRepId,
                                     Exception e) {
        logger.error("The server is not available");
    }

    @CircuitBreaker(name = "creatingContact", fallbackMethod = "creatingContactFallback")
    public void creatingContact(ObjectDTO objectDTO) {
        objectProxyClient.creatingContact(objectDTO);
    }

    public void creatingContactFallback(ObjectDTO objectDTO, Exception e) {
        logger.error("The server is not available");
    }

    @CircuitBreaker(name = "creatingSalesRep", fallbackMethod = "creatingSalesRepFallback")
    public void creatingSalesRep(String name) {
        objectProxyClient.creatingSalesRep(name);
    }

    public void creatingSalesRepFallback(String name, Exception e) {
        logger.error("The server is not available");
    }

    @CircuitBreaker(name = "getSalesRep", fallbackMethod = "getSalesRepFallback")
    public SalesRep getSalesRep(long id) {
        return objectProxyClient.getSalesRep(id);
    }

    public SalesRep getSalesRepFallback(long id, Exception e) {
        logger.error(e.getMessage());
        SalesRep salesRep = new SalesRep("Julia");
        return salesRep;
    }

    public List<Object[]> findLeadsBySalesRep(){
       return objectProxyClient.findLeadsBySalesRep();
    }
}
