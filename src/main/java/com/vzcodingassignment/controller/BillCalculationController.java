package com.vzcodingassignment.controller;

import com.vzcodingassignment.request.UserPurchaseRequest;
import com.vzcodingassignment.response.UserBillingResponse;
import com.vzcodingassignment.service.BillingDiscountService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amitkumar.jha
 *  bilCalculationController for calculating a bill
 */
@Slf4j
@RestController
public class BillCalculationController {

    @Autowired
    private BillingDiscountService regularBillingService;


    @PostMapping(value = "/bill-calculation", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserBillingResponse> billCalculation(@RequestBody @Valid UserPurchaseRequest userPurchaseRequest) {
            log.info("inside BillCalculationController,method=billCalculation,message=started");
            return new ResponseEntity<>(regularBillingService.
                    discountCalculation(userPurchaseRequest.getCustomerType(),userPurchaseRequest.getPurchaseAmount()), HttpStatus.OK);

    }
}
