package com.capitole_consulting.challenge.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetPriceOfProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPriceOfProductOk() throws Exception {
        String url = "/v1/prices";
        String applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(url)
                        .param("applicationDate", applicationDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)),
                        MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.priceListId", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-14T00:00:00")),
                        MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59")),
                        MockMvcResultMatchers.jsonPath("$.price", Matchers.is(35.5d))
                );
    }
}