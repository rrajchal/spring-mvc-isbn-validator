package com.rajesh;

import junit.framework.TestCase;

public class IsbnValidatorTest extends TestCase {

	public void testIsbnValidator() {
		System.out.println("Testing IsbnValidatorTest...");
		
		IsbnValidator isbn = new IsbnValidator("");
		
		String good[] = getGoodData();
		String bad[] = getBadData();
		
		for (String g : good) {
			isbn = new IsbnValidator(g);
			System.out.println(g);
			assertEquals(isbn.getValidate().booleanValue(), true);
		}
		
		for (String b : bad) {
			isbn = new IsbnValidator(b);
			System.out.println(b);
			assertEquals(isbn.getValidate().booleanValue(), false);
		}
		
		System.out.println("###########Tested Good##########");

	}
	
	public String [] getGoodData () {
		return new String[] {
				"0-9752298-0-X", 
				"097522980X", 
				"99921-58-10-7", 
				"9971-5-0210-0", 
				"960-425-059-0", 
				"80-902734-1-6", 
				"85-359-0277-5", 
				"1-84356-028-3", 
				"0-684-84328-5", 
				"0-8044-2957-X", 
				"0-85131-041-9", 
				"93-86954-21-4", 
				"0-943396-04-2", 
				"0-9752298-0-X", 
				"9992158107", 
				"9971502100", 
				"9604250590", 
				"8090273416", 
				"8535902775", 
				"1843560283", 
				"0684843285", 
				"080442957X", 
				"0851310419", 
				"9386954214", 
				"0943396042", 
				"097522980X" };
	}

	public String [] getBadData () {
		return new String[] {
				"0-9752298-0-Y", 
				"097522981X", 
				"99921-58-10-X", 
				"123", 
				"960-425-059-1", 
				"80-902734-1-7", 
				"85-359-0277-*", 
				"abcdefghijk", 
				"abcdefghij", 
				"abcdefgh", 
				"a", 
				"" };
	}
	

}
