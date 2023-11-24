package com.cleanarch.infrastructure.exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class UserValidationExceptionTest {

	@Mock
	private UserValidationException userValidationException;

	@InjectMocks
	private GlobalExceptionHandler globalExceptionHandler;

	@BeforeEach
	public void setup() {
		when(userValidationException.getMessage()).thenReturn("Validation failed");
	}

	@Test
	@DisplayName("Given a UserValidationException, when the exception is handled, then the error details are returned")
	public void testHandleUserValidationException_WhenExceptionIsHandled_ThenReturnErrorDetails() {
		// Arrange
		String errorMessage = "Validation failed";
		ErrorDetails expectedErrorDetails = new ErrorDetails(errorMessage, HttpStatus.BAD_REQUEST.value());

		// Act
		ResponseEntity<ErrorDetails> responseEntity = globalExceptionHandler
				.handleUserValidationException(userValidationException);

		// Assert
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(responseEntity.getBody()).isEqualTo(expectedErrorDetails);

		verify(userValidationException).getMessage();
	}
}