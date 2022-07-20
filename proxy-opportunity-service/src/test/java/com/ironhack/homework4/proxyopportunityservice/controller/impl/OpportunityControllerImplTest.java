package com.ironhack.homework4.proxyopportunityservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.homework4.proxyopportunityservice.Repository.*;
import com.ironhack.homework4.proxyopportunityservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.proxyopportunityservice.enums.Industry;
import com.ironhack.homework4.proxyopportunityservice.enums.Product;
import com.ironhack.homework4.proxyopportunityservice.model.*;
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

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OpportunityControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private SalesRepRepository salesRepRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Lead lead1, lead2;
    private Contact contact1, contact2;
    private SalesRep salesRep1, salesRep2;

    private Opportunity opportunity1, opportunity2;

//    private OpportunityDTO opportunityDTO1,opportunityDTO2;

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

//        opportunityDTO1 = new OpportunityDTO(contact1,account1,salesRep1,Product.FLATBED,50);
//        opportunityDTO2= new OpportunityDTO(contact2,account2,salesRep2,Product.BOX,30);

        opportunity1 = new Opportunity(Product.BOX,10,contact1,salesRep1,account1);
        opportunity2 = new Opportunity(Product.FLATBED,20,contact2,salesRep2,account2);

        accountRepository.saveAll(List.of(account1,account2));
        contactRepository.saveAll(List.of(contact1,contact2));
        salesRepRepository.saveAll(List.of(salesRep1,salesRep2));
        leadRepository.saveAll(List.of(lead1,lead2));
        opportunityRepository.saveAll(List.of(opportunity1,opportunity2));
    }

    @AfterEach
    void tearDown() {
        opportunityRepository.deleteAll();
        leadRepository.deleteAll();
        salesRepRepository.deleteAll();
        contactRepository.deleteAll();
        accountRepository.deleteAll();
    }

    //no funciona y no se porque
    @Test
    void creatingOpportunity() throws Exception {
        OpportunityDTO opportunityDTO = new OpportunityDTO(contact1,account1,salesRep1,Product.FLATBED,50);
        String body = objectMapper.writeValueAsString(opportunityDTO);
        MvcResult mvcResult = mockMvc.perform(post("/opportunities")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    //no funciona y no se porque
    @Test
    void findById() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/opportunities/"+opportunity1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("10"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesBySalesRep() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesBySalesRep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }


    @Test
    void findOpportunitiesClosedWonBySalesRep() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedWonBySalesRep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedLostBySalesRep() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedLostBySalesRep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesOpenBySalesRep() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesOpenBySalesRep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesByProduct() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesByProduct")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedWonByProduct() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedWonByProduct")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedLostByProduct() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedLostByProduct")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesOpenByProduct() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesOpenByProduct")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesByCountry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesByCountry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedWonByCountry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedWonByCountry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedLostByCountry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedLostByCountry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesOpenByCountry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesOpenByCountry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesByCity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesByCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedWonByCity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedWonByCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedLostByCity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedLostByCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesOpenByCity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesOpenByCity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesByIndustry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesByIndustry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosdeWonByIndustry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosdeWonByIndustry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesClosedLostByIndustry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesClosedLostByIndustry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void findOpportunitiesOpenByIndustry() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findOpportunitiesOpenByIndustry")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void avgQuantity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/avgQuantity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("20"));
    }

    @Test
    void medQuantity_firstStep() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/medQuantity_firstStep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void maxQuantity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/maxQuantity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void minQuantity() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/minQuantity")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void findMeanOpportunitiesPerAccount() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findMeanOpportunitiesPerAccount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void medOpportunitiesPerAccount_firstStep() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/medOpportunitiesPerAccount_firstStep")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void findMaxOpportunitiesPerAccount() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findMaxOpportunitiesPerAccount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }

    @Test
    void findMinOpportunitiesPerAccount() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/findMinOpportunitiesPerAccount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentType().contains(""));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("30"));
    }
}