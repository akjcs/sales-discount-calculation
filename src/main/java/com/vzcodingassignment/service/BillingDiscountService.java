package com.vzcodingassignment.service;

/**
 * @author amitkumar.jha
 *
 */
@FunctionalInterface
public interface BillingDiscountService {
    double discountCalculation(double purchaseAmount);
}
