package com.vzcodingassignment.constant;

public enum RegularUserSlab {
	SLAB1(0, 5000, 0.0f),
	SLAB2(5000, 10000, 0.1f),
	SLAB3(10000, Integer.MAX_VALUE, 0.2f);

	private final int minValue;
	private final int maxValue;
	private final float discount;


	RegularUserSlab(int minValue, int maxValue, float discount) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.discount = discount;
	}


	public int getMinValue() {
		return minValue;
	}


	public int getMaxValue() {
		return maxValue;
	}


	public float getDiscount() {
		return discount;
	}

}
