package com.vzcodingassignment.constant;

/**
 * @author amitkumar.jha
 *
 */
public enum PremiumUserSlab {

	SLAB1(0, 4000, 0.1f),
	SLAB2(4000, 8000, 0.15f),
	SLAB3(8000, 12000, 0.2f),
	SLAB4(12000, Integer.MAX_VALUE, 0.3f);

	private final double minValue;
	private final double maxValue;
	private final double discount;


	PremiumUserSlab(int minValue, int maxValue, float discount) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.discount = discount;

	}


	public double getMinValue() {
		return this.minValue;
	}

	public double getMaxValue() {
		return this.maxValue;
	}

	public double getDiscount() {
		return this.discount;
	}
}
