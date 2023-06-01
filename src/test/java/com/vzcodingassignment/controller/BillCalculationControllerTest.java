package com.vzcodingassignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vzcodingassignment.request.UserPurchaseRequest;
import com.vzcodingassignment.service.BillingDiscountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BillCalculationController.class)
public class BillCalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BillingDiscountService billingDiscountService;
    private static final String PATH = "/bill-calculation";

    // test success scenario
    @Test
    public void testDiscountCalculation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bill-calculation").content(
                                mapper.writeValueAsString(new UserPurchaseRequest("regular", 4000)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }

    // test to validate code without customer type
    @Test
    public void testDiscountCalculationWithInvalidInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/bill-calculation").content(
                                mapper.writeValueAsString(new UserPurchaseRequest(null, 4000)))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }
}
