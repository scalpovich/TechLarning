package com.mastercard.pts.integrated.issuing.domain.provider;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
public interface KeyValueProvider {

	String getString(String key);
	
	default String getString(String key, String defaultValue) {
		String value = getString(key);
		return value != null
				? value
				: defaultValue;
	}
	
	default List<String> getListOfStrings(String key) {
		String value = getString(key);
		return value == null
				? Collections.emptyList()
				: Arrays.asList(value.split(";"));
	}
	
	default Integer getInt(String key) {
		String value = getString(key);
		return value == null
				? null
				: Integer.valueOf(getString(key));
	}
	
	default Long getLong(String key) {
		String value = getString(key);
		return value == null
				? null
				: Long.valueOf(getString(key));
	}
	
	default Double getDouble(String key) {
		String value = getString(key);
		return value == null
				? null
				: Double.valueOf(getString(key));
	}
	
	default Boolean getBoolean(String key) {
		String value = getString(key);
		return value == null
				? null
				: Boolean.valueOf(getString(key));
	}
}
