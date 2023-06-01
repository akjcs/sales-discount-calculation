package com.vzcodingassignment.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class UserPurchaseRequest {

    @NotBlank(message = "customer-type can't be blank")
    @JsonProperty("customer-type")
    private String customerType;
    @Min(value = 0,message = "purchase amount can't be negative value ")
    @JsonProperty("purchase-amount")
    private double purchaseAmount;

    public UserPurchaseRequest(final String customerType, final double purchaseAmount) {
        this.customerType = customerType;
        this.purchaseAmount = purchaseAmount;
    }
}
