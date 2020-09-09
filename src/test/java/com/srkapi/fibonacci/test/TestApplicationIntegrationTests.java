package com.srkapi.fibonacci.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.srkapi.fibonacci.test.application.port.in.model.FibonacciRequestCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestApplicationIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculatorFibonacciWhenValueIsPositive() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/fibonacci")
                .content(asJsonString(new FibonacciRequestCommand(6)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(8));
    }

    @Test
    public void shouldReturn412ErrorCodeWhenFibonacciIsNegative() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/fibonacci")
                .content(asJsonString(new FibonacciRequestCommand(-6)))
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
