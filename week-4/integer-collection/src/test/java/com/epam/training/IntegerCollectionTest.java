package com.epam.training;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class IntegerCollectionTest {

	private IntegerCollection underTest;

	@BeforeEach
	public void init() {
		underTest = new IntegerCollection(new int[]{ 7, 6, 5, 4, 3, 2, 1 });
	}
	
	@Test
	public void testAddShouldAddTheGivenValueToTheCollection() {
		// Given
		underTest = new IntegerCollection(1);
		IntegerCollection expected = new IntegerCollection(new int[] {1});
		IntegerCollection actual = underTest;
		
		// When
		underTest.add(1);

		// Then
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddShouldThrowAnIllegalArgumentExceptionWhenTheCollectionIsFull() {
		// Given
		underTest = new IntegerCollection(0);

		// When, then
		assertThrows(IllegalArgumentException.class, () -> underTest.add(0));
	}
	
	@Test
	public void testSortShouldOrderTheIntegersCorrectly() {
		// Given
		int[] expected = { 1, 2, 3, 4, 5, 6, 7 };

		// When
		int[] actual = underTest.sort();

		// Then
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testContainsShouldReturnTrueWhenItContainsTheGivenValue() {
		// Given
		boolean expected = true;

		// When
		boolean actual = underTest.contains(5);

		// Then
		assertEquals(expected, actual);
	}

	@Test
	public void testContainsShouldReturnFalseWhenItDoesNotContainTheGivenValue() {
		// Given
		boolean expected = false;

		// When
		boolean actual = underTest.contains(8);

		// Then
		assertEquals(expected, actual);
	}
	
}
