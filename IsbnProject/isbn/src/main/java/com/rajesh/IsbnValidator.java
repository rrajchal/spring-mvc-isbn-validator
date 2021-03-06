package com.rajesh;

import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This is a class to check if a string is a valid ISBN number
 */
public class IsbnValidator {
	private boolean validate;
	private boolean even;

	public IsbnValidator(String userInput){
		validate(userInput);
	}

	private void validate(String userInput) {
		// first we replace - and white spaces with blanks
		String isbn = userInput.replace("-", "").replace(" ", ""); 
		switch (isbn.length()) {
			case 10:
				this.validate = isValidISBN10(isbn);
				break;
			case 13: 
				this.validate = isValidISBN13(isbn);
				break;
			default:
				this.validate = false;
		}
	}

	/*
	 * validate 10 digit ISBN number
	 */
	private Boolean isValidISBN10(String isbn) {
		boolean result = false;
		
        // isbn10 have 10 chars with the first 9 chars as numbers and last one can be a number or 'X'
		String patternString = "^\\d{9}[\\d,X]{1}$";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(isbn);
		boolean matches = matcher.matches();
		
		if (matches) {
			int sum = 0;
			for ( int i = 0; i < 9; i++ ) {
				sum += charToNumber(isbn.charAt(i)) * (i + 1);
			}
			sum += (isbn.charAt(9) == 'X' ? 10 : charToNumber(isbn.charAt(9))) * 10;
			result = sum % 11 == 0;
		}
		return result;
	}

	/*
	 * validate 13 digit ISBN number
	 */
	private Boolean isValidISBN13(String isbn) {
		boolean result = false;
				
		String patternString = "^\\d{13}$";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(isbn);
		boolean matches = matcher.matches();
		if (matches) {
			int sum = isbn.chars()
						  .map(new IntUnaryOperator() {
							public int applyAsInt(int x) {
								return charToNumber((char) x) * (isOddNumber() ? 3 : 1);
							}
						})
					      .sum();
			result = sum % 10 == 0;
		}
		return result;
	}
	
	private boolean isOddNumber() {
		return !even;
	}

	private int charToNumber(char c) {
		return c - '0'; 
	}
	
	public Boolean getValidate() {
		return validate;
	}

	public void setValidate(Boolean validate) {
		this.validate = validate;
	}
}
