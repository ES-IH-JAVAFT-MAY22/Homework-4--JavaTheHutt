package com.ironhack.homework4.proxyobjectservice.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.homework4.proxyobjectservice.Repository.AccountRepository;
import com.ironhack.homework4.proxyobjectservice.Repository.ContactRepository;
import com.ironhack.homework4.proxyobjectservice.Repository.LeadRepository;
import com.ironhack.homework4.proxyobjectservice.Repository.SalesRepRepository;
import com.ironhack.homework4.proxyobjectservice.controller.dto.ObjectDTO;
import com.ironhack.homework4.proxyobjectservice.enums.Industry;
import com.ironhack.homework4.proxyobjectservice.model.Account;
import com.ironhack.homework4.proxyobjectservice.model.Contact;
import com.ironhack.homework4.proxyobjectservice.model.Lead;
import com.ironhack.homework4.proxyobjectservice.model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class ObjectControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Lead lead1, lead2;
    private Contact contact1, contact2;
    private SalesRep salesRep1, salesRep2;
    @Autowired
    private AccountRepository accountRepository;
    private Account account1, account2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        account1 = new Account(Industry.ECOMMERCE, 50, "Madrid", "España");
        account2 = new Account(Industry.OTHER, 40, "París", "Francia");

        contact1 = new Contact("Pepe","65840325","pepe@gmail.com","Aldi",
                account1 );
        contact2 =new Contact("Paco","67840325","paco@gmail.com","Kolo",
                account2 );
        salesRep1 = new SalesRep("Javier");
        salesRep2 = new SalesRep("Maria");

        lead1 =new Lead ("Mafalda", "69548323", "maf@a", "Mafa", salesRep1);
        lead2 =new Lead ("Susana", "69500323", "susa@a", "Susa", salesRep2);
        accountRepository.saveAll(List.of(account1,account2));
        contactRepository.saveAll(List.of(contact1,contact2));
        salesRepRepository.saveAll(List.of(salesRep1,salesRep2));
        leadRepository.saveAll(List.of(lead1,lead2));

    }

    @AfterEach
    void tearDown() {
        leadRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();

    }

    @Test
    void creatingLead() throws Exception {
        //salesRep1.setId(1);
        Lead lead =new Lead ("Mafalda", "69548323", "maf@a", "Mafa",null);
        String body = objectMapper.writeValueAsString(lead);
        MvcResult mvcResult = mockMvc.perform(post("/leads/"+salesRep1.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mafalda"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Blanca"));

    }

    @Test
    void creatingContact() throws Exception {

        ObjectDTO objectDTO = new ObjectDTO(lead1, account1);

        String body = objectMapper.writeValueAsString(objectDTO);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/contacts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Mafalda"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Blanca"));
    }

    @Test
    void creatingSalesRep() throws Exception {

        String body = objectMapper.writeValueAsString(salesRep1);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/salesReps")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Javier"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Blanca"));
    }

    @Test
    void getSalesRep() throws Exception {

        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/salesReps/" + salesRep1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Javier"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Blanca"));

    }

    @Test
    void findLeadsBySalesRep() throws Exception {
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/findLeadsBySalesRep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Anastasia"));
    }
}
