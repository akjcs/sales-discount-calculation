package com.vzcodingassignment.service;

import com.vzcodingassignment.constant.ApplicationConstant;
import com.vzcodingassignment.response.UserBillingResponse;
import com.vzcodingassignment.util.FormatNumber;
import org.springframework.stereotype.Component;

/**
 * @author amitkumar.jha
 */
@Component("premiumBillingService")
public class PremiumBillingDiscountServiceImpl implements BillingDiscountService {




    @Override
    public UserBillingResponse discountCalculation(double purchaseAmount) {
        UserBillingResponse userBillingResponse = new UserBillingResponse();
        if (purchaseAmount <= 0)
            throw new IllegalStateException("purchase amount is not a valid input");
        var billAmount = FormatNumber.formatDecimalValue(discountSlabCalculation(purchaseAmount));
        userBillingResponse.setBillAmount(billAmount);
        return userBillingResponse;
    }

    protected double discountSlabCalculation(double purchaseAmount) {
        double disCountSlab1=0;
        double disCountSlab2=0;
        double disCountSlab3=0;
        double disCountSlab4=0;
         if (purchaseAmount >= 0 && ApplicationConstant.slabRange1 >= purchaseAmount) {
            disCountSlab1 = purchaseAmount * 0.1;
            return purchaseAmount -disCountSlab1;
        } else if (purchaseAmount > ApplicationConstant.slabRange1 &&
                 purchaseAmount <= ApplicationConstant.slabRange2) {
            disCountSlab1 =  ApplicationConstant.slabRange1 * 0.1;
            disCountSlab2 = (purchaseAmount - ApplicationConstant.slabRange1) * 0.15;
            return purchaseAmount - (disCountSlab1 + disCountSlab2);
        } else if (purchaseAmount > ApplicationConstant.slabRange2 && purchaseAmount <= ApplicationConstant.slabRange3) {
            disCountSlab1 = ApplicationConstant.slabRange1 * 0.1;
            disCountSlab2 = ApplicationConstant.slabRange1 * 0.15;
            disCountSlab3 = (purchaseAmount - ApplicationConstant.slabRange2) * 0.2;
            return purchaseAmount - (disCountSlab1 + disCountSlab2 + disCountSlab3);
        } else if (purchaseAmount > ApplicationConstant.slabRange3) {
            disCountSlab1 = ApplicationConstant.slabRange1 * 0.1;
            disCountSlab2 = ApplicationConstant.slabRange1 * 0.15;
            disCountSlab3 = ApplicationConstant.slabRange1 * 0.2;
            disCountSlab4 = (purchaseAmount - ApplicationConstant.slabRange3) * 0.3;
            return purchaseAmount - (disCountSlab1 + disCountSlab2 + disCountSlab3 + disCountSlab4);
        }
        return purchaseAmount;
    }
}

