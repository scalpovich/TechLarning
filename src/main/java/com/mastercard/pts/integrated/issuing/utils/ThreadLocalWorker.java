package com.mastercard.pts.integrated.issuing.utils;

public class ThreadLocalWorker {

	static final class TestContextLocal extends ThreadLocal<TestContext> {
		@Override
		protected TestContext initialValue() {
			return new TestContext();
		}
	}

	private static final ThreadLocal<TestContext> userThreadLocal = new TestContextLocal();

	public static TestContext getTestContext() {
		return userThreadLocal.get();
	}
}
