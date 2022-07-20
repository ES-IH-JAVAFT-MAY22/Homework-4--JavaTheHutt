package com.ironhack.homework4.edgeservice.service.impl;

import com.ironhack.homework4.edgeservice.client.OpportunityProxyClient;
import com.ironhack.homework4.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.edgeservice.enums.Industry;
import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.enums.Status;
import com.ironhack.homework4.edgeservice.model.*;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeOpportunityService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeOpportunityServiceImpl implements EdgeOpportunityService {

    private final Logger logger = LoggerFactory.getLogger(EdgeOpportunityServiceImpl.class);

    @Autowired
    private OpportunityProxyClient opportunityProxyClient;

    public Opportunity creatingOpportunity(Product product, int quantity, OpportunityDTO opportunityDTO) {
        return opportunityProxyClient.creatingOpportunity(product, quantity, opportunityDTO);
    }


    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Opportunity findById(long id) {
        Opportunity opportunity = new Opportunity();
        Contact contact1 = new Contact();
        SalesRep salesRep1 = new SalesRep();
        Account account1 = new Account();
        opportunity.setId(1L);
        opportunity.setProduct(Product.FLATBED);
        opportunity.setQuantity(15);
        opportunity.setDecisionMaker(contact1);
        opportunity.setStatus(Status.OPEN);
        opportunity.setSalesRep(salesRep1);
        opportunity.setAccountO(account1);
        return opportunity;
    }

    public Opportunity creatingOpportunityFallback(Product product, int quantity, OpportunityDTO opportunityDTO,
                                           Exception e){
        logger.error("The server is not available");
        return null;
    }

    @CircuitBreaker(name = "findById", fallbackMethod = "findByIdFallback")
    public Opportunity findByIdFallback(long id) {
        return opportunityProxyClient.findById(id);
    }

    public Opportunity findByIdFallback(long id, Exception e) {
        logger.error(e.getMessage());
        Product product1 = Product.BOX;
        int quantity1 = 10;
        Account account1 = new Account(Industry.ECOMMERCE, 50, "Madrid", "España");
        Contact contact1 = new Contact("Pepe","65840325","pepe@gmail.com","Aldi",
                account1 );
        SalesRep salesRep = new SalesRep("Javier");

        Opportunity opportunity = new Opportunity(product1, quantity1,contact1, salesRep, Status.OPEN, account1);
        return opportunity;
    }


    public List<Object[]> findOpportunitiesBySalesRep() {
        return opportunityProxyClient.findOpportunitiesBySalesRep();
    }


    public List<Object[]> findOpportunitiesClosedWonBySalesRep() {
        return opportunityProxyClient.findOpportunitiesClosedWonBySalesRep();
    }


    public List<Object[]> findOpportunitiesClosedLostBySalesRep() {
        return opportunityProxyClient.findOpportunitiesClosedLostBySalesRep();
    }


    public List<Object[]> findOpportunitiesOpenBySalesRep() {
        return opportunityProxyClient.findOpportunitiesOpenBySalesRep();
    }


    public List<Object[]> findOpportunitiesByProduct() {
        return opportunityProxyClient.findOpportunitiesByProduct();
    }


    public List<Object[]> findOpportunitiesClosedWonByProduct() {
        return opportunityProxyClient.findOpportunitiesClosedWonByProduct();
    }


    public List<Object[]> findOpportunitiesClosedLostByProduct() {
        return opportunityProxyClient.findOpportunitiesClosedLostByProduct();
    }


    public List<Object[]> findOpportunitiesOpenByProduct() {
        return opportunityProxyClient.findOpportunitiesOpenByProduct();
    }


    public List<Object[]> findOpportunitiesByCountry() {
        return opportunityProxyClient.findOpportunitiesByCountry();
    }


    public List<Object[]> findOpportunitiesClosedWonByCountry() {
        return opportunityProxyClient.findOpportunitiesClosedWonByCountry();
    }


    public List<Object[]> findOpportunitiesClosedLostByCountry() {
        return opportunityProxyClient.findOpportunitiesClosedLostByCountry();
    }


    public List<Object[]> findOpportunitiesOpenByCountry() {
        return opportunityProxyClient.findOpportunitiesOpenByCountry();
    }


    public List<Object[]> findOpportunitiesByCity() {
        return opportunityProxyClient.findOpportunitiesByCity();
    }


    public List<Object[]> findOpportunitiesClosedWonByCity() {
        return opportunityProxyClient.findOpportunitiesByCity();
    }


    public List<Object[]> findOpportunitiesClosedLostByCity() {
        return opportunityProxyClient.findOpportunitiesByCity();
    }


    public List<Object[]> findOpportunitiesOpenByCity() {
        return opportunityProxyClient.findOpportunitiesByCity();
    }


    public List<Object[]> findOpportunitiesByIndustry() {
        return opportunityProxyClient.findOpportunitiesByIndustry();
    }


    public List<Object[]> findOpportunitiesClosdeWonByIndustry() {
        return opportunityProxyClient.findOpportunitiesByIndustry();
    }


    public List<Object[]> findOpportunitiesClosedLostByIndustry() {
        return opportunityProxyClient.findOpportunitiesByIndustry();
    }


    public List<Object[]> findOpportunitiesOpenByIndustry() {
        return opportunityProxyClient.findOpportunitiesByIndustry();
    }


    public double AvgQuantity() {
        return opportunityProxyClient.AvgQuantity();
    }


    public List<Integer> MedQuantity_firstStep() {
        return opportunityProxyClient.MedQuantity_firstStep();
    }


    public int MaxQuantity() {
        return opportunityProxyClient.MaxQuantity();
    }


    public int MinQuantity() {
        return opportunityProxyClient.MinQuantity();
    }


    public double findMeanOpportunitiesPerAccount() {
        return opportunityProxyClient.findMeanOpportunitiesPerAccount();
    }


    public List<Integer> medOpportunitiesPerAccount_firstStep() {
        return opportunityProxyClient.medOpportunitiesPerAccount_firstStep();
    }


    public int findMaxOpportunitiesPerAccount() {
        return opportunityProxyClient.findMaxOpportunitiesPerAccount();
    }


    public int findMinOpportunitiesPerAccount() {
        return opportunityProxyClient.findMinOpportunitiesPerAccount();
    }

}
