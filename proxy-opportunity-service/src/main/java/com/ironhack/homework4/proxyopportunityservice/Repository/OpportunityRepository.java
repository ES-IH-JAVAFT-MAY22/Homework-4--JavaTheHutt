package com.ironhack.homework4.proxyopportunityservice.Repository;

import com.ironhack.homework4.proxyopportunityservice.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
    //Count of all Opportunities by SalesRep
    @Query(value = "SELECT o.sales_rep,COUNT(o.id) FROM opportunity o GROUP BY o.sales_rep", nativeQuery = true)
    List<Object[]> findOpportunitiesBySalesRep();

    //Count of all CLOSED_WON Opportunities by SalesRep
    @Query(value = "SELECT o.sales_rep, COUNT(o.id) FROM opportunity o WHERE o.status = 'CLOSED_WON' GROUP BY " +
            "o.sales_rep", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedWonBySalesRep();

    //Count of all CLOSED_LOST Opportunities by SalesRep
    @Query(value = "SELECT o.sales_rep, COUNT(o.id) FROM opportunity o WHERE o.status = 'CLOSED_LOST' GROUP BY " +
            "o.sales_rep", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedLostBySalesRep();

    //Count of all OPEN Opportunities by SalesRep
    @Query(value = "SELECT o.sales_rep, COUNT(o.id) FROM opportunity o WHERE o.status = 'OPEN' GROUP BY " +
            "o.sales_rep", nativeQuery = true)
    List<Object[]> findOpportunitiesOpenBySalesRep();

    //Count of all Opportunities by the product
    @Query(value = "SELECT o.product, COUNT(o.id) FROM opportunity o GROUP BY o.product", nativeQuery = true)
    List<Object[]> findOpportunitiesByProduct();

    //Count of all CLOSED_WON Opportunities by the product
    @Query(value= "SELECT o.product, COUNT(o.id) FROM opportunity o WHERE o.status = 'CLOSED_WON' GROUP BY o.product",
            nativeQuery = true)
    List<Object[]> findOpportunitiesClosedWonByProduct();

    //Count of all CLOSED_LOST Opportunities by the product
    @Query(value = "SELECT o.product, COUNT(o.id) FROM opportunity o WHERE o.status = 'CLOSED_LOST' GROUP BY o.product",
    nativeQuery = true)
    List<Object[]> findOpportunitiesClosedLostByProduct();

    //Count of all OPEN Opportunities by the product
    @Query(value = "SELECT o.product, COUNT(o.id) FROM opportunity o WHERE o.status = 'OPEN' GROUP BY o.product",
            nativeQuery = true)
    List<Object[]> findOpportunitiesOpenByProduct();

    //Count of all Opportunities by country
    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id GROUP BY" +
            " a.country", nativeQuery = true)
    List<Object[]> findOpportunitiesByCountry();

    //Count of all CLOSED_WON Opportunities by country
    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_WON' GROUP BY a.country", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedWonByCountry();

    //Count of all CLOSED_LOST Opportunities by country
    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_LOST' GROUP BY a.country", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedLostByCountry();

    // Count of all OPEN Opportunities by country
    @Query(value = "SELECT a.country, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'OPEN' GROUP BY a.country", nativeQuery = true)
    List<Object[]> findOpportunitiesOpenByCountry();

    //Count of all Opportunities by the city
    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id GROUP BY a.city",
    nativeQuery = true)
    List<Object[]> findOpportunitiesByCity();

    //Count of all CLOSED_WON Opportunities by the city
    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_WON' GROUP BY a.city", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedWonByCity();

    //Count of all CLOSED_LOST Opportunities by the city
    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_LOST' GROUP BY a.city", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedLostByCity();

    //Count of all OPEN Opportunities by the city
    @Query(value = "SELECT a.city, COUNT(o.id) FROM opportunity o JOIN account a ON o.account_id=a.id " +
            "WHERE o.status = 'OPEN' GROUP BY a.city", nativeQuery = true)
    List<Object[]> findOpportunitiesOpenByCity();

    //Count of all Opportunities by industry
    @Query(value = "SELECT a.industry, COUNT(o.id) FROM opportunity o JOIN account a on o.account_id=a.id GROUP BY a.industry",
    nativeQuery = true)
    List<Object[]> findOpportunitiesByIndustry();

    //Count of all CLOSED_WON Opportunities by industry
    @Query(value = "SELECT a.industry, COUNT(o.id) FROM opportunity o JOIN account a on o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_WON' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> findOpportunitiesClosdeWonByIndustry();

    //Count of all CLOSED_LOST Opportunities by industry
    @Query(value = "SELECT a.industry, COUNT(o.id) FROM opportunity o JOIN account a on o.account_id=a.id " +
            "WHERE o.status = 'CLOSED_LOST' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> findOpportunitiesClosedLostByIndustry();

    //A count of all OPEN Opportunities by industry
    @Query(value = "SELECT a.industry, COUNT(o.id) FROM opportunity o JOIN account a on o.account_id=a.id " +
            "WHERE o.status = 'OPEN' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> findOpportunitiesOpenByIndustry();

    //The mean quantity of products order
    @Query("SELECT AVG(o.quantity) FROM Opportunity o")
    double AvgQuantity();


    // The median quantity of products order
    @Query("SELECT o.quantity FROM Opportunity o ORDER BY o.quantity")
    List<Integer> MedQuantity_firstStep();

    //The maximum quantity of products order
    @Query("SELECT MAX(o.quantity) FROM Opportunity o")
    int MaxQuantity();

    //The minimum quantity of products order
    @Query("SELECT MIN(o.quantity) FROM Opportunity o")
    int MinQuantity();

    //The mean number of Opportunities associated with an Account
    @Query(value = "SELECT AVG(a.countOpp) FROM (SELECT count(*) AS countOpp FROM opportunity GROUP BY " +
            "account_id) AS a", nativeQuery = true)
    double findMeanOpportunitiesPerAccount();

    ////The median number of Opportunities associated with an Account
    @Query( value = "SELECT AVG(a.countOpp) FROM (SELECT count(*) AS countOpp FROM opportunity GROUP BY " +
            "account_id) AS a ORDER BY a.countOpp", nativeQuery = true)
    List<Integer> medOpportunitiesPerAccount_firstStep();

    ////The maximum number of Opportunities associated with an Account
    @Query(value = "SELECT MAX(a.countOpp) FROM (SELECT count(*) AS countOpp FROM opportunity GROUP BY " +
            "account_id) AS a", nativeQuery = true)
    int findMaxOpportunitiesPerAccount();
    //
    ////The minimum number of Opportunities associated with an Account
    @Query(value = "SELECT MIN(a.countOpp) FROM (SELECT count(*) AS countOpp FROM opportunity GROUP BY " +
            "account_id) AS a", nativeQuery = true)
    int findMinOpportunitiesPerAccount();
}

