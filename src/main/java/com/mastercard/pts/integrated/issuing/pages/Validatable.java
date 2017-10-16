package com.mastercard.pts.integrated.issuing.pages;

import java.util.Optional;

@FunctionalInterface
public interface Validatable {

	Optional<String> getErrorMessage();
	
	default void validate() {
		Optional<String> message = getErrorMessage();
		if (message.isPresent()) {
			throw new ValidationException(message.get());
		}
	}
}
