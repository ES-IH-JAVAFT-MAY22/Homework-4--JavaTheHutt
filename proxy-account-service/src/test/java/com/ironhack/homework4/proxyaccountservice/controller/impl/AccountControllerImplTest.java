package com.ironhack.homework4.proxyaccountservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.homework4.proxyaccountservice.Repository.AccountRepository;
import com.ironhack.homework4.proxyaccountservice.enums.Industry;
import com.ironhack.homework4.proxyaccountservice.model.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AccountRepository accountRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Account account1, account2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        account1 = new Account(Industry.ECOMMERCE, 50, "Madrid", "España");
        account2 = new Account(Industry.OTHER, 40, "París", "Francia");
        accountRepository.saveAll(List.of(account1,account2));
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void creatingAccount() throws Exception {
        String body = objectMapper.writeValueAsString(account1);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(post("/accounts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Madrid"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("account2"));

    }

    @Test
    void avgEmployeeCount() throws Exception{

        account1 = new Account(Industry.ECOMMERCE, 50, "Madrid", "España");
        account2 = new Account(Industry.OTHER, 40, "París", "Francia");
        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/avgEmployeeCount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("45"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("80"));

    }

    @Test
    void medEmployeeCount_firstStep()throws Exception {
        account1 = new Account(Industry.ECOMMERCE, 50, "Madrid", "España");
        account2 = new Account(Industry.OTHER, 50, "París", "Francia");


        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/medEmployeeCount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("70"));

    }

    @Test
    void maxEmployeeCount() throws Exception {


        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/maxEmployeeCount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("50"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("70"));
    }

    @Test
    void minEmployeeCount()throws Exception {


        MvcResult mvcResult = (MvcResult) mockMvc.perform(get("/minEmployeeCount")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("40"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("70"));
    }
}