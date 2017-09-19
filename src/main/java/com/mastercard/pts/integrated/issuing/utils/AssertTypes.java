package com.mastercard.pts.integrated.issuing.utils;

import org.junit.Assert;

public class AssertTypes {

	public static void assertTrue(boolean condition) {
		assertTrue(null, condition);
	}

	public static void assertTrue(String message, boolean condition) {
		if (message == null) {
			Assert.assertTrue(condition);
		} else {
			Utils.logged(message);
			Assert.assertTrue(message, condition);
		}
	}

	public static void assertFalse(boolean condition) {
		assertFalse(null, condition);
	}

	public static void assertFalse(String message, boolean condition) {
		if (message == null) {
			Assert.assertFalse(condition);
		} else {
			Utils.logged(message, true);
			Assert.assertFalse(message, condition);
		}
	}

	public static void assertEquals(String strActual, String strExpected) {

		Utils.logged("Actual String" + strActual);
		Utils.logged("Expected String" + strExpected);
		Assert.assertEquals(strActual, strExpected);

	}

	public static void assertEquals(String message, String strActual,
			String strExpected) {

		Utils.logged("Actual String" + strActual);
		Utils.logged("Expected String" + strExpected);
		if (message == null) {
			Assert.assertEquals(strActual, strExpected);
		} else {
			Utils.logged(message);
			Assert.assertEquals(message, strActual, strExpected);
		}

	}

	/*
	 * public static void verifyTrue(boolean condition) { //
	 * softAssertions.assertThat(condition);
	 * 
	 * }
	 * 
	 * public static void verifyTrue(String message, boolean condition) { if
	 * (message != null) { Utils.logged(message); } //
	 * softAssertions.assertThat(condition);
	 * 
	 * }
	 * 
	 * public static void verifyFalse(boolean condition) { //
	 * softAssertions.assertThat(!condition); }
	 * 
	 * public static void verifyFalse(String message, boolean condition) { if
	 * (message != null) { Utils.logged(message); } //
	 * softAssertions.assertThat(!condition);
	 * 
	 * }
	 * 
	 * public static void verifyEquals(String strActual, String strExpected) {
	 * 
	 * Utils.logged("Actual String" + strActual); Utils.logged("Expected String"
	 * + strExpected); //
	 * softAssertions.assertThat(strActual.equals(strExpected)); }
	 * 
	 * public static void verifyEquals(String message, String strActual, String
	 * strExpected) {
	 * 
	 * Utils.logged("Actual String" + strActual); Utils.logged("Expected String"
	 * + strExpected); if (message != null) { Utils.logged(message);
	 * 
	 * } // softAssertions.assertThat(strActual.equals(strExpected)); }
	 * 
	 * public static void verifyContains(String strActual, String strExpected) {
	 * 
	 * Utils.logged("Actual String" + strActual); Utils.logged("Expected String"
	 * + strExpected); //
	 * softAssertions.assertThat(strActual.contains(strExpected)); }
	 * 
	 * public static void verifyContains(String message, String strActual,
	 * String strExpected) {
	 * 
	 * Utils.logged("Actual String" + strActual); Utils.logged("Expected String"
	 * + strExpected); if (message != null) { Utils.logged(message);
	 * 
	 * } // softAssertions.assertThat(strActual.contains(strExpected)); }
	 */
}
