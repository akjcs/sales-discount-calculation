package com.vzcodingassignment.service;

import com.vzcodingassignment.response.UserBillingResponse;

/**
 * @author amitkumar.jha
 */
@FunctionalInterface
public interface BillingDiscountService {
    UserBillingResponse discountCalculation(String customerType, double purchaseAmount);
}
