package com.srkapi.base.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class UserControllerRestTest extends IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    /**
     @Test void shouldCreateUserWhenRequestIsValid() throws Exception {
     mockMvc.perform(MockMvcRequestBuilders
     .post("/users")
     .content(JsonUtils.asJsonString(new UserRequest("Mark", "12345o.", "email@emial.com")))
     .contentType(MediaType.APPLICATION_JSON))
     .andExpect(status().isOk());
     .andExpect(MockMvcResultMatchers.jsonPath("$.result").exists())
     .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(8));
     }**/
}
