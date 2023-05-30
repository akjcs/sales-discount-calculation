package com.vzcodingassignment.util;

import java.text.DecimalFormat;

/**
 * @author amitkumar.jha
 *
 */
public class FormatNumber {

	public static String formatDecimalValue(double value) throws NumberFormatException {

		DecimalFormat df = new DecimalFormat("#");
		return df.format(value);

	}
}
