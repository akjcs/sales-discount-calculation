package com.vzcodingassignment.constant;


import com.vzcodingassignment.exception.IllegalStateException;

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

	public static CustomerType valueType(String type)  {
		CustomerType[] customerType = values();
		for (CustomerType c : customerType) {
			if (c.getCustomerType().equalsIgnoreCase(type))
				return c;
		}
		throw new IllegalStateException("Please enter a valid customer type");
	}

}
