package com.mastercard.pts.integrated.issuing.domain.provider;

import java.util.Map;

import java.util.Optional;
@FunctionalInterface
public interface DataLoader {
	
	Optional<Map<String, String>> loadData(String storyName);
}
