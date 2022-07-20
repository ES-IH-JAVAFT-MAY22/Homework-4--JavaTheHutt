package com.ironhack.homework4.edgeservice.client;

import com.ironhack.homework4.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("proxy-opportunity-service")
public interface OpportunityProxyClient {

    @PostMapping("/opportunities")
    public Opportunity creatingOpportunity(@RequestParam Product product, @RequestParam int quantity,
                                           @RequestBody OpportunityDTO opportunityDTO);


    @GetMapping("/opportunities/{id}")
    public Opportunity findById(@PathVariable long id);

    @GetMapping("/findOpportunitiesBySalesRep")
    public List<Object[]> findOpportunitiesBySalesRep();

    @GetMapping("/findOpportunitiesClosedWonBySalesRep")
    public List<Object[]> findOpportunitiesClosedWonBySalesRep();

    @GetMapping("/findOpportunitiesClosedLostBySalesRep")
    public List<Object[]> findOpportunitiesClosedLostBySalesRep();

    @GetMapping("/findOpportunitiesOpenBySalesRep")
    public List<Object[]> findOpportunitiesOpenBySalesRep();

    @GetMapping("/findOpportunitiesByProduct")
    public List<Object[]> findOpportunitiesByProduct();

    @GetMapping("/findOpportunitiesClosedWonByProduct")
    public List<Object[]> findOpportunitiesClosedWonByProduct();

    @GetMapping("/findOpportunitiesClosedLostByProduct")
    public List<Object[]> findOpportunitiesClosedLostByProduct();

    @GetMapping("/findOpportunitiesOpenByProduct")
    public List<Object[]> findOpportunitiesOpenByProduct();

    @GetMapping("/findOpportunitiesByCountry")
    public List<Object[]> findOpportunitiesByCountry();

    @GetMapping("/findOpportunitiesClosedWonByCountry")
    public List<Object[]> findOpportunitiesClosedWonByCountry();

    @GetMapping("/findOpportunitiesClosedLostByCountry")
    public List<Object[]> findOpportunitiesClosedLostByCountry();

    @GetMapping("/findOpportunitiesOpenByCountry")
    public List<Object[]> findOpportunitiesOpenByCountry();

    @GetMapping("/findOpportunitiesByCity")
    public List<Object[]> findOpportunitiesByCity();

    @GetMapping("/findOpportunitiesClosedWonByCity")
    public List<Object[]> findOpportunitiesClosedWonByCity();

    @GetMapping("/findOpportunitiesClosedLostByCity")
    public List<Object[]> findOpportunitiesClosedLostByCity();

    @GetMapping("/findOpportunitiesOpenByCity")
    public List<Object[]> findOpportunitiesOpenByCity();
    @GetMapping("/findOpportunitiesByIndustry")
    public List<Object[]> findOpportunitiesByIndustry();

    @GetMapping("/findOpportunitiesClosdeWonByIndustry")
    public List<Object[]> findOpportunitiesClosdeWonByIndustry();
    @GetMapping("/findOpportunitiesClosedLostByIndustry")
    public List<Object[]> findOpportunitiesClosedLostByIndustry();

    @GetMapping("/findOpportunitiesOpenByIndustry")
    public List<Object[]> findOpportunitiesOpenByIndustry();

    @GetMapping("/avgQuantity")
    public double AvgQuantity();

    @GetMapping("/medQuantity_firstStep")
    public List<Integer> MedQuantity_firstStep();

    @GetMapping("/maxQuantity")
    public int MaxQuantity();

    @GetMapping("/minQuantity")
    public int MinQuantity();

    @GetMapping("/findMeanOpportunitiesPerAccount")
    public double findMeanOpportunitiesPerAccount();

    @GetMapping("/medOpportunitiesPerAccount_firstStep")
    public List<Integer> medOpportunitiesPerAccount_firstStep();

    @GetMapping("/findMaxOpportunitiesPerAccount")
    public int findMaxOpportunitiesPerAccount();

    @GetMapping("/findMinOpportunitiesPerAccount")
    public int findMinOpportunitiesPerAccount();

}
