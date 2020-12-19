package com.stefanini;

import org.apache.commons.lang3.StringUtils;

public class ChangeString {

	public String build(String value) {

		if (StringUtils.isBlank(value)) {
			return "El valor ingresado no puede ser NULL.";
		}

		String changedValue = new String("");

		for (int i = 0; i < value.length(); i++) {
			int nCharValue = (int) value.charAt(i);

			if (nCharValue == 110) {
				nCharValue = 241;
			} else if (nCharValue == 241) {
				nCharValue = 111;
			} else if (nCharValue == 78) {
				nCharValue = 209;
			} else if (nCharValue == 209) {
				nCharValue = 79;
			} else if (nCharValue == 122) {
				nCharValue = 97;
			} else if (nCharValue == 90) {
				nCharValue = 65;
			} else if ((nCharValue >= 97 && nCharValue <= 121) || (nCharValue >= 65 && nCharValue <= 89)) {
				nCharValue++;
			}

			changedValue += String.valueOf((char) nCharValue);
		}

		return changedValue;
	}

	public static void main(String[] args) {
		String value = "123 abcd*3";
//		String value = "**Casa 52";

		ChangeString changeString = new ChangeString();
		String changedValue = changeString.build(value);

		System.out.println(changedValue);
	}
}
