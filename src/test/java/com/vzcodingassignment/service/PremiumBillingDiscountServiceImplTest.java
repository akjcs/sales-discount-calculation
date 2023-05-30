package com.vzcodingassignment.service;

import com.vzcodingassignment.util.FormatNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PremiumBillingDiscountServiceImplTest {

   //this is for userType -Premium
   BillingDiscountService billingDiscountService = new PremiumBillingDiscountServiceImpl();

    //input customer type - premium,premium ; 0
    @Test
    public void testDiscountCalculationWithTestCase1(){
        assertEquals(0,billingDiscountService.discountCalculation(0));
    }

    //input customer type - premium,premium : 4000,o/p -3600
    @Test
    public void testDiscountCalculationWithTestCase2(){
        assertEquals(3600, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(4000))));
    }

    //input customer type - premium,premium : 12000,o/p -10200
    @Test
    public void testDiscountCalculationWithTestCase3(){
        assertEquals(10200, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(12000))));
    }

    //input customer type - premium,premium : 20000,o/p -15800
    @Test
    public void testDiscountCalculationWithTestCase4(){
        assertEquals(15800, Integer.parseInt(FormatNumber.formatDecimalValue(billingDiscountService.discountCalculation(20000))));
    }
}
