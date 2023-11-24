package com.cleanarch.infrastructure.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ErrorDetailsTest {

	@Test
	@DisplayName("Given an ErrorDetails object, when the object is created, then the ErrorDetails object should not be null")
	public void testErrorDetails_WhenObjectIsCreated_ThenObjectShouldNotBeNull() {
		// Given an ErrorDetails object with some dummy data
		ErrorDetails errorDetails = new ErrorDetails("expectedData", 400);

		// Then the ErrorDetails object should not be null
		Assertions.assertThat(errorDetails).isNotNull();
		Assertions.assertThat(errorDetails.statusCode()).isEqualTo(400);
	}

}