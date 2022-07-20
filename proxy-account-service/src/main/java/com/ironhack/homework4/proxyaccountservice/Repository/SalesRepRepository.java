package com.ironhack.homework4.proxyaccountservice.Repository;

import com.ironhack.homework4.proxyaccountservice.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
}
