package com.ironhack.homework4.proxyopportunityservice.controller.impl;

import com.ironhack.homework4.proxyopportunityservice.Repository.OpportunityRepository;
import com.ironhack.homework4.proxyopportunityservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.proxyopportunityservice.controller.interfaces.OpportunityController;
import com.ironhack.homework4.proxyopportunityservice.enums.Product;
import com.ironhack.homework4.proxyopportunityservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OpportunityControllerImpl implements OpportunityController {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity creatingOpportunity(@RequestBody OpportunityDTO opportunityDTO) {
        Contact contact = opportunityDTO.getContact();
        SalesRep salesRep = opportunityDTO.getSalesRep();
        Account account = opportunityDTO.getAccount();
        Product product = opportunityDTO.getProduct();
        int quantity = opportunityDTO.getQuantity();
        Opportunity opportunity = new Opportunity(product, quantity, contact,
                salesRep, account);
        opportunityRepository.save(opportunity);
        return opportunity;
    }

    @GetMapping("/opportunities/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Opportunity findById(@PathVariable long id){
        Optional<Opportunity> opportunity = opportunityRepository.findById(id);
        return opportunity.get();
    }

    @GetMapping("/findOpportunitiesBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesBySalesRep() {
        return opportunityRepository.findOpportunitiesBySalesRep();
    }

    @GetMapping("/findOpportunitiesClosedWonBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonBySalesRep() {
        return opportunityRepository.findOpportunitiesClosedWonBySalesRep();
    }

    @GetMapping("/findOpportunitiesClosedLostBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostBySalesRep() {
        return opportunityRepository.findOpportunitiesClosedLostBySalesRep();
    }

    @GetMapping("/findOpportunitiesOpenBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenBySalesRep() {
        return opportunityRepository.findOpportunitiesOpenBySalesRep();
    }

    @GetMapping("/findOpportunitiesByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByProduct() {
        return opportunityRepository.findOpportunitiesByProduct();
    }

    @GetMapping("/findOpportunitiesClosedWonByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByProduct() {
        return opportunityRepository.findOpportunitiesClosedWonByProduct();
    }

    @GetMapping("/findOpportunitiesClosedLostByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByProduct() {
        return opportunityRepository.findOpportunitiesClosedLostByProduct();
    }

    @GetMapping("/findOpportunitiesOpenByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByProduct() {
        return opportunityRepository.findOpportunitiesOpenByProduct();
    }

    @GetMapping("/findOpportunitiesByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByCountry() {
        return opportunityRepository.findOpportunitiesByCountry();
    }

    @GetMapping("/findOpportunitiesClosedWonByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByCountry() {
        return opportunityRepository.findOpportunitiesClosedWonByCountry();
    }

    @GetMapping("/findOpportunitiesClosedLostByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByCountry() {
        return opportunityRepository.findOpportunitiesClosedLostByCountry();
    }

    @GetMapping("/findOpportunitiesOpenByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByCountry() {
        return opportunityRepository.findOpportunitiesOpenByCountry();
    }

    @GetMapping("/findOpportunitiesByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByCity() {
        return opportunityRepository.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesClosedWonByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByCity() {
        return opportunityRepository.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesClosedLostByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByCity() {
        return opportunityRepository.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesOpenByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByCity() {
        return opportunityRepository.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByIndustry() {
        return opportunityRepository.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesClosdeWonByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosdeWonByIndustry() {
        return opportunityRepository.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesClosedLostByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByIndustry() {
        return opportunityRepository.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesOpenByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByIndustry() {
        return opportunityRepository.findOpportunitiesByIndustry();
    }

    @GetMapping("/avgQuantity")
    @ResponseStatus(HttpStatus.OK)
    public double AvgQuantity() {
        return opportunityRepository.AvgQuantity();
    }

    @GetMapping("/medQuantity_firstStep")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> MedQuantity_firstStep() {
        return opportunityRepository.MedQuantity_firstStep();
    }

    @GetMapping("/maxQuantity")
    @ResponseStatus(HttpStatus.OK)
    public int MaxQuantity() {
        return opportunityRepository.MaxQuantity();
    }

    @GetMapping("/minQuantity")
    @ResponseStatus(HttpStatus.OK)
    public int MinQuantity() {
        return opportunityRepository.MinQuantity();
    }

    @GetMapping("/findMeanOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public double findMeanOpportunitiesPerAccount() {
        return opportunityRepository.findMeanOpportunitiesPerAccount();
    }

    @GetMapping("/medOpportunitiesPerAccount_firstStep")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> medOpportunitiesPerAccount_firstStep() {
        return opportunityRepository.medOpportunitiesPerAccount_firstStep();
    }

    @GetMapping("/findMaxOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public int findMaxOpportunitiesPerAccount() {
        return opportunityRepository.findMaxOpportunitiesPerAccount();
    }

    @GetMapping("/findMinOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public int findMinOpportunitiesPerAccount() {
        return opportunityRepository.findMinOpportunitiesPerAccount();
    }

}
