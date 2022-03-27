package com.example.springamqpexam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(Producer.class)
class ProducerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void 메시지_발행_테스트() throws Exception {
        mockMvc.perform(get("/send").param("msg=test"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"))
                .andDo(print());
    }
}