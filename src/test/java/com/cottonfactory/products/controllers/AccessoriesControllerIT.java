package com.cottonfactory.products.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccessoriesControllerIT {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getAllAccessories() throws Exception {
        mockMvc.perform(get("/api/products/accessories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
}