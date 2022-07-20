package com.ironhack.homework4.edgeservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.homework4.edgeservice.client.ObjectProxyClient;
import com.ironhack.homework4.edgeservice.client.OpportunityProxyClient;
import com.ironhack.homework4.edgeservice.controller.dto.OpportunityDTO;
import com.ironhack.homework4.edgeservice.enums.Industry;
import com.ironhack.homework4.edgeservice.enums.Product;
import com.ironhack.homework4.edgeservice.enums.Status;
import com.ironhack.homework4.edgeservice.model.Account;
import com.ironhack.homework4.edgeservice.model.Contact;
import com.ironhack.homework4.edgeservice.model.Opportunity;
import com.ironhack.homework4.edgeservice.model.SalesRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EdgeOpportunityServiceImplTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ObjectProxyClient mockObjectProxyClient;
    @MockBean
    private OpportunityProxyClient mockOpportunityProxyClient;
    @MockBean
    private EdgeOpportunityServiceImpl mockEdgeOpportunityService;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Opportunity opportunity1, opportunity2;
    private Contact decisionMaker1, setDecisionMaker2;
    private Account account1, account2;
    private SalesRep salesRep1;
    private OpportunityDTO opportunityDTO;

    @BeforeEach
    void setUp() {
        opportunity1 = new Opportunity(Product.BOX, 10, decisionMaker1, salesRep1,
                Status.OPEN, account1);
        decisionMaker1 = new Contact("Pepa", "5454", "pepa@mail",
                "compa", account1);
        SalesRep salesRep1 = new SalesRep("Blanca");
        Account account1 = new Account(Industry.ECOMMERCE, 12, "Málaga", "España");
        opportunity1 = new Opportunity(Product.BOX, 10, decisionMaker1, salesRep1, Status.OPEN, account1);
        opportunityDTO = new OpportunityDTO(decisionMaker1, account1, salesRep1);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void creatingOpportunity() throws Exception {


        Mockito.when(mockEdgeOpportunityService.creatingOpportunity(Product.BOX, 10, opportunityDTO))
                .thenReturn(opportunity1);
        MvcResult mvcResult = mockMvc.perform(post("/opportunities"))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pepa"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));

        // Mockito.when(opportunityProxyClient.creatingOpportunity(Product.BOX, 10, opportunityDTO)).thenReturn(opportunity1);
    }

    //void creatingLead() {Mockito.when(objectProxyClient.creatingLead(name,)).thenReturn(Ana,);
    // }

    @Test
    void findById() {
    }

    @Test
    void findOpportunitiesBySalesRep() throws Exception {
/*        decisionMaker1 = new Contact("Pepa", "5454", "pepa@mail", "compa", account1);
        SalesRep salesRep1 = new SalesRep("Blanca");
        Account account1 = new Account(Industry.ECOMMERCE, 12, "Málaga", "España");
        opportunity1 = new Opportunity(Product.BOX, 10, decisionMaker1, salesRep1, Status.OPEN, account1);
        opportunityDTO = new OpportunityDTO(decisionMaker1, account1, salesRep1);
        List<Object[]> objectList = new ArrayList<>();

        Mockito.when(opportunity1.getSalesRep()).thenReturn(salesRep1);*/

        //Mockito.when(opportunityProxyClient.findOpportunitiesBySalesRep()).thenReturn(objectList);

        Mockito.when(mockOpportunityProxyClient.findOpportunitiesBySalesRep())
                .thenReturn((List<Object[]>) salesRep1);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/findOpportunitiesBySalesRep"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));

    }

    // Mockito.when(opportunityProxyClient.creatingOpportunity(Product.BOX, 10, opportunityDTO)).thenReturn(opportunity1);

    @Test
    void findOpportunitiesClosedWonBySalesRep() throws Exception {
        Mockito.when(mockOpportunityProxyClient.findOpportunitiesClosedLostBySalesRep())
                .thenReturn((List<Object[]>) salesRep1);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/findOpportunitiesClosedWonBySalesRep"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));

    }


    @Test
    void findOpportunitiesClosedLostBySalesRep() throws Exception {
        Mockito.when(mockOpportunityProxyClient.findOpportunitiesClosedWonBySalesRep())
                .thenReturn((List<Object[]>) salesRep1);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/findOpportunitiesClosedLostBySalesRep"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertFalse(mvcResult.getResponse().getContentAsString().contains("Manuel"));
    }


}