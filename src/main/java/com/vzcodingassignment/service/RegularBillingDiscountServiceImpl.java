package com.vzcodingassignment.service;

import com.vzcodingassignment.constant.RegularUserSlab;
import com.vzcodingassignment.response.UserBillingResponse;
import com.vzcodingassignment.util.FormatNumber;
import org.springframework.stereotype.Component;

/**
 * @author amitkumar.jha
 */
@Component("regularBillingService")
public class RegularBillingDiscountServiceImpl implements BillingDiscountService {
    @Override
    public UserBillingResponse discountCalculation(double purchaseAmount) {
        UserBillingResponse userBillingResponse = new UserBillingResponse();
        if (purchaseAmount <= 0) {
            userBillingResponse.setBillAmount("0");
            return userBillingResponse;
        } else if (RegularUserSlab.SLAB1.getDiscount() > 100 || RegularUserSlab.SLAB2.getDiscount() > 100 || RegularUserSlab.SLAB3.getDiscount() > 100)
            throw new RuntimeException("Ohh!! Sorry,please provide a correct discount value ");
        userBillingResponse.setBillAmount(FormatNumber.formatDecimalValue(getPurchaseDiscountSlab(purchaseAmount)));
        return userBillingResponse;
    }

    public double getPurchaseDiscountSlab(double purchaseAmount) {
        if (purchaseAmount > 0 && purchaseAmount <= RegularUserSlab.SLAB1.getMaxValue()) {
            return (RegularUserSlab.SLAB1.getDiscount() == 0) ? purchaseAmount
                    : (RegularUserSlab.SLAB1.getMaxValue() * RegularUserSlab.SLAB1.getDiscount());
        } else if (purchaseAmount > RegularUserSlab.SLAB2.getMinValue()
                && purchaseAmount <= RegularUserSlab.SLAB2.getMaxValue()) {
            double discountSlab1 = (RegularUserSlab.SLAB2.getMinValue() - RegularUserSlab.SLAB1.getMinValue())
                    * RegularUserSlab.SLAB1.getDiscount();
            return purchaseAmount
                    - (purchaseAmount - RegularUserSlab.SLAB2.getMinValue()) *RegularUserSlab.SLAB2.getDiscount();
        } else if (purchaseAmount > RegularUserSlab.SLAB3.getMinValue()) {
            double discountSlab1 = (RegularUserSlab.SLAB2.getMinValue() - RegularUserSlab.SLAB1.getMinValue())
                    * RegularUserSlab.SLAB2.getDiscount();
            double discountSlab2 = (purchaseAmount - RegularUserSlab.SLAB3.getMinValue())
                    * RegularUserSlab.SLAB3.getDiscount();
            return purchaseAmount - (discountSlab1 + discountSlab2);
        }
        return 0;
    }

}
