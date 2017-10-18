package com.mastercard.pts.integrated.issuing.utils;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;

import com.google.common.base.Strings;

public class SoftAssert {
	
	private final StringDescription description;

	public SoftAssert() {
		this.description = new StringDescription();
	}
	
	public static <T> SoftAssert that(T actual, Matcher<T> matcher) {
		return that("", actual, matcher);
	}
	
	public static <T> SoftAssert that(String reason, T actual, Matcher<T> matcher) {
		return new SoftAssert().andThat(reason, actual, matcher);
	}
	
	public <T> SoftAssert andThat(T actual, Matcher<T> matcher) {
		return andThat("", actual, matcher);
	}
	
	public <T> SoftAssert andThat(String reason, T actual, Matcher<T> matcher) {
		if (matcher.matches(actual)) {
			return this;
		}
		
		if (!Strings.isNullOrEmpty(reason)) {
			description.appendText(reason);
		}
		
		description.appendText("\nExpected: ");
		description.appendDescriptionOf(matcher);
		description.appendText("\n     got: ");
		description.appendValue(actual);
		description.appendText("\n");
		
		return this;
	}
	
	public void assertAll() {
		String fullDescription = description.toString();
		Assert.assertTrue(fullDescription, fullDescription.isEmpty());
	}
}
