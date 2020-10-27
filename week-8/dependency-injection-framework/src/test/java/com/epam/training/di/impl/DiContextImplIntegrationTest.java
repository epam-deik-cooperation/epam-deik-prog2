package com.epam.training.di.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.epam.training.di.Configuration;
import com.epam.training.di.DiContext;
import com.epam.training.di.annotation.Bean;
import com.epam.training.di.annotation.Qualifier;

public class DiContextImplIntegrationTest {

	private DiContext context = new DiContextBuilder().build(new DiContextImplIntegrationTest.ContextConfig());

	@Test
	public void testGetBeanShouldReturnWithStringAWhenThisBeanExists() {
		// Given
		String expected = "StringA";

		// When
		Optional<String> actual = context.getBean("stringBeanA", String.class);

		// Then
		assertTrue(actual.isPresent());
		assertEquals(expected, actual.get());
	}

	@Test
	public void testGetBeanShouldReturnWithStringBWhenThisBeanExists() {
		// Given
		String expected = "StringB";

		// When
		Optional<String> actual = context.getBean("stringBeanB", String.class);

		// Then
		assertTrue(actual.isPresent());
		assertEquals(expected, actual.get());
	}

	@Test
	public void testGetBeanShouldReturnWithIntegerBeanWhenGetIsCalledWithTypeOnly() {
		// Given
		Integer expected = 10;

		// When
		Optional<Integer> actual = context.getBean(Integer.class);

		// Then
		assertTrue(actual.isPresent());
		assertEquals(expected, actual.get());
	}

	@Test
	public void testGetBeanShouldReturnWithStringBuilderBeanWhenGetIsCalledWithTypeOnly() {
		// Given
		String expected = "StringA10";

		// When
		Optional<StringBuilder> actual = context.getBean(StringBuilder.class);

		// Then
		assertTrue(actual.isPresent());
		assertEquals(expected, actual.get().toString());
	}

	@Test
	public void testGetBeanShouldReturnWithOptionalEmptyWhenBeanDoesNotExist() {
		// Given

		// When
		Optional<String> actual = context.getBean("stringBean", String.class);

		// Then
		assertTrue(actual.isEmpty());
	}

	@Test
	public void testGetBeanShouldThrowAnExceptionWhenMoreBeansAreAvailable() {
		// Given

		// When Then
		assertThrows(IllegalArgumentException.class, () -> context.getBean(String.class));
	}

	public static class ContextConfig implements Configuration {

		@Bean
		public String stringBeanA() {
			return "StringA";
		}

		@Bean
		public String stringBeanB() {
			return "StringB";
		}

		@Bean
		public Integer integerBean() {
			return 10;
		}

		@Bean
		public StringBuilder stringBuilder(@Qualifier(name = "stringBeanA") String string, Integer integer) {
			return new StringBuilder(string).append(integer);
		}

	}

}
