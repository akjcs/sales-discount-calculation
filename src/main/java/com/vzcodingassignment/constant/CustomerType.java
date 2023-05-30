package com.vzcodingassignment.constant;


/**
 * @author amitkumar.jha
 *
 */
public enum CustomerType {

	REGULAR("Regular"),
	PREMIUM("Premium");

	public final String customerType;

	private CustomerType(String value) {
		this.customerType = value;
	}

	public String getCustomerType() {
		return customerType;
	}

}
