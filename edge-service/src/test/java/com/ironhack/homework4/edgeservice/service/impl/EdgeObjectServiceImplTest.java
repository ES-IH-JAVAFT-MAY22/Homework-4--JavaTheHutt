package com.ironhack.homework4.edgeservice.service.impl;

import com.ironhack.homework4.edgeservice.client.ObjectProxyClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class EdgeObjectServiceImplTest {
    @MockBean
    private ObjectProxyClient objectProxyClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //@Test
    //void creatingLead() {Mockito.when(objectProxyClient.creatingLead(name,)).thenReturn(Ana,);
   // }

    @Test
    void creatingLeadFallback() {
    }

    @Test
    void creatingContact() {
    }

    @Test
    void creatingContactFallback() {
    }

    @Test
    void creatingSalesRep() {
    }

    @Test
    void creatingSalesRepFallback() {
    }

    @Test
    void getSalesRep() {
    }

    @Test
    void getSalesRepFallback() {
    }
}