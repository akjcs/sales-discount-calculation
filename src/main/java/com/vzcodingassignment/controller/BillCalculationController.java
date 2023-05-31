package com.vzcodingassignment.controller;

import com.vzcodingassignment.constant.CustomerType;
import com.vzcodingassignment.request.UserPurchaseRequest;
import com.vzcodingassignment.response.UserBillingResponse;
import com.vzcodingassignment.service.BillingDiscountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BillCalculationController {

    @Autowired
    @Qualifier("regularBillingService")
    BillingDiscountService regularBillingService;

    @Autowired
    @Qualifier("premiumBillingService")
    BillingDiscountService premiumBillingService;

    @PostMapping(value = "bill-calculation", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBillingResponse> billCalculation(@RequestBody @Valid UserPurchaseRequest userPurchaseRequest) {
        String type = CustomerType.valueType(userPurchaseRequest.getCustomerType()).getCustomerType();
        if (type.equalsIgnoreCase(CustomerType.REGULAR.getCustomerType())) {
            log.info("inside BillCalculationController,method=billCalculation,message=started");
            return new ResponseEntity<>(regularBillingService.
                    discountCalculation(userPurchaseRequest.getPurchaseAmount()), HttpStatus.OK);
        } else
            return new ResponseEntity<>(premiumBillingService.
                    discountCalculation(userPurchaseRequest.getPurchaseAmount()), HttpStatus.OK);
    }
}
