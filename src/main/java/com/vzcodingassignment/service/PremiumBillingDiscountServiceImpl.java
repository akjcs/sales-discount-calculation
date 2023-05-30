package com.vzcodingassignment.service;

import com.vzcodingassignment.constant.PremiumUserSlab;
import org.springframework.stereotype.Service;

/**
 * @author amitkumar.jha
 *
 */
public class PremiumBillingDiscountServiceImpl implements BillingDiscountService {
    @Override
    public double discountCalculation(double purchaseAmount) {
        if (purchaseAmount <= 0)
            return 0;
        else if (PremiumUserSlab.SLAB1.getDiscount() > 100 || PremiumUserSlab.SLAB2.getDiscount() > 100 || PremiumUserSlab.SLAB3.getDiscount() > 100
                || PremiumUserSlab.SLAB4.getDiscount() > 100)
            throw new RuntimeException("Ohh!! Sorry,please provide a correct discount value ");
        return getBillAfterDiscountCalculation(purchaseAmount);

    }

    public double getBillAfterDiscountCalculation(double purchaseAmount) {
        {

            if (purchaseAmount > PremiumUserSlab.SLAB1.getMinValue()
                    && purchaseAmount <= PremiumUserSlab.SLAB1.getMaxValue())
                return purchaseAmount - (purchaseAmount * PremiumUserSlab.SLAB1.getDiscount());
            else if (purchaseAmount > PremiumUserSlab.SLAB2.getMinValue()
                    && purchaseAmount <= PremiumUserSlab.SLAB2.getMaxValue()) {
                double discountSlab1 = (PremiumUserSlab.SLAB2.getMinValue() - PremiumUserSlab.SLAB1.getMinValue())
                        * PremiumUserSlab.SLAB1.getDiscount();
                double discountSlab2 = (purchaseAmount - PremiumUserSlab.SLAB2.getMinValue())
                        * PremiumUserSlab.SLAB2.getDiscount();
                return purchaseAmount - (discountSlab1 + discountSlab2);
            } else if (purchaseAmount > PremiumUserSlab.SLAB3.getMinValue()
                    && purchaseAmount <= PremiumUserSlab.SLAB3.getMaxValue()) {
                double discountSlab1 = (PremiumUserSlab.SLAB2.getMinValue() - PremiumUserSlab.SLAB1.getMinValue())
                        * PremiumUserSlab.SLAB1.getDiscount();
                double discountSlab2 = (purchaseAmount - PremiumUserSlab.SLAB2.getMaxValue())
                        * PremiumUserSlab.SLAB3.getDiscount();
                double discountSlab3 = (PremiumUserSlab.SLAB3.getMinValue() - PremiumUserSlab.SLAB2.getMinValue())
                        * PremiumUserSlab.SLAB2.getDiscount();
                return purchaseAmount - (discountSlab1 + discountSlab2 + discountSlab3);
            } else if (purchaseAmount > PremiumUserSlab.SLAB4.getMinValue()) {
                double discountSlab1 = (PremiumUserSlab.SLAB2.getMinValue() - PremiumUserSlab.SLAB1.getMinValue())
                        * PremiumUserSlab.SLAB1.getDiscount();
                double discountSlab2 = (PremiumUserSlab.SLAB3.getMinValue() - PremiumUserSlab.SLAB2.getMinValue())
                        * PremiumUserSlab.SLAB2.getDiscount();
                double discountSlab3 = (PremiumUserSlab.SLAB4.getMinValue() - PremiumUserSlab.SLAB3.getMinValue())
                        * PremiumUserSlab.SLAB3.getDiscount();
                double discountSlab4 = (purchaseAmount - PremiumUserSlab.SLAB4.getMinValue())
                        * PremiumUserSlab.SLAB4.getDiscount();
                return purchaseAmount - (discountSlab1 + discountSlab2 + discountSlab3 + discountSlab4);
            }

            return 0;
        }

    }
}

