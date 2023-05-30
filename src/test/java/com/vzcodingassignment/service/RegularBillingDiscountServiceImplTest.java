package com.vzcodingassignment.service;

import com.vzcodingassignment.util.FormatNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularBillingDiscountServiceImplTest {

    // this is  for user type - Regular type
    BillingDiscountService billingDiscountService = new RegularBillingDiscountServiceImpl();

    //input : customer type - regular,premium ; 0
    @Test
    public void testDiscountCalculationWithTestCase1(){
        assertEquals(0,billingDiscountService.discountCalculation(0));
    }

    //input customer type - premium,premium : 5000,o/p -3600
    @Test
    public void testDiscountCalculationWithTestCase2(){
        assertEquals(5000, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(5000))));
    }

    //input customer type - premium,premium : 12000,o/p -10200
    @Test
    public void testDiscountCalculationWithTestCase3(){
        assertEquals(9500, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(10000))));
    }

    //input customer type - premium,premium : 20000,o/p -15800
    @Test
    public void testDiscountCalculationWithTestCase4(){
        assertEquals(13500, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(15000))));
    }
}
