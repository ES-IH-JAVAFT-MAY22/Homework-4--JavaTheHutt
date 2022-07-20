package com.ironhack.homework4.proxyobjectservice.Repository;

import com.ironhack.homework4.proxyobjectservice.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    //Count of Leads by SalesRep
//    @Query("SELECT l.salesRep, COUNT(l.salesRep) FROM Lead l GROUP BY l.salesRep")
//    List<Object[]> findLeadsBySalesRep();

    @Query(value = "SELECT l.sales_rep, COUNT(l.sales_rep) FROM leads l GROUP BY l.sales_rep", nativeQuery = true)
    List<Object[] > findLeadsBySalesRep();
}

