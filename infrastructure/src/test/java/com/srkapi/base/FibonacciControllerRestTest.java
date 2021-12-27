package com.srkapi.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.srkapi.base.api.controller.request.CalculatorRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class FibonacciControllerRestTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculatorFibonacciWhenValueIsPositive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/fibonacci")
                .content(asJsonString(new CalculatorRequest(6)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(8));
    }

    @Test
    public void shouldReturn412ErrorCodeWhenFibonacciIsNegative() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/fibonacci")
                .content(asJsonString(new CalculatorRequest(-6)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}


