package com.ironhack.homework4.proxyopportunityservice.controller.interfaces;

import com.ironhack.homework4.proxyopportunityservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.proxyopportunityservice.enums.Product;
import com.ironhack.homework4.proxyopportunityservice.model.Account;
import com.ironhack.homework4.proxyopportunityservice.model.Contact;
import com.ironhack.homework4.proxyopportunityservice.model.Lead;
import com.ironhack.homework4.proxyopportunityservice.model.Opportunity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OpportunityController {
    Opportunity creatingOpportunity(OpportunityDTO opportunityDTO);
    Opportunity findById(long id);

    public List<Object[]> findOpportunitiesBySalesRep();


    public List<Object[]> findOpportunitiesClosedWonBySalesRep();


    public List<Object[]> findOpportunitiesClosedLostBySalesRep();


    public List<Object[]> findOpportunitiesOpenBySalesRep();


    public List<Object[]> findOpportunitiesByProduct();


    public List<Object[]> findOpportunitiesClosedWonByProduct();


    public List<Object[]> findOpportunitiesClosedLostByProduct();


    public List<Object[]> findOpportunitiesOpenByProduct();


    public List<Object[]> findOpportunitiesByCountry();


    public List<Object[]> findOpportunitiesClosedWonByCountry();


    public List<Object[]> findOpportunitiesClosedLostByCountry();


    public List<Object[]> findOpportunitiesOpenByCountry();


    public List<Object[]> findOpportunitiesByCity();


    public List<Object[]> findOpportunitiesClosedWonByCity();


    public List<Object[]> findOpportunitiesClosedLostByCity();


    public List<Object[]> findOpportunitiesOpenByCity();

    public List<Object[]> findOpportunitiesByIndustry();


    public List<Object[]> findOpportunitiesClosdeWonByIndustry();

    public List<Object[]> findOpportunitiesClosedLostByIndustry();


    public List<Object[]> findOpportunitiesOpenByIndustry();


    public double AvgQuantity();


    public List<Integer> MedQuantity_firstStep();


    public int MaxQuantity();


    public int MinQuantity();


    public double findMeanOpportunitiesPerAccount();


    public List<Integer> medOpportunitiesPerAccount_firstStep();


    public int findMaxOpportunitiesPerAccount();


    public int findMinOpportunitiesPerAccount();

}
