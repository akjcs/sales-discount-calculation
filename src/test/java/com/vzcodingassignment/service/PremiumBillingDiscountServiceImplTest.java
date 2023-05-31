package com.vzcodingassignment.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PremiumBillingDiscountServiceImplTest {

   //this is for userType -Premium
   @InjectMocks
   PremiumBillingDiscountServiceImpl premiumBillingService;



    //input customer type - premium,premium ; 0
    @Test
    public void testDiscountCalculationWithTestCase1(){
        assertEquals("0",premiumBillingService.discountCalculation(0).getBillAmount());
    }

    //input customer type - premium,premium : 4000,o/p -3600
    @Test
    public void testDiscountCalculationWithTestCase2(){
        assertEquals("3600", premiumBillingService.discountCalculation(4000).getBillAmount());
    }

    //input customer type - premium,premium : 8000,o/p -7000
    @Test
    public void testDiscountCalculationWithTestCase3(){
        assertEquals("7000", premiumBillingService.discountCalculation(8000).getBillAmount());
    }

    //input customer type - premium,premium : 12000,o/p -10200
    @Test
    public void testDiscountCalculationWithTestCase4(){
        assertEquals("10200", premiumBillingService.discountCalculation(12000).getBillAmount());
    }

    //input customer type - premium,premium : 20000,o/p -15800
    @Test
    public void testDiscountCalculationWithTestCase5(){
        assertEquals("15800", premiumBillingService.discountCalculation(20000).getBillAmount());
    }
}
