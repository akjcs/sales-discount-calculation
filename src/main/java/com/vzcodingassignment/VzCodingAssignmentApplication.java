package com.vzcodingassignment;

import com.vzcodingassignment.constant.CustomerType;
import com.vzcodingassignment.service.BillingDiscountService;
import com.vzcodingassignment.service.PremiumBillingDiscountServiceImpl;
import com.vzcodingassignment.service.RegularBillingDiscountServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author amitkumar.jha
 *
 */
@SpringBootApplication
public class VzCodingAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(VzCodingAssignmentApplication.class, args);
		String customerType = "Premium";
		BillingDiscountService billingDiscountService = null;
		if (customerType.equalsIgnoreCase(CustomerType.PREMIUM.getCustomerType())) {
			billingDiscountService = new PremiumBillingDiscountServiceImpl();
		} else {
			billingDiscountService = new RegularBillingDiscountServiceImpl();
		}
		System.out.print(billingDiscountService.discountCalculation(4000));
	}

}
