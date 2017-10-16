package com.mastercard.pts.integrated.issuing.context;

import org.springframework.stereotype.Component;

/**
 * this class is noting but providing single instance of MPTSTestContext object
 * at run time throughout the project execution context
 * 
 * so we can use anywhere UserTestContextProvider.get() this will give you same
 * instance of MPTSTestContext every time after first initialization
 * 
 * And inside LMIThreadLocal we can set and get test data which we will be using
 * between flow for stories
 * 
 * @author e058829
 *
 */
@Component
public class CustomTestContextProvider {

	private static final ThreadLocal<CustomTestContext> userThreadLocal = new TestContextLocal();

	static final class TestContextLocal extends ThreadLocal<CustomTestContext> {

		@Override
		protected CustomTestContext initialValue() {
			return new CustomTestContext();
		}
	}

	public static CustomTestContext get() {
		return userThreadLocal.get();
	}

}
