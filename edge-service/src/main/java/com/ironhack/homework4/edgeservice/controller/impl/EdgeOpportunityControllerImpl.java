package com.ironhack.homework4.edgeservice.controller.impl;

import com.ironhack.homework4.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.edgeservice.controller.interfaces.EdgeOpportunityController;
import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.model.*;
import com.ironhack.homework4.edgeservice.service.interfaces.EdgeOpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EdgeOpportunityControllerImpl implements EdgeOpportunityController {
    @Autowired
    private EdgeOpportunityService edgeOpportunityService;


    @GetMapping("/opportunities/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Opportunity findById(@PathVariable long id) {
        return edgeOpportunityService.findById(id);
    }

    @PostMapping("/opportunities")
    @ResponseStatus(HttpStatus.CREATED)
    public Opportunity creatingOpportunity(@RequestParam Product product, @RequestParam int quantity,
                                           @RequestBody OpportunityDTO opportunityDTO) {
    return edgeOpportunityService.creatingOpportunity(product, quantity, opportunityDTO);
    }


    @GetMapping("/findOpportunitiesBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesBySalesRep() {
        return edgeOpportunityService.findOpportunitiesBySalesRep();
    }

    @GetMapping("/findOpportunitiesClosedWonBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonBySalesRep() {
        return edgeOpportunityService.findOpportunitiesClosedWonBySalesRep();
    }

    @GetMapping("/findOpportunitiesClosedLostBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostBySalesRep() {
        return edgeOpportunityService.findOpportunitiesClosedLostBySalesRep();
    }

    @GetMapping("/findOpportunitiesOpenBySalesRep")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenBySalesRep() {
        return edgeOpportunityService.findOpportunitiesOpenBySalesRep();
    }

    @GetMapping("/findOpportunitiesByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByProduct() {
        return edgeOpportunityService.findOpportunitiesByProduct();
    }

    @GetMapping("/findOpportunitiesClosedWonByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByProduct() {
        return edgeOpportunityService.findOpportunitiesClosedWonByProduct();
    }

    @GetMapping("/findOpportunitiesClosedLostByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByProduct() {
        return edgeOpportunityService.findOpportunitiesClosedLostByProduct();
    }

    @GetMapping("/findOpportunitiesOpenByProduct")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByProduct() {
        return edgeOpportunityService.findOpportunitiesOpenByProduct();
    }

    @GetMapping("/findOpportunitiesByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByCountry() {
        return edgeOpportunityService.findOpportunitiesByCountry();
    }

    @GetMapping("/findOpportunitiesClosedWonByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByCountry() {
        return edgeOpportunityService.findOpportunitiesClosedWonByCountry();
    }

    @GetMapping("/findOpportunitiesClosedLostByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByCountry() {
        return edgeOpportunityService.findOpportunitiesClosedLostByCountry();
    }

    @GetMapping("/findOpportunitiesOpenByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByCountry() {
        return edgeOpportunityService.findOpportunitiesOpenByCountry();
    }

    @GetMapping("/findOpportunitiesByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByCity() {
        return edgeOpportunityService.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesClosedWonByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedWonByCity() {
        return edgeOpportunityService.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesClosedLostByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByCity() {
        return edgeOpportunityService.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesOpenByCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByCity() {
        return edgeOpportunityService.findOpportunitiesByCity();
    }

    @GetMapping("/findOpportunitiesByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesByIndustry() {
        return edgeOpportunityService.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesClosdeWonByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosdeWonByIndustry() {
        return edgeOpportunityService.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesClosedLostByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesClosedLostByIndustry() {
        return edgeOpportunityService.findOpportunitiesByIndustry();
    }

    @GetMapping("/findOpportunitiesOpenByIndustry")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findOpportunitiesOpenByIndustry() {
        return edgeOpportunityService.findOpportunitiesByIndustry();
    }

    @GetMapping("/avgQuantity")
    @ResponseStatus(HttpStatus.OK)
    public double AvgQuantity() {
        return edgeOpportunityService.AvgQuantity();
    }

    @GetMapping("/medQuantity_firstStep")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> MedQuantity_firstStep() {
        return edgeOpportunityService.MedQuantity_firstStep();
    }

    @GetMapping("/maxQuantity")
    @ResponseStatus(HttpStatus.OK)
    public int MaxQuantity() {
        return edgeOpportunityService.MaxQuantity();
    }

    @GetMapping("/minQuantity")
    @ResponseStatus(HttpStatus.OK)
    public int MinQuantity() {
        return edgeOpportunityService.MinQuantity();
    }

    @GetMapping("/findMeanOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public double findMeanOpportunitiesPerAccount() {
        return edgeOpportunityService.findMeanOpportunitiesPerAccount();
    }

    @GetMapping("/medOpportunitiesPerAccount_firstStep")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> medOpportunitiesPerAccount_firstStep() {
        return edgeOpportunityService.medOpportunitiesPerAccount_firstStep();
    }

    @GetMapping("/findMaxOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public int findMaxOpportunitiesPerAccount() {
        return edgeOpportunityService.findMaxOpportunitiesPerAccount();
    }

    @GetMapping("/findMinOpportunitiesPerAccount")
    @ResponseStatus(HttpStatus.OK)
    public int findMinOpportunitiesPerAccount() {
        return edgeOpportunityService.findMinOpportunitiesPerAccount();
    }

}