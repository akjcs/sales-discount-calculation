package com.vzcodingassignment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserBillingResponse {
    @JsonProperty("bill_amount")
    private String billAmount;
}
