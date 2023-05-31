package com.vzcodingassignment.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegularBillingDiscountServiceImplTest {

    // this is  for user type - Regular type
    @InjectMocks
    private RegularBillingDiscountServiceImpl billingDiscountService;

    //input : customer type - regular,premium ; 0
    @Test
    public void testDiscountCalculationWithTestCase1(){
        assertEquals("0",billingDiscountService.discountCalculation(0).getBillAmount());
    }

    //input customer type - premium,premium : 5000,o/p -3600
    @Test
    public void testDiscountCalculationWithTestCase2(){
        assertEquals("5000", billingDiscountService.discountCalculation(5000).getBillAmount());
    }

    //input customer type - premium,premium : 12000,o/p -10200
    @Test
    public void testDiscountCalculationWithTestCase3(){
        assertEquals("9500",billingDiscountService.discountCalculation(10000).getBillAmount());
    }

    //input customer type - premium,premium : 20000,o/p -15800
    @Test
    public void testDiscountCalculationWithTestCase4(){
        assertEquals("13500", billingDiscountService.discountCalculation(15000).getBillAmount());
    }
}
