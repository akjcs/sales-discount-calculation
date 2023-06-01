package com.vzcodingassignment.service;

import com.vzcodingassignment.constant.CustomerType;
import com.vzcodingassignment.constant.PremiumUserSlab;
import com.vzcodingassignment.constant.RegularUserSlab;
import com.vzcodingassignment.exception.IllegalStateException;
import com.vzcodingassignment.response.UserBillingResponse;
import com.vzcodingassignment.util.FormatNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amitkumar.jha
 */
@Slf4j
@Service
public class BillingDiscountServiceImpl implements BillingDiscountService {

    /**
     * @param customerType regular,premium,gold,silver etc
     * @return UserBillingResponse object- used for future extension purpose to return the other attribute
     * throw Number format exception
     */
    @Override
    public UserBillingResponse discountCalculation(String customerType, double purchaseAmount) {
        log.debug("method=discountCalculation,message= inside discountCalculation service,customerType ={},purchaseAmout ={}", customerType, purchaseAmount);
        UserBillingResponse userBillingResponse = new UserBillingResponse();
        userBillingResponse.setBillAmount(FormatNumber.formatDecimalValue(getFinalBillAmount(purchaseAmount, customerType)));
        return userBillingResponse;
    }

    /**
     * @param purchaseAmount - input value
     * @return calculated bill after applying a different discount slab
     */
    public double getFinalBillAmount(double purchaseAmount, String customerType) {
        return purchaseAmount - calculateBillAmount(purchaseAmount, customerType);
    }


    /**
     * @param purchaseAmount - input value
     * @return accumalation of varios discount with various slab for different user type
     * description -
     */
    public double calculateBillAmount(double purchaseAmount, String customerType) {
        double discount = 0.0;
        String type = CustomerType.valueType(customerType).getCustomerType().toUpperCase();
        switch (type) {
            case "REGULAR":
                for (RegularUserSlab regularUserSlab : RegularUserSlab.values()) {
                    for (RegularUserSlab rSlab : RegularUserSlab.values()) {
                        Map<String, Double> map = calculateDiscountSlab(purchaseAmount, rSlab.getMinValue(),
                                rSlab.getMaxValue(), rSlab.getDiscount());
                        purchaseAmount = map.get("remainingSlabDiscount");
                        discount = discount + map.get("discount");
                        if (purchaseAmount <= rSlab.getMaxValue()) {
                            break;
                        }
                    }
                    if (purchaseAmount == 0) {
                        break;
                    }
                }
                break;
            case "PREMIUM":
                for (PremiumUserSlab r : PremiumUserSlab.values()) {
                    for (PremiumUserSlab pSlab : PremiumUserSlab.values()) {
                        Map<String, Double> map = calculateDiscountSlab(purchaseAmount, pSlab.getMinValue(), pSlab.getMaxValue(), pSlab.getDiscount());
                        purchaseAmount = map.get("remainingSlabDiscount");
                        discount = discount + map.get("discount");
                        if (purchaseAmount <= pSlab.getMaxValue()) {
                            break;
                        }
                    }
                    if (purchaseAmount == 0) {
                        break;
                    }
                }
                break;
            default:
                log.warn("Invalid scenario for input customer type");
                throw new IllegalStateException("Invalid case");
        }
        return discount;
    }


    /**
     * @param purchaseAmount - input value
     * @param minValue       - slab range min value -
     * @param maxValue       -slab range max value
     * @param discountRate   - discount rate for each slab
     * @return calculate discount on each slab amount and then set the result in the map
     */
    private static Map<String, Double> calculateDiscountSlab(Double purchaseAmount, Double minValue, Double maxValue, Double discountRate) {
        Double discount = 0.0;
        Map<String, Double> map = new HashMap<>();
        if (purchaseAmount <= maxValue) {
            discount = calculateDiscount(minValue, discountRate, purchaseAmount);
            purchaseAmount = calculateRemainingDiscountSlab(purchaseAmount, minValue);
        }
        map.put("discount", discount);
        map.put("remainingSlabDiscount", purchaseAmount);
        return map;
    }

    /**
     * @param purchaseAmount - input value
     * @param minValue       -slab min value
     * @return this method will calculate each slab amount remained after caculation e.g input 8000,will return 4000 last slab
     */
    private static Double calculateRemainingDiscountSlab(Double purchaseAmount, double minValue) {
        if (minValue == 0) {
            purchaseAmount = purchaseAmount - (purchaseAmount - minValue);
        } else {
            purchaseAmount = purchaseAmount - (purchaseAmount - minValue + 1);
        }
        return purchaseAmount;
    }

    /**
     * @param minValue       - min value
     * @param discountRate   - discount rate
     * @param purchaseAmount - purchase amount
     * @return return calculated value to previous method
     */
    private static Double calculateDiscount(Double minValue, Double discountRate, Double purchaseAmount) {
        Double discount;
        if (minValue == 0) {
            discount = (discountRate * (purchaseAmount - (minValue)));
        } else {
            discount = (discountRate * (purchaseAmount - (minValue)));
        }
        return discount;
    }
}
