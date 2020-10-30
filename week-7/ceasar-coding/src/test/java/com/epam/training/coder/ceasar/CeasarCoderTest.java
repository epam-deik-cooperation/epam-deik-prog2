package com.epam.training.coder.ceasar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CeasarCoderTest {

	private CeasarCoder underTest = new CeasarCoder(3);

	@Test
	public void testEncodeShouldWorkCorrectly() {
		// Given
		String input = "he told me i could never teach a llama to drive";
		String expected = "kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh";

		// When
		String actual = underTest.encode(input);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testDecodeShouldWorkCorrectly() {
		// Given
		String input = "kh wrog ph l frxog qhyhu whdfk d oodpd wr gulyh";
		String expected = "he told me i could never teach a llama to drive";

		// When
		String actual = underTest.decode(input);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testConstructorShouldThrowIllegalArgumentExceptionWhenOffsetParameterIsGreaterThen127() {
		// Given
		
		// When
		assertThrows(IllegalArgumentException.class, () -> new CeasarCoder(128));

		// Then
	}
	
	@Test
	public void testConstructorShouldThrowIllegalArgumentExceptionWhenOffsetParameterIsLessThen1() {
		// Given
		
		// When
		assertThrows(IllegalArgumentException.class, () -> new CeasarCoder(0));

		// Then
	}
	
}
