package com.kale.trade.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class TradeStoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addStore() {

    }

    @Test
    void getTradeStore() {
    }

    @Test
    void getTradeStoreS() throws Exception {
        this.mockMvc.perform(get("/trade-store")).andDo(print()).andExpect(status().isOk());
    }
}