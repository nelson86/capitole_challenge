package com.capitole_consulting.challenge.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
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
@Tag("integration")
class GetPriceOfProductControllerTest {

    private static final String URL = "/v1/prices";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validateTest1() throws Exception {
        String applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(URL)
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

    @Test
    void validateTest2() throws Exception {
        String applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(URL)
                        .param("applicationDate", applicationDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)),
                        MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.priceListId", Matchers.is(2)),
                        MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-14T15:00:00")),
                        MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-06-14T18:30:00")),
                        MockMvcResultMatchers.jsonPath("$.price", Matchers.is(25.45d))
                );
    }

    @Test
    void validateTest3() throws Exception {
        String applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(URL)
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

    @Test
    void validateTest4() throws Exception {
        String applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(URL)
                        .param("applicationDate", applicationDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)),
                        MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.priceListId", Matchers.is(3)),
                        MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-15T00:00:00")),
                        MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-06-15T11:00:00")),
                        MockMvcResultMatchers.jsonPath("$.price", Matchers.is(30.5d))
                );
    }

    @Test
    void validateTest5() throws Exception {
        String applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0, 0).toString();
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform( MockMvcRequestBuilders.get(URL)
                        .param("applicationDate", applicationDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        status().isOk(),
                        MockMvcResultMatchers.jsonPath("$.productId", Matchers.is(35455)),
                        MockMvcResultMatchers.jsonPath("$.brandId", Matchers.is(1)),
                        MockMvcResultMatchers.jsonPath("$.priceListId", Matchers.is(4)),
                        MockMvcResultMatchers.jsonPath("$.startDate", Matchers.is("2020-06-15T16:00:00")),
                        MockMvcResultMatchers.jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59")),
                        MockMvcResultMatchers.jsonPath("$.price", Matchers.is(38.95d))
                );
    }
}