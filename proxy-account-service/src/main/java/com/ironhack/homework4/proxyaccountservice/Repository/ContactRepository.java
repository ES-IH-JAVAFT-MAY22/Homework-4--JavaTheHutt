package com.ironhack.homework4.proxyaccountservice.Repository;


import com.ironhack.homework4.proxyaccountservice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
