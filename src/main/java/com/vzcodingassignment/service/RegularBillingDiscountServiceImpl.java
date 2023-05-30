package com.vzcodingassignment.service;

import com.vzcodingassignment.constant.RegularUserSlab;

/**
 * @author amitkumar.jha
 *
 */
public class RegularBillingDiscountServiceImpl implements BillingDiscountService {
    @Override
    public double discountCalculation(double purchaseAmount) {
        if (purchaseAmount <= 0)
            return 0;
        else if (RegularUserSlab.SLAB1.getDiscount() > 100 || RegularUserSlab.SLAB2.getDiscount() > 100 || RegularUserSlab.SLAB3.getDiscount() > 100)
            throw new RuntimeException("Ohh!! Sorry,please provide a correct discount value ");
        return getPurchaseDiscountSlab(purchaseAmount);
    }

    public static double getPurchaseDiscountSlab(double purchaseAmount) {
        if (purchaseAmount > 0 && purchaseAmount <= RegularUserSlab.SLAB1.getMaxValue()) {
            return (RegularUserSlab.SLAB1.getDiscount() == 0) ? purchaseAmount
                    : (RegularUserSlab.SLAB1.getMaxValue() * RegularUserSlab.SLAB1.getDiscount());
        } else if (purchaseAmount > RegularUserSlab.SLAB2.getMinValue()
                && purchaseAmount <= RegularUserSlab.SLAB2.getMaxValue()) {
            double discountSlab1 = (RegularUserSlab.SLAB2.getMinValue() - RegularUserSlab.SLAB1.getMinValue())
                    * RegularUserSlab.SLAB1.getDiscount();
            return purchaseAmount
                    - (discountSlab1 + ((RegularUserSlab.SLAB2.getMinValue() - RegularUserSlab.SLAB1.getMinValue())
                    * RegularUserSlab.SLAB2.getDiscount()));
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
