package com.vzcodingassignment.constant;

import com.vzcodingassignment.exception.IllegalStateException;

public enum RegularUserSlab {
	SLAB1(0, 5000, 0.0f),
	SLAB2(5000, 10000, 0.1f),
	SLAB3(10000, Integer.MAX_VALUE, 0.2f);

	private final double minValue;
	private final double maxValue;
	private final double discount;

	RegularUserSlab(final double minValue, final double maxValue, final double discount) {
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
