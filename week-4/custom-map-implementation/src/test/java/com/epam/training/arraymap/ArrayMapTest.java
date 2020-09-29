package com.epam.training.arraymap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayMapTest {

  private static final String TEST_KEY = "key";
  private static final String TEST_VALUE = "value";
  private static final String NEW_TEST_VALUE = "newValue";

  private static final ArrayMap<String, String> EMPTY_MAP = new ArrayMap<>();

  @ParameterizedTest
  @MethodSource("provideMapForSize")
  public void sizeShouldReturnCorrectSizeForGivenMap(Map<String, String> arrayMap, int expectedSize) {
    // Given

    // When
    int actualSize = arrayMap.size();

    // Then
    assertThat(actualSize, equalTo(expectedSize));
  }

  @ParameterizedTest
  @MethodSource("provideMapForSize")
  public void isEmptyShouldReturnCorrectValueForGivenMap(Map<String, String> arrayMap, int expectedSize) {
    // Given
    boolean expectedIsEmpty = expectedSize <= 0;

    // When
    boolean actualIsEmpty = arrayMap.isEmpty();

    // Then
    assertThat(actualIsEmpty, equalTo(expectedIsEmpty));
  }

  @ParameterizedTest
  @MethodSource("provideMapForContainsKeyOrValue")
  public void containsKeyShouldReturnCorrectContainsKeyForGivenMap(Map<String, String> arrayMap, String key, boolean expectedContainsKey) {
    // Given

    // When
    boolean actualContainsKey = arrayMap.containsKey(key);

    // Then
    assertThat(actualContainsKey, equalTo(expectedContainsKey));
  }

  @ParameterizedTest
  @MethodSource("provideMapForContainsKeyOrValue")
  public void containsValueShouldReturnCorrectContainsValueForGivenMap(Map<String, String> arrayMap, String key, boolean expectedContainsValue) {
    // Given

    // When
    boolean actualContainsKey = arrayMap.containsValue(key);

    // Then
    assertThat(actualContainsKey, equalTo(expectedContainsValue));
  }

  @ParameterizedTest
  @MethodSource("provideMapForGet")
  public void getShouldReturnCorrectValueForGivenMap(Map<String, String> arrayMap, String key, String expectedValue) {
    // Given

    // When
    String actualValue = arrayMap.get(key);

    // Then
    assertThat(actualValue, equalTo(expectedValue));
  }

  @Test
  public void putShouldAddNewValueAndReturnPreviousOne() {
    // Given
    Map<String, String> arrayMap = generateGivenSizeMap(3);
    arrayMap.put(TEST_KEY, TEST_VALUE);

    // When
    String previousValue = arrayMap.put(TEST_KEY, NEW_TEST_VALUE);

    // Then
    assertThat(previousValue, equalTo(TEST_VALUE));
    assertThat(arrayMap.get(TEST_KEY), equalTo(NEW_TEST_VALUE));

  }

  @Test
  public void putShouldCorrectlyExpandInnerArraysIfNeeded() {
    // Given

    // When
    Map<String, String> arrayMap = generateGivenSizeMap(100);

    // Then
    assertThat(arrayMap.size(), equalTo(100));
    for(int i = 0; i < 100; i++) {
      String keyValue = String.valueOf(i);
      assertThat(arrayMap.get(keyValue), equalTo(keyValue));
    }
  }

  @Test
  public void removeShouldDeleteKeyAndValueFromMap() {
    // Given
    Map<String, String> arrayMap = new ArrayMap<>();
    arrayMap.put(TEST_KEY, TEST_VALUE);

    // When
    arrayMap.remove(TEST_KEY);

    // Then
    assertThat(arrayMap.size(), equalTo(0));
    assertThat(arrayMap.containsKey(TEST_KEY), equalTo(false));
    assertThat(arrayMap.containsValue(TEST_VALUE), equalTo(false));
  }

  @Test
  public void putAllShouldAddAllEntriesToMap() {
    // Given
    Map<String, String> originalMap = generateGivenSizeMap(10);
    Map<String, String> resultMap = new ArrayMap<>();

    // When
    resultMap.putAll(originalMap);

    // Then
    for(int i = 0; i < 10; i++) {
      String keyValue = String.valueOf(i);
      assertThat(resultMap.get(keyValue), equalTo(keyValue));
    }
  }

  @Test
  public void clearShouldRemoveAllKeysAndValues() {
    // Given
    Map<String, String> arrayMap = generateGivenSizeMap(2);
    arrayMap.put(TEST_KEY, TEST_VALUE);

    // When
    arrayMap.clear();

    // Then
    assertThat(arrayMap.size(), equalTo(0));
    assertThat(arrayMap.get(TEST_KEY), equalTo(null));
  }

  @Test
  public void keySetShouldReturnSetContainingAllKeys() {
    // Given
    Map<String, String> arrayMap = generateGivenSizeMap(3);

    // When
    Set<String> keySet = arrayMap.keySet();

    // Then
    assertThat(keySet.size(), equalTo(3));
    for(int i = 0; i < 3; i++) {
      String k = String.valueOf(i);
      assertThat(keySet.contains(k), equalTo(true));
    }
  }

  @Test
  public void valueShouldReturnCollectionContainingAllValues() {
    // Given
    Map<String, String> arrayMap = generateGivenSizeMap(3);

    // When
    Collection<String> values = arrayMap.values();

    // Then
    assertThat(values.size(), equalTo(3));
    for(int i = 0; i < 3; i++) {
      String k = String.valueOf(i);
      assertThat(values.contains(k), equalTo(true));
    }
  }

  @Test
  public void entrySetShouldReturnSetContainingAllEntries() {
    // Given
    Map<String, String> arrayMap = generateGivenSizeMap(3);

    // When
    Set<Map.Entry<String, String>> entries = arrayMap.entrySet();

    // Then
    assertThat(entries.size(), equalTo(3));
    for(Map.Entry<String, String> entry : entries) {
      assertThat(entry.getKey(), equalTo(entry.getValue()));
    }
  }

  private static Stream<Arguments> provideMapForSize() {
    Map<String, String> removedItemMap = generateGivenSizeMap(5);
    removedItemMap.remove(String.valueOf(2));

    Map<String, String> removedEmptyMap = generateGivenSizeMap(1);
    removedEmptyMap.remove(String.valueOf(0));

    return Stream.of(
        Arguments.of(EMPTY_MAP, 0),
        Arguments.of(generateGivenSizeMap(2), 2),
        Arguments.of(generateGivenSizeMap(10), 10),
        Arguments.of(removedItemMap, 4),
        Arguments.of(removedEmptyMap, 0)
    );
  }

  private static Stream<Arguments> provideMapForContainsKeyOrValue() {
    Map<String, String> arrayMap = generateGivenSizeMap(2);

    return Stream.of(
        Arguments.of(EMPTY_MAP, "0", false),
        Arguments.of(arrayMap, "1", true),
        Arguments.of(arrayMap, "2", false),
        Arguments.of(generateGivenSizeMap(5), "asd", false)
    );
  }

  private static Stream<Arguments> provideMapForGet() {
    Map<String, String> arrayMap = generateGivenSizeMap(2);
    arrayMap.put("key", "value");

    return Stream.of(
        Arguments.of(EMPTY_MAP, "0", null),
        Arguments.of(arrayMap, "0", "0"),
        Arguments.of(arrayMap, "2", null),
        Arguments.of(arrayMap, "key", "value")
    );
  }

  private static Map<String, String> generateGivenSizeMap(int size) {
    ArrayMap<String, String> result = new ArrayMap<>();
    IntStream.range(0, size)
        .forEachOrdered(i -> result.put(String.valueOf(i), String.valueOf(i)));

    return result;
  }

}
