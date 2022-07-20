package com.ironhack.homework4.proxyobjectservice.Repository;

import com.ironhack.homework4.proxyobjectservice.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
